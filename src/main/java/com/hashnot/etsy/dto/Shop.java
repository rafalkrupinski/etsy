package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Shop {
    @JsonProperty("shop_id")
    private long shopId;

    @JsonProperty("shop_name")
    private String shopName;

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

    public Long getShopId() {
        return shopId;
    }

    public void setShopId(Long shopId) {
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
}
