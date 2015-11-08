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
    private long userId;
    /**
     * The number of active listings currently in the section.
     */
    @JsonProperty("active_listing_count")
    private int activeListingCount;

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

    public long getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getActiveListingCount() {
        return activeListingCount;
    }

    public void setActiveListingCount(int activeListingCount) {
        this.activeListingCount = activeListingCount;
    }
}
