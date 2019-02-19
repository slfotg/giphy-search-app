package com.github.slfotg.giphy.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.slfotg.giphy.api.exception.InvalidRequest;
import com.github.slfotg.giphy.api.exception.MissingDataException;
import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.GifImagesRequest;
import com.github.slfotg.giphy.api.request.SaveFavoritesRequest;
import com.github.slfotg.giphy.api.request.SearchRequest;
import com.github.slfotg.giphy.api.request.TagImagesRequest;
import com.github.slfotg.giphy.api.response.ErrorResponse;
import com.github.slfotg.giphy.api.service.GiphyApiService;

@RestController
@RequestMapping("/api")
public class GiphyApiController {

    @Autowired
    private GiphyApiService giphyService;

    @GetMapping({ "", "/" })
    @ResponseBody
    public String check() {
        return "OK";
    }

    @PostMapping("/search")
    @ResponseBody
    public SearchResults search(@RequestBody @Valid SearchRequest request, BindingResult bindingResult, Errors errors)
            throws InvalidRequest {

        if (bindingResult.hasErrors()) {
            throw new InvalidRequest(errors);
        }
        return giphyService.search(request);
    }

    @GetMapping("/trending")
    @ResponseBody
    public SearchResults trending() {
        return giphyService.trending();
    }

    @GetMapping("/random")
    @ResponseBody
    public SearchResults random() {
        return giphyService.random();
    }

    @PostMapping("/images")
    @ResponseBody
    public SearchResults images(@RequestBody GifImagesRequest request) {
        return giphyService.gifsById(request.getImageIds());
    }

    @PostMapping("/favorites")
    @ResponseBody
    public String saveFavorites(@RequestBody SaveFavoritesRequest request) throws MissingDataException {
        giphyService.saveImagesToFavorites(request.getUsername(), request.getImageIds());
        return "OK";
    }

    @GetMapping("/favorites/{username}")
    @ResponseBody
    public SearchResults getFavorites(@PathVariable String username) throws MissingDataException {
        return giphyService.getFavorites(username);
    }

    @PostMapping("/tags")
    @ResponseBody
    public String saveTag(@RequestBody TagImagesRequest request) throws MissingDataException {
        giphyService.saveImagesToTag(request.getUsername(), request.getTag(), request.getImageIds());
        return "OK";
    }

    @GetMapping("/tags/{username}")
    @ResponseBody
    public List<String> getTagNames(@PathVariable String username) throws MissingDataException {
        return giphyService.getUserTags(username);
    }

    @GetMapping("/tags/{username}/{tagName}")
    @ResponseBody
    public SearchResults getTaggedImages(@PathVariable("username") String username,
            @PathVariable("tagName") String tagName) throws MissingDataException {
        return giphyService.getTaggedImages(username, tagName);
    }

    @ExceptionHandler(MissingDataException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String missingDataHandler(MissingDataException missingDataException) {
        return missingDataException.getMessage();
    }

    @ExceptionHandler(InvalidRequest.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(InvalidRequest invalidForm) {
        return invalidForm.getErrorResponse();
    }
}
