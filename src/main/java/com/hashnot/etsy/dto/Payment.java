package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.PennyDeserializer;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Rafał Krupiński
 */
public class Payment {
    /**
     * The payment's numeric ID.
     */
    @JsonProperty("payment_id")
    private long paymentId;
    /**
     * The buyer's numeric ID.
     */
    @JsonProperty("buyer_user_id")
    private long buyerUserId;
    /**
     * The shop's numeric ID.
     */
    @JsonProperty("shop_id")
    private long shopId;
    /**
     * The receipt's numeric ID.
     */
    @JsonProperty("receipt_id")
    private long receiptId;
    /**
     * The original gross amount of the order, in pennies - this is grand total, including shipping and taxes.
     */
    @JsonProperty("amount_gross")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal amountGross;
    /**
     * The original card processing fee of the order in pennies.
     */
    @JsonProperty("amount_fees")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal amountFees;
    /**
     * The total value of the payment less fees (amount_gross - amount_fees).
     */
    @JsonProperty("amount_net")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal amountNet;

    /**
     * The gross amount which posted to the ledger once shipped. This is equal to the amount_gross UNLESS the seller issues a refund prior to shipping. We consider "shipping" to the event which "posts" to the ledger. Therefore, if the seller refunds first, we simply reduce the amount_gross and post that amount. The seller never sees the refunded amount in their ledger. This is equal to the "Credit" amount in the ledger entry.
     */
    @JsonProperty("posted_gross")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal postedGross;
    /**
     * Amount of the fees that posted when shipped. We refund a proportional amount of the fees when a seller refunds a buyer. If they refund prior to shipping, the posted amount will be less then the original.
     */
    @JsonProperty("posted_fees")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal postedFees;

    /**
     * The total value of the payment at the time of posting it to the ledger less fees (posted_gross - posted_fees)
     */
    @JsonProperty("posted_net")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal postedNet;

    /**
     * If the payment is refunded, partially or fully, this is the new gross amount after the refund.
     */
    @JsonProperty("adjusted_gross")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal adjustedGross;

    /**
     * If the payment is refunded, partially or fully, this is the new fee amount after the refund.
     */
    @JsonProperty("adjusted_fees")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal adjustedFees;

    /**
     * The total value of the payment after refunds less fees (adjusted_gross - adjusted_fees).
     */
    @JsonProperty("adjusted_net")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal adjustedNet;

    /**
     * What currency the payment was made in.
     */
    @JsonProperty("currency")
    private String currency;

    /**
     * The currency of the shop.
     */
    @JsonProperty("shop_currency")
    private String shopCurrency;

    /**
     * The currency of the buyer.
     */
    @JsonProperty("buyer_currency")
    private String buyerCurrency;

    /**
     * The numeric id of the user to which the order is being shipped.
     */
    @JsonProperty("shipping_user_id")
    private long shippingUserId;

    /**
     * The numeric id identifying the shipping address.
     */
    @JsonProperty("shipping_address_id")
    private long shippingAddressId;

    /**
     * The numeric id identifying the billing address of the buyer.
     */
    @JsonProperty("billing_address_id")
    private long billingAddressId;

    /**
     * Most commonly "settled" or "authed". Marks the current status of the payment.
     */
    @JsonProperty("status")
    private String status;

    /**
     * The date and time the payment was shipped in Epoch seconds.
     */
    @JsonProperty("shipped_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date shippedDate;

    /**
     * The date and time the payment was created in Epoch seconds.
     */
    @JsonProperty("create_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date createDate;

    /**
     * The date and time the payment was last updated in Epoch seconds.
     */
    @JsonProperty("update_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date updateDate;

    public long getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(long paymentId) {
        this.paymentId = paymentId;
    }

    public long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public long getShopId() {
        return shopId;
    }

    public void setShopId(long shopId) {
        this.shopId = shopId;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public BigDecimal getAmountGross() {
        return amountGross;
    }

    public void setAmountGross(BigDecimal amountGross) {
        this.amountGross = amountGross;
    }

    public BigDecimal getAmountFees() {
        return amountFees;
    }

    public void setAmountFees(BigDecimal amountFees) {
        this.amountFees = amountFees;
    }

    public BigDecimal getAmountNet() {
        return amountNet;
    }

    public void setAmountNet(BigDecimal amountNet) {
        this.amountNet = amountNet;
    }

    public BigDecimal getPostedGross() {
        return postedGross;
    }

    public void setPostedGross(BigDecimal postedGross) {
        this.postedGross = postedGross;
    }

    public BigDecimal getPostedFees() {
        return postedFees;
    }

    public void setPostedFees(BigDecimal postedFees) {
        this.postedFees = postedFees;
    }

    public BigDecimal getPostedNet() {
        return postedNet;
    }

    public void setPostedNet(BigDecimal postedNet) {
        this.postedNet = postedNet;
    }

    public BigDecimal getAdjustedGross() {
        return adjustedGross;
    }

    public void setAdjustedGross(BigDecimal adjustedGross) {
        this.adjustedGross = adjustedGross;
    }

    public BigDecimal getAdjustedFees() {
        return adjustedFees;
    }

    public void setAdjustedFees(BigDecimal adjustedFees) {
        this.adjustedFees = adjustedFees;
    }

    public BigDecimal getAdjustedNet() {
        return adjustedNet;
    }

    public void setAdjustedNet(BigDecimal adjustedNet) {
        this.adjustedNet = adjustedNet;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getShopCurrency() {
        return shopCurrency;
    }

    public void setShopCurrency(String shopCurrency) {
        this.shopCurrency = shopCurrency;
    }

    public String getBuyerCurrency() {
        return buyerCurrency;
    }

    public void setBuyerCurrency(String buyerCurrency) {
        this.buyerCurrency = buyerCurrency;
    }

    public long getShippingUserId() {
        return shippingUserId;
    }

    public void setShippingUserId(long shippingUserId) {
        this.shippingUserId = shippingUserId;
    }

    public long getShippingAddressId() {
        return shippingAddressId;
    }

    public void setShippingAddressId(long shippingAddressId) {
        this.shippingAddressId = shippingAddressId;
    }

    public long getBillingAddressId() {
        return billingAddressId;
    }

    public void setBillingAddressId(long billingAddressId) {
        this.billingAddressId = billingAddressId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
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

    @Override
    public String toString() {
        return "Payment{" +
                "paymentId=" + paymentId +
                ", buyerUserId=" + buyerUserId +
                ", shopId=" + shopId +
                ", receiptId=" + receiptId +
                ", amountGross=" + amountGross +
                ", amountFees=" + amountFees +
                ", amountNet=" + amountNet +
                ", postedGross=" + postedGross +
                ", postedFees=" + postedFees +
                ", postedNet=" + postedNet +
                ", adjustedGross=" + adjustedGross +
                ", adjustedFees=" + adjustedFees +
                ", adjustedNet=" + adjustedNet +
                ", currency='" + currency + '\'' +
                ", shopCurrency='" + shopCurrency + '\'' +
                ", buyerCurrency='" + buyerCurrency + '\'' +
                ", shippingUserId=" + shippingUserId +
                ", shippingAddressId=" + shippingAddressId +
                ", billingAddressId=" + billingAddressId +
                ", status='" + status + '\'' +
                ", shippedDate=" + shippedDate +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
