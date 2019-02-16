package com.github.slfotg.giphy.api.model;

import java.net.URL;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * The User Object contains information about the user associated with a GIF and
 * URLs to assets such as that user's avatar image, profile, and more
 *
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class User {

    private URL avatarUrl;
    private URL bannerUrl;
    private URL profileUrl;
    private String username;
    private String displayName;
    private String twitter;

    /**
     * Get the URL for this user's avatar image
     * 
     * @return the URL for this user's avatar image
     */
    public URL getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * Set the URL for this user's avatar image
     * 
     * @param avatarUrl
     *            the URL for this user's avatar image
     */
    public void setAvatarUrl(URL avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    /**
     * Get the URL for the banner image that appears atop this user's profile page
     * 
     * @return the URL for the banner image
     */
    public URL getBannerUrl() {
        return bannerUrl;
    }

    /**
     * Set the URL for the banner image that appears atop this user's profile page
     * 
     * @param bannerUrl
     *            the URL for the banner image
     */
    public void setBannerUrl(URL bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    /**
     * Get the URL for this user's profile
     * 
     * @return the URL for this user's profile
     */
    public URL getProfileUrl() {
        return profileUrl;
    }

    /**
     * Set the URL for this user's profile
     * 
     * @param profileUrl
     *            the URL for this user's profile
     */
    public void setProfileUrl(URL profileUrl) {
        this.profileUrl = profileUrl;
    }

    /**
     * Get the username associated with this user
     * 
     * @return the username associated with this user
     */
    public String getUsername() {
        return username;
    }

    /**
     * Set the username associated with this user
     * 
     * @param username
     *            the username associated with this user
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Get the display name associated with this user (contains formatting the base
     * username might not)
     * 
     * @return the display name associated with this user
     */
    public String getDisplayName() {
        return displayName;
    }

    /**
     * Set the display name associated with this user (contains formatting the base
     * username might not)
     * 
     * @param displayName
     *            the display name associated with this user
     */
    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    /**
     * Get the Twitter username associated with this user, if applicable
     * 
     * @return the Twitter username associated with this user
     */
    public String getTwitter() {
        return twitter;
    }

    /**
     * Set the Twitter username associated with this user
     * 
     * @param twitter
     *            the Twitter username associated with this user
     */
    public void setTwitter(String twitter) {
        this.twitter = twitter;
    }

}
