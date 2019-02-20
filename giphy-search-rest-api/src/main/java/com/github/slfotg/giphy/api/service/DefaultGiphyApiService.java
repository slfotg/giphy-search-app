package com.github.slfotg.giphy.api.service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.slfotg.giphy.api.exception.MissingDataException;
import com.github.slfotg.giphy.api.exception.TagNameNotFound;
import com.github.slfotg.giphy.api.exception.UsernameNotFound;
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
    private GiphyUserRepository giphyUserRepo;

    @Autowired
    private GiphyUserFavoritesRepository giphyUserFavsRepo;

    @Autowired
    private GifCategoryRepository gifCategoryRepo;

    @Autowired
    private CategorizedGifImageRepository taggedGifRepo;

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
    public Collection<String> getFavorites(String username) throws MissingDataException {
        GiphyUser user = getGiphyUser(username);
        return user.getFavorites().stream().map(GiphyUserFavorites::getImageId).collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String createTag(String username, String tagName) throws UsernameNotFound {
        GiphyUser user = getGiphyUser(username);
        return gifCategoryRepo.save(new GifCategory(user, tagName)).getCategoryName();
    }

    @Override
    @Transactional
    public Collection<String> getTaggedImages(String username, String tag) throws UsernameNotFound, TagNameNotFound {
        GiphyUser user = getGiphyUser(username);
        Optional<GifCategory> category = gifCategoryRepo.findOneByGiphyUserAndCategoryName(user, tag);
        if (category.isPresent()) {
            return category.get().getCategorizedImages().stream().map(CategorizedGifImage::getImageId)
                    .collect(Collectors.toList());
        }
        throw new TagNameNotFound(username, tag);
    }

    @Override
    @Transactional
    public Collection<String> getUserTags(String username) throws UsernameNotFound {
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
