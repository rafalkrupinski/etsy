package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.time.Instant;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Shop {
    @JsonProperty("shop_id")
    private long shopId;

    @JsonProperty("shop_name")
    private String shopName;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant creationTime;

    private String title;

    private String announcement;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("is_vacation")
    private boolean onVacation;

    @JsonProperty("vacation_message")
    private String vacationMessage;

    @JsonProperty("listing_active_count")
    private Integer listingActiveCount;

    @JsonProperty("url")
    private String url;

    @JsonProperty("accepts_custom_requests")
    private boolean acceptsCustomRequests;

    public List<ShopSection> getSections() {
        return sections;
    }

    public void setSections(List<ShopSection> sections) {
        this.sections = sections;
    }

    @JsonProperty("Sections")
    private List<ShopSection> sections;

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getListingActiveCount() {
        return listingActiveCount;
    }

    public void setListingActiveCount(Integer listingActiveCount) {
        this.listingActiveCount = listingActiveCount;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public boolean isAcceptsCustomRequests() {
        return acceptsCustomRequests;
    }

    public void setAcceptsCustomRequests(boolean acceptsCustomRequests) {
        this.acceptsCustomRequests = acceptsCustomRequests;
    }

    @Override
    public int hashCode() {
        return shopName.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Shop && equals((Shop) obj);
    }

    protected boolean equals(Shop shop) {
        return shop.shopId == shopId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public boolean isOnVacation() {
        return onVacation;
    }

    public void setOnVacation(boolean onVacation) {
        this.onVacation = onVacation;
    }
}
