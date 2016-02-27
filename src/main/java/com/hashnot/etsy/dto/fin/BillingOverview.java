package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * A user's account balance on Etsy
 *
 * @author Rafał Krupiński
 */
public class BillingOverview {
    /**
     * True if the user has an overdue balance.
     */
    @JsonProperty("is_overdue")
    private Boolean overdue;

    /**
     * The currency unit in which the user is billed.
     */
    @JsonProperty("currency_code")
    private String currencyCode;

    /**
     * The total overdue balance owed by the user.
     */
    @JsonProperty("overdue_balance")
    private BigDecimal overdueBalance;

    /**
     * The total amount currently due for payment (including any overdue balance.)
     */
    @JsonProperty("balance_due")
    private BigDecimal balanceDue;

    /**
     * The total amount owed by the user (including fees that are not yet due for payment.)
     */
    @JsonProperty("total_balance")
    private BigDecimal totalBalance;

    /**
     * The date by which the user's balance due must be paid.
     */
    @JsonProperty("date_due")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant dateDue;

    public Boolean getOverdue() {
        return overdue;
    }

    public void setOverdue(Boolean overdue) {
        this.overdue = overdue;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public BigDecimal getOverdueBalance() {
        return overdueBalance;
    }

    public void setOverdueBalance(BigDecimal overdueBalance) {
        this.overdueBalance = overdueBalance;
    }

    public BigDecimal getBalanceDue() {
        return balanceDue;
    }

    public void setBalanceDue(BigDecimal balanceDue) {
        this.balanceDue = balanceDue;
    }

    public BigDecimal getTotalBalance() {
        return totalBalance;
    }

    public void setTotalBalance(BigDecimal totalBalance) {
        this.totalBalance = totalBalance;
    }

    public Instant getDateDue() {
        return dateDue;
    }

    public void setDateDue(Instant dateDue) {
        this.dateDue = dateDue;
    }
}
