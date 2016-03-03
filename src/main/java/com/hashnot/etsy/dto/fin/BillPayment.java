package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author Rafał Krupiński
 */
public class BillPayment {
    /**
     * The numeric ID for this bill payment record.
     */
    @JsonProperty("bill_payment_id")
    private long billPaymentId;

    /**
     * Creation time, in epoch seconds.
     */
    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant creationTime;

    /**
     * The name of the type of payment.
     */
    @JsonProperty("type")
    private String type;

    /**
     * The Listing or Transaction ID (or LedgerEntry ID in the case of a ledger payment) to which the payment applies.
     */
    @JsonProperty("type_id")
    private Long typeId;

    /**
     * The user's numeric ID.
     */
    @JsonProperty("user_id")
    private Long userId;

    /**
     * The amount paid.
     */
    @JsonProperty("amount")
    private BigDecimal amount;

    /**
     * The currency of the payment.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * Year that the payment was made.
     */
    @JsonProperty("creation_year")
    private Integer creationYear;

    /**
     * Month that the payment was made.
     */
    @JsonProperty("creation_month")
    private Integer creationMonth;

    public long getBillPaymentId() {
        return billPaymentId;
    }

    public void setBillPaymentId(long billPaymentId) {
        this.billPaymentId = billPaymentId;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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
}
