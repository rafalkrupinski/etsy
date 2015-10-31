package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * A class representing an Etsy image.
 */
public class Image {

    @JsonProperty("listing_image_id")
    private long mListingImageId;

    @JsonProperty("hex_code")
    private String mHexCode;

    @JsonProperty("red")
    private int mRed;

    @JsonProperty("green")
    private int mGreen;

    @JsonProperty("blue")
    private int mBlue;

    @JsonProperty("hue")
    private int mHue;

    @JsonProperty("saturation")
    private int mSaturation;

    @JsonProperty("brightness")
    private int mBrightness;

    @JsonProperty("is_black_and_white")
    private boolean mBlackAndWhite;

    @JsonProperty("creation_tsz")
    private long mCreationTsz;

    @JsonProperty("listing_id")
    private long mListingId;

    @JsonProperty("url_75x75")
    private String mUrl75x75;

    @JsonProperty("url_170x135")
    private String mUrl170x135;

    @JsonProperty("url_570xN")
    private String mUrl570xN;

    @JsonProperty("url_fullxfull")
    private String mUrlFullxFull;

    @JsonProperty("full_height")
    private int mFullHeight;

    @JsonProperty("full_width")
    private int mFullWidth;

    public long getListingImageId() {
        return mListingImageId;
    }

    public String getHexCode() {
        return mHexCode;
    }

    public int getRed() {
        return mRed;
    }

    public int getGreen() {
        return mGreen;
    }

    public int getBlue() {
        return mBlue;
    }

    public int getHue() {
        return mHue;
    }

    public int getSaturation() {
        return mSaturation;
    }

    public int getBrightness() {
        return mBrightness;
    }

    public boolean isBlackAndWhite() {
        return mBlackAndWhite;
    }

    public long getCreationTsz() {
        return mCreationTsz;
    }

    public long getListingId() {
        return mListingId;
    }

    public String getUrl75x75() {
        return mUrl75x75;
    }

    public String getUrl170x135() {
        return mUrl170x135;
    }

    public String getUrl570xN() {
        return mUrl570xN;
    }

    public String getUrlFullxFull() {
        return mUrlFullxFull;
    }

    public int getFullHeight() {
        return mFullHeight;
    }

    public int getFullWidth() {
        return mFullWidth;
    }
}
