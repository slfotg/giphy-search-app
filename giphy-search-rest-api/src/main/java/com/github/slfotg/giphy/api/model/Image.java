package com.github.slfotg.giphy.api.model;

import java.io.Serializable;
import java.net.URL;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

/**
 * Image is contained in the Images object and contains URLs and other
 * information for GIFs
 */
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Image implements Serializable {

    private static final long serialVersionUID = 1L;

    private URL url;
    private String width;
    private String height;
    private String size;
    private String frames;
    private URL mp4;
    private String mp4Size;
    private URL webp;
    private String webpSize;

    /**
     * Get the publicly-accessible direct URL for this GIF
     * 
     * @return the publicly-accessible direct URL for this GIF
     */
    public URL getUrl() {
        return url;
    }

    /**
     * Set the publicly-accessible direct URL for this GIF
     * 
     * @param url the publicly-accessible direct URL for this GIF
     */
    public void setUrl(URL url) {
        this.url = url;
    }

    /**
     * Get the width of this GIF in pixels
     * 
     * @return the width of this GIF in pixels
     */
    public String getWidth() {
        return width;
    }

    /**
     * Set the width of this GIF in pixels
     * 
     * @param width the width of this GIF in pixels
     */
    public void setWidth(String width) {
        this.width = width;
    }

    /**
     * Get the height of this GIF in pixels
     * 
     * @return the height of this GIF in pixels
     */
    public String getHeight() {
        return height;
    }

    /**
     * Set the height of this GIF in pixels
     * 
     * @param height the height of this GIF in pixels
     */
    public void setHeight(String height) {
        this.height = height;
    }

    /**
     * Get the size of this GIF in bytes
     * 
     * @return the size of this GIF in bytes
     */
    public String getSize() {
        return size;
    }

    /**
     * Set the size of this GIF in bytes
     * 
     * @param size the size of this GIF in bytes
     */
    public void setSize(String size) {
        this.size = size;
    }

    /**
     * Get the number of frames in this GIF
     * 
     * @return the number of frames in this GIF
     */
    public String getFrames() {
        return frames;
    }

    /**
     * Set the number of frames in this GIF
     * 
     * @param frames the number of frames in this GIF
     */
    public void setFrames(String frames) {
        this.frames = frames;
    }

    /**
     * Get the URL for this GIF in .MP4 format
     * 
     * @return the URL for this GIF in .MP4 format
     */
    public URL getMp4() {
        return mp4;
    }

    /**
     * Set the URL for this GIF in .MP4 format
     * 
     * @param mp4 the URL for this GIF in .MP4 format
     */
    public void setMp4(URL mp4) {
        this.mp4 = mp4;
    }

    /**
     * Get the size in bytes of the .MP4 file corresponding to this GIF
     * 
     * @return the size in bytes of the .MP4 file corresponding to this GIF
     */
    public String getMp4Size() {
        return mp4Size;
    }

    /**
     * Set the size in bytes of the .MP4 file corresponding to this GIF
     * 
     * @param mp4Size the size in bytes of the .MP4 file corresponding to this GIF
     */
    public void setMp4Size(String mp4Size) {
        this.mp4Size = mp4Size;
    }

    /**
     * Get the URL for this GIF in .webp format
     * 
     * @return the URL for this GIF in .webp format
     */
    public URL getWebp() {
        return webp;
    }

    /**
     * Set the URL for this GIF in .webp format
     * 
     * @param webp the URL for this GIF in .webp format
     */
    public void setWebp(URL webp) {
        this.webp = webp;
    }

    /**
     * Get the size in bytes of the .webp file corresponding to this GIF
     * 
     * @return the size in bytes of the .webp file corresponding to this GIF
     */
    public String getWebpSize() {
        return webpSize;
    }

    /**
     * Set the size in bytes of the .webp file corresponding to this GIF
     * 
     * @param webpSize the size in bytes of the .webp file corresponding to this GIF
     */
    public void setWebpSize(String webpSize) {
        this.webpSize = webpSize;
    }

}
