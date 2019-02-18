package com.github.slfotg.giphy.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
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

    @Embeddable
    public static class CategorizedGifImageId implements Serializable {

        private static final long serialVersionUID = 1L;

        @ManyToOne(cascade = CascadeType.ALL)
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

    }
}
