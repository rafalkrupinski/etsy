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
public class PaymentAdjustment {
    /**
     * The payment adjustment's numeric ID.
     */
    @JsonProperty("payment_adjustment_id")
    private long paymentAdjustmentId;
    /**
     * The payment's numeric ID.
     */
    @JsonProperty("payment_id")
    private long paymentId;
    /**
     * The status of the Payment Adjustment. Can be OPEN, REFUNDED, ERROR, or REFUND_FAILED.
     */
    @JsonProperty("status")
    private String status;
    /**
     * Whether the Payment Adjustment was successful or will likely be completed successfully.
     */
    @JsonProperty("is_success")
    private boolean isSuccess;
    /**
     * The seller's numeric ID.
     */
    @JsonProperty("user_id")
    private long userId;
    /**
     * A human-readable String describing the need for the refund.
     */
    @JsonProperty("reason_code")
    private String reasonCode;
    /**
     * The total amount of the refund in the payment currency.
     */
    @JsonProperty("total_adjustment_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal totalAdjustmentAmount;
    /**
     * The total amount of the refund in the shop currency.
     */
    @JsonProperty("shop_total_adjustment_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal shopTotalAdjustmentAmount;
    /**
     * The total amount of the refund in the buyer currency.
     */
    @JsonProperty("buyer_total_adjustment_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal buyerTotalAdjustmentAmount;
    /**
     * The amount of card processing fees associated with this adjustment.
     */
    @JsonProperty("total_fee_adjustment_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal totalFeeAdjustmentAmount;
    /**
     * The date and time the payment adjustment was created in Epoch seconds.
     */
    @JsonProperty("create_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private ZonedDateTime createDate;
    /**
     * The date and time the payment adjustment was last updated in Epoch seconds.
     */
    @JsonProperty("update_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private ZonedDateTime updateDate;

    public long getPaymentAdjustmentId() {
        return paymentAdjustmentId;
    }

    public void setPaymentAdjustmentId(long paymentAdjustmentId) {
        this.paymentAdjustmentId = paymentAdjustmentId;
    }

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getReasonCode() {
        return reasonCode;
    }

    public void setReasonCode(String reasonCode) {
        this.reasonCode = reasonCode;
    }

    public BigDecimal getTotalAdjustmentAmount() {
        return totalAdjustmentAmount;
    }

    public void setTotalAdjustmentAmount(BigDecimal totalAdjustmentAmount) {
        this.totalAdjustmentAmount = totalAdjustmentAmount;
    }

    public BigDecimal getShopTotalAdjustmentAmount() {
        return shopTotalAdjustmentAmount;
    }

    public void setShopTotalAdjustmentAmount(BigDecimal shopTotalAdjustmentAmount) {
        this.shopTotalAdjustmentAmount = shopTotalAdjustmentAmount;
    }

    public BigDecimal getBuyerTotalAdjustmentAmount() {
        return buyerTotalAdjustmentAmount;
    }

    public void setBuyerTotalAdjustmentAmount(BigDecimal buyerTotalAdjustmentAmount) {
        this.buyerTotalAdjustmentAmount = buyerTotalAdjustmentAmount;
    }

    public BigDecimal getTotalFeeAdjustmentAmount() {
        return totalFeeAdjustmentAmount;
    }

    public void setTotalFeeAdjustmentAmount(BigDecimal totalFeeAdjustmentAmount) {
        this.totalFeeAdjustmentAmount = totalFeeAdjustmentAmount;
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

    @Override
    public String toString() {
        return "PaymentAdjustment{" +
                "paymentAdjustmentId=" + paymentAdjustmentId +
                ", paymentId=" + paymentId +
                ", status='" + status + '\'' +
                ", isSuccess=" + isSuccess +
                ", userId=" + userId +
                ", reasonCode='" + reasonCode + '\'' +
                ", totalAdjustmentAmount=" + totalAdjustmentAmount +
                ", shopTotalAdjustmentAmount=" + shopTotalAdjustmentAmount +
                ", buyerTotalAdjustmentAmount=" + buyerTotalAdjustmentAmount +
                ", totalFeeAdjustmentAmount=" + totalFeeAdjustmentAmount +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
