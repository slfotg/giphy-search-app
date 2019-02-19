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
@Table(name = "GIF_IMAGE")
public class CategorizedGifImage implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    CategorizedGifImageId id;

    public CategorizedGifImageId getId() {
        return id;
    }

    public void setId(CategorizedGifImageId id) {
        this.id = id;
    }

    public GifCategory getCategory() {
        return id.category;
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
        CategorizedGifImage other = (CategorizedGifImage) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Embeddable
    public static class CategorizedGifImageId implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne
        @JoinColumn(name = "CATEGORY_ID", nullable = false)
        private GifCategory category;

        @Column(name = "IMAGE_ID", nullable = false, length = 80)
        private String imageId;

        public GifCategory getCategory() {
            return category;
        }

        public void setCategory(GifCategory category) {
            this.category = category;
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
            result = prime * result + ((category == null) ? 0 : category.hashCode());
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
            CategorizedGifImageId other = (CategorizedGifImageId) obj;
            if (category == null) {
                if (other.category != null)
                    return false;
            } else if (!category.equals(other.category))
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
