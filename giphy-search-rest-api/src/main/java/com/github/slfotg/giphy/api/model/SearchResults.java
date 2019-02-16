package com.github.slfotg.giphy.api.model;

import java.util.List;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class SearchResults {

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
