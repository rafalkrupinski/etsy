package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.time.Instant;

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
    private Instant createDate;
    /**
     * The date and time the ledger was last updated in Epoch seconds.
     */
    @JsonProperty("update_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant updateDate;

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

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    public Instant getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Instant updateDate) {
        this.updateDate = updateDate;
    }
}
