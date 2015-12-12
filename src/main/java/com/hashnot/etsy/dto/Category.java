package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class Category {
    /**
     * The identifier for this category.
     */
    @JsonProperty("category_id")
    private long categoryId;

    /**
     * The programmatic name for this category.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The "title" meta tag value for the category's landing page (may be null).
     */
    @JsonProperty("meta_title")
    private String metaTitle;

    /**
     * The "keywords" meta tag value for the category's landing page (may be null).
     */
    @JsonProperty("meta_keywords")
    private String metaKeywords;

    /**
     * The "description" meta tag value for the category's landing page (may be null).
     */
    @JsonProperty("meta_description")
    private String metaDescription;

    /**
     * A short description of the category from the category' landing page (may be null).
     */
    @JsonProperty("page_description")
    private String pageDescription;

    /**
     * The title of the category's landing page (may be null).
     */
    @JsonProperty("page_title")
    private String pageTitle;

    /**
     * The category's String ID.
     */
    @JsonProperty("category_name")
    private String categoryName;

    /**
     * A short display name for the category.
     */
    @JsonProperty("short_name")
    private String shortName;

    /**
     * A longer display name for the category.
     */
    @JsonProperty("long_name")
    private String longName;

    /**
     * The number of subcategories below this one. Subcatgories append a new tag to the end of their parent's category_name.
     */
    @JsonProperty("num_children")
    private int numChildren;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaKeywords() {
        return metaKeywords;
    }

    public void setMetaKeywords(String metaKeywords) {
        this.metaKeywords = metaKeywords;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getPageDescription() {
        return pageDescription;
    }

    public void setPageDescription(String pageDescription) {
        this.pageDescription = pageDescription;
    }

    public String getPageTitle() {
        return pageTitle;
    }

    public void setPageTitle(String pageTitle) {
        this.pageTitle = pageTitle;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public int getNumChildren() {
        return numChildren;
    }

    public void setNumChildren(int numChildren) {
        this.numChildren = numChildren;
    }
}
