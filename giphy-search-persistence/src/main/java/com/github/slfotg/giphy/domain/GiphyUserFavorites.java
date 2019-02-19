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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GiphyUserFavorites other = (GiphyUserFavorites) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((giphyUser == null) ? 0 : giphyUser.hashCode());
            result = prime * result + ((imageId == null) ? 0 : imageId.hashCode());
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            GiphyUserFavoritesId other = (GiphyUserFavoritesId) obj;
            if (giphyUser == null) {
                if (other.giphyUser != null)
                    return false;
            } else if (!giphyUser.equals(other.giphyUser))
                return false;
            if (imageId == null) {
                if (other.imageId != null)
                    return false;
            } else if (!imageId.equals(other.imageId))
                return false;
            return true;
        }

    }
}
