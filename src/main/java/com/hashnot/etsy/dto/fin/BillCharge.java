package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * Represents a charge to an Etsy member's account.
 *
 * @author Rafał Krupiński
 */
public class BillCharge {
    /**
     * The numeric ID for this bill charge record.
     */
    @JsonProperty("bill_charge_id")
    private long billChargeId;

    /**
     * Creation time, in epoch seconds.
     */
    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant creationTime;

    /**
     * The name of the type of charge.
     */
    @JsonProperty("type")
    private Type type;

    /**
     * The Listing, Transaction or Shipping Label ID to which the charge applies.
     */
    @JsonProperty("type_id")
    private Long typeId;

    /**
     * The user's numeric ID.
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * The amount charged.
     */
    @JsonProperty("amount")
    private BigDecimal amount;

    /**
     * The currency of the charge.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * Year that the charge was created.
     */
    @JsonProperty("creation_year")
    private Integer creationYear;

    /**
     * Month that the charge was created.
     */
    @JsonProperty("creation_month")
    private Integer creationMonth;

    /**
     * Time when charge was last modified.
     */
    @JsonProperty("last_modified_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant lastModifiedTime;

    public long getBillChargeId() {
        return billChargeId;
    }

    public void setBillChargeId(long billChargeId) {
        this.billChargeId = billChargeId;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getCreationMonth() {
        return creationMonth;
    }

    public void setCreationMonth(Integer creationMonth) {
        this.creationMonth = creationMonth;
    }

    public Integer getCreationYear() {
        return creationYear;
    }

    public void setCreationYear(Integer creationYear) {
        this.creationYear = creationYear;
    }

    public Instant getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Instant lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public enum AssociationType {
        Listing,
        Transaction,
        ShippingLabel,
        PostmatesDelivery,
        CampaignInstance,
        ShowcaseReservation
    }

    public enum Type {
        listing,
        edit,
        renew,
        renew_sold,
        renew_sold_auto,
        transaction_quantity,
        renew_expired,
        auto_renew_expired,
        transaction,
        wholesale_contract,
        wholesale_transaction,
        shipping_labels,
        shipping_label_insurance,
        shipping_label_coverage,
        shipping_label_taxes,
        shipping_label_adjustment,
        shipping_label_adjustment_taxes,
        etsy_asap,
        search_ads,
        listing_private,
        showcase_category,
        prolist, // promoted listing
        wholesale_setup_fee,
        vat_tax,
        showcase,
        alchemy
    }

    @JsonIgnore
    public AssociationType getAssociationType() {
        switch (type) {
            case listing:
            case edit:
            case renew:
            case renew_sold:
            case renew_sold_auto:
            case renew_expired:
            case auto_renew_expired:
            case listing_private:
            case alchemy:
                return AssociationType.Listing;

            case transaction_quantity:
            case transaction:
            case wholesale_transaction:
            case vat_tax:
                return AssociationType.Transaction;

            case shipping_labels:
            case shipping_label_insurance:
            case shipping_label_coverage:
            case shipping_label_taxes:
            case shipping_label_adjustment:
            case shipping_label_adjustment_taxes:
                return AssociationType.ShippingLabel;

            case etsy_asap:
                return AssociationType.PostmatesDelivery;

            case search_ads:
                return AssociationType.CampaignInstance;

            case showcase_category:
            case showcase:
                return AssociationType.ShowcaseReservation;

            case wholesale_contract:
            case prolist:
            case wholesale_setup_fee:
            default:
                return null;
        }
    }
}
