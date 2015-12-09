package com.hashnot.etsy.dto.variation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;

/**
 * @author Rafał Krupiński
 */
public class Option {
    /**
     * The numeric ID of the option
     */
    @JsonProperty("value_id")
    private long valueId;

    /**
     * The normalized value of the option
     */
    @JsonProperty("value")
    private String value;

    /**
     * The formatted/translated value of the option
     */
    @JsonProperty("formatted_value")
    private String formattedValue;

    /**
     * True if the option is available for purchase
     */
    @JsonProperty("is_available")
    private boolean available;

    /**
     * The additional price, if any, for this option above the Listing's base price. (NOTE: Unavailable options may have negative values.)
     */
    @JsonProperty("price_diff")
    private BigDecimal priceDiff;

    /**
     * The full price of this option, added to the Listing's base price. (NOTE: Unavailable options may have a price that is lower than the Listing's base price, which is based on the lowest available option price.)
     */
    @JsonProperty("price")
    private BigDecimal price;

    public long getValueId() {
        return valueId;
    }

    public void setValueId(long valueId) {
        this.valueId = valueId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public BigDecimal getPriceDiff() {
        return priceDiff;
    }

    public void setPriceDiff(BigDecimal priceDiff) {
        this.priceDiff = priceDiff;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
