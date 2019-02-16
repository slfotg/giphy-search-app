package com.github.slfotg.giphy.api.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class SearchRequest {

    @NotNull
    @NotEmpty
    private String query;
    private Integer limit;
    private Integer offset;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}
