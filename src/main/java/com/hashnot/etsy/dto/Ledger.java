package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.util.Date;

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
    private Date createDate;
    /**
     * The date and time the ledger was last updated in Epoch seconds.
     */
    @JsonProperty("update_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date updateDate;

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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
