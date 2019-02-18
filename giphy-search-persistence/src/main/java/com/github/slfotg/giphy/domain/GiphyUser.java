package com.github.slfotg.giphy.domain;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GIPHY_USERS")
public class GiphyUser implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer id;

    @Column(name = "USERNAME", nullable = false, unique = true, length = 30)
    private String username;

    @Column(name = "PASSWORD", nullable = false, length = 100)
    private String password;

    @OneToMany(mappedBy = "giphyUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<GifCategory> categories;

    @OneToMany(mappedBy = "id.giphyUser", cascade = CascadeType.ALL, orphanRemoval = true)
    private Collection<GiphyUserFavorites> favorites;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<GifCategory> getCategories() {
        return categories;
    }

    public void setCategories(Collection<GifCategory> categories) {
        this.categories = categories;
    }

    public Collection<GiphyUserFavorites> getFavorites() {
        return favorites;
    }

    public void setFavorites(Collection<GiphyUserFavorites> favorites) {
        this.favorites = favorites;
    }

}
