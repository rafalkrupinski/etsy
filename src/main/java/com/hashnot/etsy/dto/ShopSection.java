package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class ShopSection {
    /**
     * The numeric ID of the shop section.
     */
    @JsonProperty("shop_section_id")
    private long shopSectionId;
    /**
     * The title of the section.
     */
    @JsonProperty("title")
    private String title;
    /**
     * Display order.
     */
    @JsonProperty("rank")
    private int rank;
    /**
     * The ID of the user who owns this shop section.
     */
    @JsonProperty("user_id")
    private int user_id;
    /**
     * The number of active listings currently in the section.
     */
    private int active_listing_count;

    public long getShopSectionId() {
        return shopSectionId;
    }

    public void setShopSectionId(long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getActive_listing_count() {
        return active_listing_count;
    }

    public void setActive_listing_count(int active_listing_count) {
        this.active_listing_count = active_listing_count;
    }
}
