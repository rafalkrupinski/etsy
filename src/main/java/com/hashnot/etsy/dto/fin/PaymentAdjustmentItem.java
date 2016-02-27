package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.dto.AdjustmentType;
import com.hashnot.etsy.jackson.PennyDeserializer;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * A Direct Checkout Payment may have adjustments, or refunds. These adjustments can have different items,
 * associated with the area being refunded, like shipping, sales tax, or the item itself.
 * Please note all monetary amounts are in USD pennies unless otherwise specified.
 *
 * @author Rafał Krupiński
 */
public class PaymentAdjustmentItem {
    /**
     * The payment adjustment item's numeric ID.
     */
    @JsonProperty("payment_adjustment_item_id")
    private long paymentAdjustmentItemId;

    /**
     * The payment adjustment's numeric ID.
     */
    @JsonProperty("payment_adjustment_id")
    private long paymentAdjustmentId;

    /**
     * A human readable string describing the area being refundedOne of: TRANS, TAX, or SHIP
     */
    @JsonProperty("adjustment_type")
    private AdjustmentType adjustmentType;

    /**
     * The total amount of the payment adjustment item.
     */
    @JsonProperty("amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal amount;

    /**
     * The numerice ID of the Credit Card Transaction
     */
    @JsonProperty("transaction_id")
    private long transactionId;

    /**
     * The date and time the payment adjustment item was created in Epoch seconds.
     */
    @JsonProperty("create_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant createDate;

    public long getPaymentAdjustmentItemId() {
        return paymentAdjustmentItemId;
    }

    public long getPaymentAdjustmentId() {
        return paymentAdjustmentId;
    }

    public AdjustmentType getAdjustmentType() {
        return adjustmentType;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public long getTransactionId() {
        return transactionId;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setPaymentAdjustmentItemId(long paymentAdjustmentItemId) {
        this.paymentAdjustmentItemId = paymentAdjustmentItemId;
    }

    public void setPaymentAdjustmentId(long paymentAdjustmentId) {
        this.paymentAdjustmentId = paymentAdjustmentId;
    }

    public void setAdjustmentType(AdjustmentType adjustmentType) {
        this.adjustmentType = adjustmentType;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "PaymentAdjustmentItem{" +
                "paymentAdjustmentItemId=" + paymentAdjustmentItemId +
                ", paymentAdjustmentId=" + paymentAdjustmentId +
                ", adjustmentType=" + adjustmentType +
                ", amount=" + amount +
                ", transactionId=" + transactionId +
                ", createDate=" + createDate +
                '}';
    }
}
