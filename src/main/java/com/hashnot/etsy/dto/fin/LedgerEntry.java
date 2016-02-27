package com.hashnot.etsy.dto.fin;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.PennyDeserializer;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;

/**
 * @author Rafał Krupiński
 */
public class LedgerEntry {
    public static enum EntryType {
        PAYMENT, // payment for order (credit)
        BILL_PAYMENT, // payment for etsy bill (debit)
        REFUND, // refund to customer (debit)
        DISBURSE2 // withdrawal (debit)
    }

    /**
     * The ledger entry's numeric ID.
     */
    @JsonProperty("ledger_entry_id")
    private long ledgerEntryId;

    /**
     * The ledger's numeric ID.
     */
    @JsonProperty("ledger_id")
    private long ledgerId;

    /**
     * The sequence allows ledger entries to be sorted chronologically. The higher the sequence, the more recent the entry.
     */
    @JsonProperty("sequence")
    private long sequence;

    /**
     * The amount of money credited to the ledger.
     */
    @JsonProperty("credit_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal creditAmount;

    /**
     * The amount of money debited from the ledger.
     */
    @JsonProperty("debit_amount")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal debitAmount;

    /**
     * Details what kind of ledger entry this is:
     * a payment,
     * refund,
     * reversal of a failed refund,
     * disbursement,
     * returned disbursement,
     * recoupment,
     * miscellaneous credit,
     * miscellaneous debit, or
     * bill payment
     */
    @JsonProperty("entry_type")
    private String entryType;
    /**
     * Depending on the entry_type, this is the id of the corresponding payment, payment adjustment, or disbursement.
     */
    @JsonProperty("reference_id")
    private Long referenceId;
    /**
     * The amount of money in the shop's ledger the moment after this entry was applied.
     */
    @JsonProperty("running_balance")
    @JsonDeserialize(using = PennyDeserializer.class)
    private BigDecimal runningBalance;
    /**
     * The date and time the ledger entry was created in Epoch seconds.
     */
    @JsonProperty("create_date")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant createDate;

    public long getLedgerEntryId() {
        return ledgerEntryId;
    }

    public void setLedgerEntryId(long ledgerEntryId) {
        this.ledgerEntryId = ledgerEntryId;
    }

    public long getLedgerId() {
        return ledgerId;
    }

    public void setLedgerId(long ledgerId) {
        this.ledgerId = ledgerId;
    }

    public long getSequence() {
        return sequence;
    }

    public void setSequence(long sequence) {
        this.sequence = sequence;
    }

    public BigDecimal getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(BigDecimal creditAmount) {
        this.creditAmount = creditAmount;
    }

    public BigDecimal getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(BigDecimal debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getEntryType() {
        return entryType;
    }

    public void setEntryType(String entryType) {
        this.entryType = entryType;
    }

    public Long getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(Long referenceId) {
        this.referenceId = referenceId;
    }

    public BigDecimal getRunningBalance() {
        return runningBalance;
    }

    public void setRunningBalance(BigDecimal runningBalance) {
        this.runningBalance = runningBalance;
    }

    public Instant getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Instant createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "LedgerEntry{" +
                "ledgerEntryId=" + ledgerEntryId +
                ", ledgerId=" + ledgerId +
                ", sequence=" + sequence +
                ", creditAmount=" + creditAmount +
                ", debitAmount=" + debitAmount +
                ", entryType='" + entryType + '\'' +
                ", referenceId=" + referenceId +
                ", runningBalance=" + runningBalance +
                ", createDate=" + createDate +
                '}';
    }
}
