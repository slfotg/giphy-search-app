package com.github.slfotg.giphy.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "GIPHY_USER_FAVORITES")
public class GiphyUserFavorites implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    GiphyUserFavoritesId id;

    public GiphyUserFavoritesId getId() {
        return id;
    }

    public void setId(GiphyUserFavoritesId id) {
        this.id = id;
    }

    public GiphyUser getGiphyUser() {
        return id.giphyUser;
    }

    public String getImageId() {
        return id.imageId;
    }

    @Embeddable
    public static class GiphyUserFavoritesId implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne
        @JoinColumn(name = "USER_ID", nullable = false)
        private GiphyUser giphyUser;

        @Column(name = "IMAGE_ID", nullable = false, length = 80)
        private String imageId;

        public GiphyUser getGiphyUser() {
            return giphyUser;
        }

        public void setGiphyUser(GiphyUser giphyUser) {
            this.giphyUser = giphyUser;
        }

        public String getImageId() {
            return imageId;
        }

        public void setImageId(String imageId) {
            this.imageId = imageId;
        }

    }
}
