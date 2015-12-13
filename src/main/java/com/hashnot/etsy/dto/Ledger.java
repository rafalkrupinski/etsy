package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.time.ZonedDateTime;

/**
 * @author Rafał Krupiński
 */
public class Ledger {
    /**
     * The ledger's numeric ID.
     */
    @JsonProperty("ledger_id")
    private long ledger_id;

    /**
     * The shop's numeric ID.
     */
    @JsonProperty("shop_id")
    private String shopId;
    /**
     * The currency code of the shop.
     */
    @JsonProperty("currency")
    private String currency;
    /**
     * The date and time the ledger was created in Epoch seconds.
     */
    @JsonProperty("create_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private ZonedDateTime createDate;
    /**
     * The date and time the ledger was last updated in Epoch seconds.
     */
    @JsonProperty("update_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private ZonedDateTime updateDate;

    public long getLedger_id() {
        return ledger_id;
    }

    public void setLedger_id(long ledger_id) {
        this.ledger_id = ledger_id;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ZonedDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(ZonedDateTime createDate) {
        this.createDate = createDate;
    }

    public ZonedDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(ZonedDateTime updateDate) {
        this.updateDate = updateDate;
    }
}
