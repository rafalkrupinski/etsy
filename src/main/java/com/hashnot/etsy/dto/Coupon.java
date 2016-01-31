package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.PennyDeserializer;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

/**
 * @author Rafał Krupiński
 */
public class Coupon {
    /**
     * The numeric ID of the coupon
     */
    @JsonProperty("coupon_id")
    private long couponId;
    /**
     * The alphanumeric coupon code
     */
    @JsonProperty("coupon_code")
    private String couponCode;
    /**
     * True if the coupon is active
     */
    @JsonProperty("seller_active")
    private boolean sellerActive;
    /**
     * The discount percent (null for free shipping coupons)
     */
    @JsonProperty("pct_discount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal discountPercent;
    /**
     * True if the coupon applies free shipping
     */
    @JsonProperty("free_shipping")
    private boolean freeShipping;
    /**
     * True if the coupon free shipping applies to domestic addresses only
     */
    @JsonProperty("domestic_only")
    private boolean domesticOnly;
    /**
     * The 3 letter currency code relating to currency values if any. fixed_discount or minimum_purchase_price
     */
    @JsonProperty("currency_code")
    private String currencyCode;
    /**
     * Discount amount the coupon should take. For currency information see currency_code
     */
    @JsonProperty("fixed_discount")
    private BigDecimal fixedDiscount;
    /**
     * The minimum amount in a cart before tax or shipping needed in order to apply the coupon. For currency information see currency_code
     */
    @JsonProperty("minimum_purchase_price")
    private BigDecimal minimumPurchasePrice;
    /**
     * A epoch time (UTC) on which the coupon can no longer be applied
     */
    @JsonProperty("expiration_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private ZonedDateTime expirationDate;
    /**
     * The type of coupon: fixed_discount, pct_discount, free_shipping for example
     */
    @JsonProperty("coupon_type")
    private String couponType;

    public enum CouponType{
        fixed_discount, pct_discount, free_shipping
    }

    public long getCouponId() {
        return couponId;
    }

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public boolean isSellerActive() {
        return sellerActive;
    }

    public void setSellerActive(boolean sellerActive) {
        this.sellerActive = sellerActive;
    }

    public BigDecimal getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(BigDecimal discountPercent) {
        this.discountPercent = discountPercent;
    }

    public boolean isFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public boolean isDomesticOnly() {
        return domesticOnly;
    }

    public void setDomesticOnly(boolean domesticOnly) {
        this.domesticOnly = domesticOnly;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getFixedDiscount() {
        return fixedDiscount;
    }

    public void setFixedDiscount(BigDecimal fixedDiscount) {
        this.fixedDiscount = fixedDiscount;
    }

    public BigDecimal getMinimumPurchasePrice() {
        return minimumPurchasePrice;
    }

    public void setMinimumPurchasePrice(BigDecimal minimumPurchasePrice) {
        this.minimumPurchasePrice = minimumPurchasePrice;
    }

    public ZonedDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(ZonedDateTime expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getCouponType() {
        return couponType;
    }

    public void setCouponType(String couponType) {
        this.couponType = couponType;
    }
}
