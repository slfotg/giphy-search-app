package com.github.slfotg.giphy.api.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GifObject implements Serializable {

    private static final long serialVersionUID = 1L;

    private String type;
    private String id;
    private String slug;
    private String url;
    private String bitlyUrl;
    private String embedUrl;
    private String username;
    private String source;
    private String rating;
    private String contentUrl;
    private User user;
    private String sourceTld;
    private String sourcePostUrl;
    private String upStringStringtime;
    private String createStringtime;
    private String importStringtime;
    private String trendingStringtime;
    private Images images;
    private String title;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBitlyUrl() {
        return bitlyUrl;
    }

    public void setBitlyUrl(String bitlyUrl) {
        this.bitlyUrl = bitlyUrl;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSourceTld() {
        return sourceTld;
    }

    public void setSourceTld(String sourceTld) {
        this.sourceTld = sourceTld;
    }

    public String getSourcePostUrl() {
        return sourcePostUrl;
    }

    public void setSourcePostUrl(String sourcePostUrl) {
        this.sourcePostUrl = sourcePostUrl;
    }

    public String getUpStringStringtime() {
        return upStringStringtime;
    }

    public void setUpStringStringtime(String upStringStringtime) {
        this.upStringStringtime = upStringStringtime;
    }

    public String getCreateStringtime() {
        return createStringtime;
    }

    public void setCreateStringtime(String createStringtime) {
        this.createStringtime = createStringtime;
    }

    public String getImportStringtime() {
        return importStringtime;
    }

    public void setImportStringtime(String importStringtime) {
        this.importStringtime = importStringtime;
    }

    public String getTrendingStringtime() {
        return trendingStringtime;
    }

    public void setTrendingStringtime(String trendingStringtime) {
        this.trendingStringtime = trendingStringtime;
    }

    public Images getImages() {
        return images;
    }

    public void setImages(Images images) {
        this.images = images;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
