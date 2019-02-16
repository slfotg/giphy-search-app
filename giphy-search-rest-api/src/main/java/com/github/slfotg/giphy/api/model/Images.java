package com.github.slfotg.giphy.api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Images {

    private Image fixedHeight;
    private Image fixedHeightStill;
    private Image fixedHeightDownsampled;
    private Image fixedWidth;
    private Image fixedWidthStill;
    private Image fixedWidthDownsampled;
    private Image fixedHeightSmall;
    private Image fixedHeightSmallStill;
    private Image fixedWidthSmall;
    private Image fixedWidthSmallStill;
    private Image downsized;
    private Image downsizedStill;
    private Image downsizedLarge;
    private Image downsizedSmall;
    private Image original;
    private Image originalStill;
    private Image looping;
    private Image preview;
    private Image previewGif;

    public Image getFixedHeight() {
        return fixedHeight;
    }

    public void setFixedHeight(Image fixedHeight) {
        this.fixedHeight = fixedHeight;
    }

    public Image getFixedHeightStill() {
        return fixedHeightStill;
    }

    public void setFixedHeightStill(Image fixedHeightStill) {
        this.fixedHeightStill = fixedHeightStill;
    }

    public Image getFixedHeightDownsampled() {
        return fixedHeightDownsampled;
    }

    public void setFixedHeightDownsampled(Image fixedHeightDownsampled) {
        this.fixedHeightDownsampled = fixedHeightDownsampled;
    }

    public Image getFixedWidth() {
        return fixedWidth;
    }

    public void setFixedWidth(Image fixedWidth) {
        this.fixedWidth = fixedWidth;
    }

    public Image getFixedWidthStill() {
        return fixedWidthStill;
    }

    public void setFixedWidthStill(Image fixedWidthStill) {
        this.fixedWidthStill = fixedWidthStill;
    }

    public Image getFixedWidthDownsampled() {
        return fixedWidthDownsampled;
    }

    public void setFixedWidthDownsampled(Image fixedWidthDownsampled) {
        this.fixedWidthDownsampled = fixedWidthDownsampled;
    }

    public Image getFixedHeightSmall() {
        return fixedHeightSmall;
    }

    public void setFixedHeightSmall(Image fixedHeightSmall) {
        this.fixedHeightSmall = fixedHeightSmall;
    }

    public Image getFixedHeightSmallStill() {
        return fixedHeightSmallStill;
    }

    public void setFixedHeightSmallStill(Image fixedHeightSmallStill) {
        this.fixedHeightSmallStill = fixedHeightSmallStill;
    }

    public Image getFixedWidthSmall() {
        return fixedWidthSmall;
    }

    public void setFixedWidthSmall(Image fixedWidthSmall) {
        this.fixedWidthSmall = fixedWidthSmall;
    }

    public Image getFixedWidthSmallStill() {
        return fixedWidthSmallStill;
    }

    public void setFixedWidthSmallStill(Image fixedWidthSmallStill) {
        this.fixedWidthSmallStill = fixedWidthSmallStill;
    }

    public Image getDownsized() {
        return downsized;
    }

    public void setDownsized(Image downsized) {
        this.downsized = downsized;
    }

    public Image getDownsizedStill() {
        return downsizedStill;
    }

    public void setDownsizedStill(Image downsizedStill) {
        this.downsizedStill = downsizedStill;
    }

    public Image getDownsizedLarge() {
        return downsizedLarge;
    }

    public void setDownsizedLarge(Image downsizedLarge) {
        this.downsizedLarge = downsizedLarge;
    }

    public Image getDownsizedSmall() {
        return downsizedSmall;
    }

    public void setDownsizedSmall(Image downsizedSmall) {
        this.downsizedSmall = downsizedSmall;
    }

    public Image getOriginal() {
        return original;
    }

    public void setOriginal(Image original) {
        this.original = original;
    }

    public Image getOriginalStill() {
        return originalStill;
    }

    public void setOriginalStill(Image originalStill) {
        this.originalStill = originalStill;
    }

    public Image getLooping() {
        return looping;
    }

    public void setLooping(Image looping) {
        this.looping = looping;
    }

    public Image getPreview() {
        return preview;
    }

    public void setPreview(Image preview) {
        this.preview = preview;
    }

    public Image getPreviewGif() {
        return previewGif;
    }

    public void setPreviewGif(Image previewGif) {
        this.previewGif = previewGif;
    }

}
