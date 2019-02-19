package com.github.slfotg.giphy.api.service;

import java.net.URI;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.slfotg.giphy.api.exception.MissingDataException;
import com.github.slfotg.giphy.api.exception.TagNameNotFound;
import com.github.slfotg.giphy.api.exception.UserHasNoFavorites;
import com.github.slfotg.giphy.api.exception.UsernameNotFound;
import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;
import com.github.slfotg.giphy.domain.CategorizedGifImage;
import com.github.slfotg.giphy.domain.GifCategory;
import com.github.slfotg.giphy.domain.GiphyUser;
import com.github.slfotg.giphy.domain.GiphyUserFavorites;
import com.github.slfotg.giphy.repository.CategorizedGifImageRepository;
import com.github.slfotg.giphy.repository.GifCategoryRepository;
import com.github.slfotg.giphy.repository.GiphyUserFavoritesRepository;
import com.github.slfotg.giphy.repository.GiphyUserRepository;

@Service
class DefaultGiphyApiService implements GiphyApiService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GiphyUriGenerator uriGenerator;

    @Autowired
    private GiphyUserRepository giphyUserRepo;

    @Autowired
    private GiphyUserFavoritesRepository giphyUserFavsRepo;

    @Autowired
    private GifCategoryRepository gifCategoryRepo;

    @Autowired
    private CategorizedGifImageRepository taggedGifRepo;

    @Override
    public SearchResults search(SearchRequest request) {
        URI searchURI = uriGenerator.generateSearchURI(request);
        return restTemplate.getForEntity(searchURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults trending() {
        URI trendingURI = uriGenerator.generateTrendingURI();
        return restTemplate.getForEntity(trendingURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults random() {
        URI randomURI = uriGenerator.generateRandomURI();
        return restTemplate.getForEntity(randomURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults gifById(String gifId) {
        URI gifByIdURI = uriGenerator.generateGifByIdURI(gifId);
        return restTemplate.getForEntity(gifByIdURI, SearchResults.class).getBody();
    }

    @Override
    public SearchResults gifsById(Collection<String> gifIds) {
        URI gifsByIdURI = uriGenerator.generateGifsByIdURI(gifIds);
        return restTemplate.getForEntity(gifsByIdURI, SearchResults.class).getBody();
    }

    @Override
    @Transactional
    public void saveImageToFavorites(String username, String gifId) throws UsernameNotFound {
        GiphyUser user = getGiphyUser(username);
        GiphyUserFavorites favorites = new GiphyUserFavorites(user, gifId);
        giphyUserFavsRepo.save(favorites);
    }

    @Override
    @Transactional
    public void saveImagesToFavorites(String username, Collection<String> gifIds) throws UsernameNotFound {
        GiphyUser user = getGiphyUser(username);
        giphyUserFavsRepo
                .saveAll(gifIds.stream().map(id -> new GiphyUserFavorites(user, id)).collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public void saveImagesToTag(String username, String tag, Collection<String> gifIds) throws UsernameNotFound {
        GiphyUser user = getGiphyUser(username);
        Optional<GifCategory> category = gifCategoryRepo.findOneByGiphyUserAndCategoryName(user, tag);
        GifCategory gifCategory = category.orElseGet(() -> gifCategoryRepo.save(new GifCategory(user, tag)));
        List<CategorizedGifImage> taggedImages = gifIds.stream().map(id -> new CategorizedGifImage(gifCategory, id))
                .collect(Collectors.toList());
        taggedGifRepo.saveAll(taggedImages);
    }

    @Override
    @Transactional
    public SearchResults getFavorites(String username) throws MissingDataException {
        GiphyUser user = getGiphyUser(username);
        if (!user.getFavorites().isEmpty()) {
            return gifsById(
                    user.getFavorites().stream().map(GiphyUserFavorites::getImageId).collect(Collectors.toList()));
        }
        throw new UserHasNoFavorites(username);
    }

    @Override
    @Transactional
    public SearchResults getTaggedImages(String username, String tag) throws UsernameNotFound, TagNameNotFound {
        GiphyUser user = getGiphyUser(username);
        Optional<GifCategory> category = gifCategoryRepo.findOneByGiphyUserAndCategoryName(user, tag);
        if (category.isPresent()) {
            return this.gifsById(category.get().getCategorizedImages().stream().map(CategorizedGifImage::getImageId)
                    .collect(Collectors.toList()));
        }
        throw new TagNameNotFound(username, tag);
    }

    @Override
    @Transactional
    public List<String> getUserTags(String username) throws UsernameNotFound {
        GiphyUser user = getGiphyUser(username);
        return user.getCategories().stream().map(GifCategory::getCategoryName).collect(Collectors.toList());
    }

    protected GiphyUser getGiphyUser(String username) throws UsernameNotFound {
        Optional<GiphyUser> user = giphyUserRepo.findByUsername(username);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UsernameNotFound(username);
    }

}
