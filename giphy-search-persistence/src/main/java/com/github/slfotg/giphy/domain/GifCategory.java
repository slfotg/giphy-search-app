package com.github.slfotg.giphy.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "CATEGORY", uniqueConstraints = { @UniqueConstraint(columnNames = { "USER_ID", "CATEGORY_NAME" }) })
public class GifCategory implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CATEGORY_ID")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)
    private GiphyUser giphyUser;

    @Column(name = "CATEGORY_NAME", nullable = false, length = 30)
    private String categoryName;

    @OneToMany(mappedBy = "id.category", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<CategorizedGifImage> categorizedImages;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public GiphyUser getGiphyUser() {
        return giphyUser;
    }

    public void setGiphyUser(GiphyUser giphyUser) {
        this.giphyUser = giphyUser;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

}
