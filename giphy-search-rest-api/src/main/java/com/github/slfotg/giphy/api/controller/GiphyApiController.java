package com.github.slfotg.giphy.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.slfotg.giphy.api.exception.InvalidRequest;
import com.github.slfotg.giphy.api.model.SearchResults;
import com.github.slfotg.giphy.api.request.SearchRequest;
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

    @ExceptionHandler(InvalidRequest.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(InvalidRequest invalidForm) {
        return invalidForm.getErrorResponse();
    }
}
