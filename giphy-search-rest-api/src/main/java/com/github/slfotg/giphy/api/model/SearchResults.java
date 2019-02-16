package com.github.slfotg.giphy.api.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Represents the response from the Giphy API from the search and trending
 * endpoints
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchResults implements Serializable {

    private static final long serialVersionUID = 1L;

    private List<GifObject> data;
    private Metadata meta;
    private Pagination pagination;

    public List<GifObject> getData() {
        return data;
    }

    public void setData(List<GifObject> data) {
        this.data = data;
    }

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

}
