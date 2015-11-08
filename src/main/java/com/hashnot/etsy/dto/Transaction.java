package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Transaction {
    /**
     * The numeric ID for this transaction.
     */
    @JsonProperty("transaction_id")
    private long transactionId;
    /**
     * The title of the listing for this transaction.
     */
    @JsonProperty("title")
    private String title;
    /**
     * The description of the listing for this transaction.
     */
    @JsonProperty("description")
    private String description;
    /**
     * The numeric ID for the seller of this transaction.
     */
    @JsonProperty("seller_user_id")
    private long sellerUserId;
    /**
     * The numeric ID for the buyer of this transaction.
     */
    @JsonProperty("buyer_user_id")
    private Long buyerUserId;
    /**
     * The date and time the transaction was created, in epoch seconds.
     */
    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date creationTime;
    /**
     * The date and time the transaction was paid, in epoch seconds.
     */
    @JsonProperty("paid_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date paidTime;
    /**
     * The date and time the transaction was shipped, in epoch seconds.
     */
    @JsonProperty("shipped_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Date shippedTime;
    /**
     * The price of the transaction.
     */
    @JsonProperty("price")
    private BigDecimal price;
    /**
     * The ISO code (alphabetic) for the seller's native currency.
     */
    @JsonProperty("currency_code")
    private String currencyCode;
    /**
     * The quantity of items in this transaction.
     */
    @JsonProperty("quantity")
    private int quantity;

    /**
     * The tags in the listing for this transaction.
     */
    @JsonProperty("tags")
    private List<String> tags;

    /**
     * The materials in the listing for this transaction.
     */
    @JsonProperty("materials")
    private List<String>materials;

    /**
     * The numeric ID of the primary listing image for this transaction.
     */
    @JsonProperty("image_listing_id")
    private Long imageListingId;

    /**
     * The numeric ID for the receipt associated to this transaction.
     */
    @JsonProperty("receipt_id")
    private long receiptId;

    /**
     * The shipping cost for this transaction.
     */
    @JsonProperty("shipping_cost")
    private BigDecimal shippingCost;

    /**
     * True if this listing is for a digital download.
     */
    @JsonProperty("is_digital")
    private boolean isDigital;

    /**
     * Written description of the files attached to this digital listing.
     */
    @JsonProperty("file_data")
    private String fileData;

    /**
     * The numeric ID for this listing associated to this transaction.
     */
    @JsonProperty("listing_id")
    private long listingId;

    /**
     * True if this transaction was created for an in-person quick sale.
     */
    @JsonProperty("is_quick_sale")
    private boolean quickSale;

    /**
     * The numeric ID of seller's feedback.
     */
    @JsonProperty("seller_feedback_id")
    private Long sellerFeedbackId;

    /**
     * The numeric ID for the buyer's feedback.
     */
    @JsonProperty("buyer_feedback_id")
    private Long buyerFeedbackId;

    /**
     * The type of transaction, usually "listing".
     */
    @JsonProperty("transaction_type")
    private String transactionType;
    /**
     * URL of this transaction
     */
    @JsonProperty("url")
    private String url;

    /**
     * Purchased variations for this transaction.
     */
/*
    @JsonProperty("variations")
    private List(Variations_SelectedProperty)variations;
*/

    /**
     * The buyer that is associated with this transaction.
     */
    @JsonProperty("Buyer")
    private User buyer;

    /**
     * The primary listing image for this transaction.
     */
    @JsonProperty("MainImage")
    private ListingImage mainImage;

    /**
     * The listing that is associated with this transaction.
     */
    @JsonProperty("Listing")
    private Listing listing;

    /**
     * The seller that is associated with this transaction.
     */
    @JsonProperty("Seller")
    private User seller;

    /**
     * The receipt that is associated with this transaction.
     */
    @JsonProperty("Receipt")
    private Receipt receipt;

    public long getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(long transactionId) {
        this.transactionId = transactionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getSellerUserId() {
        return sellerUserId;
    }

    public void setSellerUserId(long sellerUserId) {
        this.sellerUserId = sellerUserId;
    }

    public Long getBuyerUserId() {
        return buyerUserId;
    }

    public void setBuyerUserId(Long buyerUserId) {
        this.buyerUserId = buyerUserId;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }

    public Date getShippedTime() {
        return shippedTime;
    }

    public void setShippedTime(Date shippedTime) {
        this.shippedTime = shippedTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public Long getImageListingId() {
        return imageListingId;
    }

    public void setImageListingId(Long imageListingId) {
        this.imageListingId = imageListingId;
    }

    public long getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(long receiptId) {
        this.receiptId = receiptId;
    }

    public BigDecimal getShippingCost() {
        return shippingCost;
    }

    public void setShippingCost(BigDecimal shippingCost) {
        this.shippingCost = shippingCost;
    }

    public boolean isDigital() {
        return isDigital;
    }

    public void setIsDigital(boolean isDigital) {
        this.isDigital = isDigital;
    }

    public String getFileData() {
        return fileData;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public long getListingId() {
        return listingId;
    }

    public void setListingId(long listingId) {
        this.listingId = listingId;
    }

    public boolean isQuickSale() {
        return quickSale;
    }

    public void setQuickSale(boolean quickSale) {
        this.quickSale = quickSale;
    }

    public Long getSellerFeedbackId() {
        return sellerFeedbackId;
    }

    public void setSellerFeedbackId(Long sellerFeedbackId) {
        this.sellerFeedbackId = sellerFeedbackId;
    }

    public Long getBuyerFeedbackId() {
        return buyerFeedbackId;
    }

    public void setBuyerFeedbackId(Long buyerFeedbackId) {
        this.buyerFeedbackId = buyerFeedbackId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public User getBuyer() {
        return buyer;
    }

    public void setBuyer(User buyer) {
        this.buyer = buyer;
    }

    public ListingImage getMainImage() {
        return mainImage;
    }

    public void setMainImage(ListingImage mainImage) {
        this.mainImage = mainImage;
    }

    public Listing getListing() {
        return listing;
    }

    public void setListing(Listing listing) {
        this.listing = listing;
    }

    public User getSeller() {
        return seller;
    }

    public void setSeller(User seller) {
        this.seller = seller;
    }

    public Receipt getReceipt() {
        return receipt;
    }

    public void setReceipt(Receipt receipt) {
        this.receipt = receipt;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", sellerUserId=" + sellerUserId +
                ", buyerUserId=" + buyerUserId +
                ", creationTime=" + creationTime +
                ", paidTime=" + paidTime +
                ", shippedTime=" + shippedTime +
                ", price=" + price +
                ", currencyCode='" + currencyCode + '\'' +
                ", quantity=" + quantity +
                ", tags=" + tags +
                ", materials=" + materials +
                ", imageListingId=" + imageListingId +
                ", receiptId=" + receiptId +
                ", shippingCost=" + shippingCost +
                ", isDigital=" + isDigital +
                ", fileData='" + fileData + '\'' +
                ", listingId=" + listingId +
                ", quickSale=" + quickSale +
                ", sellerFeedbackId=" + sellerFeedbackId +
                ", buyerFeedbackId=" + buyerFeedbackId +
                ", transactionType='" + transactionType + '\'' +
                ", url='" + url + '\'' +
                ", buyer=" + buyer +
                ", mainImage=" + mainImage +
                ", listing=" + listing +
                ", seller=" + seller +
                ", receipt=" + receipt +
                '}';
    }
}
