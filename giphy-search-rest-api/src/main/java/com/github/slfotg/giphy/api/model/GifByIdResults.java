package com.github.slfotg.giphy.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Represents the response from the Giphy API from the Gif by Id
 * endpoint
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class GifByIdResults implements Serializable {

    private static final long serialVersionUID = 1L;

    private GifObject data;
    private Metadata meta;

    public GifObject getData() {
        return data;
    }

    public void setData(GifObject data) {
        this.data = data;
    }

    public Metadata getMeta() {
        return meta;
    }

    public void setMeta(Metadata meta) {
        this.meta = meta;
    }

}
