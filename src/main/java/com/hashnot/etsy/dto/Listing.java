package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.List;

/**
 * A class representing a single listing in Etsy.
 */
public class Listing {

    @JsonProperty("listing_id")
    private long listingId;

    @JsonProperty("state")
    private String mState;

    @JsonProperty("user_id")
    private long mUserId;

    @JsonProperty("category_id")
    private Long mCategoryId;

    @JsonProperty("title")
    private String mTitle;

    @JsonProperty("description")
    private String mDescription;

    @JsonProperty("creation_tsz")
    private long mCreationTsz;

    @JsonProperty("ending_tsz")
    private long mEndingTsz;

    @JsonProperty("original_creation_tsz")
    private long mOriginalCreationTsz;

    @JsonProperty("last_modified_tsz")
    private long mLastModifiedTsz;

    @JsonProperty("price")
    private BigDecimal mPrice;

    @JsonProperty("currency_code")
    private String mCurrencyCode;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("tags")
    private List<String> mTags;

    @JsonProperty("category_path")
    private List<String> mCategoryPath;

    @JsonProperty("category_path_ids")
    private List<Long> mCategoryPathIds;

    @JsonProperty("materials")
    private List<String> mMaterials;

    @JsonProperty("shop_section_id")
    private long mShopSectionId;

    @JsonProperty("featured_rank")
    private int mFeaturedRank;

    @JsonProperty("state_tsz")
    private long mStateTsz;

    @JsonProperty("url")
    private String mUrl;

    @JsonProperty("views")
    private int mViews;

    @JsonProperty("num_favorers")
    private int mNumFavorers;

    @JsonProperty("shipping_template_id")
    private long mShippingTemplateId;

    @JsonProperty("processing_min")
    private int mProcessingMin;

    @JsonProperty("processing_max")
    private int mProcessingMax;

    @JsonProperty("who_made")
    private String mWhoMade;

    @JsonProperty("is_supply")
    private boolean mIsSupply;

    @JsonProperty("when_made")
    private String mWhenMade;

    @JsonProperty("is_private")
    private boolean mPrivate;

    @JsonProperty("recipient")
    private String mRecipient;

    @JsonProperty("occasion")
    private String mOccasion;

    @JsonProperty("style")
    private List<String> mStyle;

    @JsonProperty("non_taxable")
    private boolean mNonTaxable;

    @JsonProperty("is_customizable")
    private Boolean mCustomizable;

    @JsonProperty("is_digital")
    private boolean mDigital;

    @JsonProperty("file_data")
    private String mFileData;

    @JsonProperty("language")
    private String mLanguage;

    @JsonProperty("has_variations")
    private boolean mHasVariations;

    @JsonProperty("used_manufacturer")
    private boolean mUsedManufacturer;

    @JsonProperty("taxonomy_id")
    private Long taxonomyId;

    @JsonProperty("taxonomy_path")
    private List<String> taxonomyPath;

	/*
    @JsonProperty("MainImage")
	private Image mMainImage;
	*/

    @JsonProperty("Images")
    private List<Image> mImages;

    @JsonProperty("Shop")
    private Shop shop;

    public long getListingId() {
        return listingId;
    }

    public String getState() {
        return mState;
    }

    public long getUserId() {
        return mUserId;
    }

    public Long getCategoryId() {
        return mCategoryId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public long getCreationTsz() {
        return mCreationTsz;
    }

    public long getEndingTsz() {
        return mEndingTsz;
    }

    public long getOriginalCreationTsz() {
        return mOriginalCreationTsz;
    }

    public long getLastModifiedTsz() {
        return mLastModifiedTsz;
    }

    public BigDecimal getPrice() {
        return mPrice;
    }

    public String getCurrencyCode() {
        return mCurrencyCode;
    }

    public int getQuantity() {
        return quantity;
    }

    public List<String> getTags() {
        return mTags;
    }

    public List<String> getCategoryPath() {
        return mCategoryPath;
    }

    public List<Long> getCategoryPathIds() {
        return mCategoryPathIds;
    }

    public List<String> getMaterials() {
        return mMaterials;
    }

    public Long getShopSectionId() {
        return mShopSectionId;
    }

    public int getFeaturedRank() {
        return mFeaturedRank;
    }

    public long getStateTsz() {
        return mStateTsz;
    }

    public String getUrl() {
        return mUrl;
    }

    public int getViews() {
        return mViews;
    }

    public int getNumFavorers() {
        return mNumFavorers;
    }

    public long getShippingTemplateId() {
        return mShippingTemplateId;
    }

    public int getProcessingMin() {
        return mProcessingMin;
    }

    public int getProcessingMax() {
        return mProcessingMax;
    }

    public String getWhoMade() {
        return mWhoMade;
    }

    public boolean isSupply() {
        return mIsSupply;
    }

    public void seSupply(boolean supply) {
        this.mIsSupply = supply;
    }

    public String getWhenMade() {
        return mWhenMade;
    }

    public boolean isPrivate() {
        return mPrivate;
    }

    public String getRecipient() {
        return mRecipient;
    }

    public String getOccasion() {
        return mOccasion;
    }

    public List<String> getStyle() {
        return mStyle;
    }

    public boolean isNonTaxable() {
        return mNonTaxable;
    }

    public Boolean isCustomizable() {
        return mCustomizable;
    }

    public boolean isDigital() {
        return mDigital;
    }

    public String getFileData() {
        return mFileData;
    }

    public String getLanguage() {
        return mLanguage;
    }

    public boolean isHasVariations() {
        return mHasVariations;
    }

    public boolean isUsedManufacturer() {
        return mUsedManufacturer;
    }

    public void setCategoryId(Long mCategoryId) {
        this.mCategoryId = mCategoryId;
    }

    public Image getMainImage() {
        if (mImages == null || mImages.size() == 0) {
            return null;
        } else {
            return mImages.get(0);
        }
    }

    public List<Image> getImages() {
        return mImages;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(listingId);
    }

    @Override
    public boolean equals(Object obj) {
        return obj != null && obj instanceof Listing && equals((Listing) obj);
    }

    protected boolean equals(Listing l) {
        return listingId == l.listingId;
    }

    public Long getTaxonomyId() {
        return taxonomyId;
    }

    public void setTaxonomyId(Long taxonomyId) {
        this.taxonomyId = taxonomyId;
    }

    public List<String> getTaxonomyPath() {
        return taxonomyPath;
    }

    public void setTaxonomyPath(List<String> taxonomyPath) {
        this.taxonomyPath = taxonomyPath;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setShippingTemplateId(long shippingTemplateId) {
        this.mShippingTemplateId = shippingTemplateId;
    }

    public void setShopSectionId(long shopSectionId) {
        this.mShopSectionId = shopSectionId;
    }

    public void setState(String state) {
        this.mState = state;
    }

    public void setTitle(String title) {
        this.mTitle = title;
    }

    public void setCustomizable(Boolean customizable) {
        this.mCustomizable = customizable;
    }

    public Listing() {
    }

    public Listing(Listing other) {
        this.listingId = other.listingId;
        this.mState = other.mState;
        this.mUserId = other.mUserId;
        this.mCategoryId = other.mCategoryId;
        this.mTitle = other.mTitle;
        this.mDescription = other.mDescription;
        this.mCreationTsz = other.mCreationTsz;
        this.mEndingTsz = other.mEndingTsz;
        this.mOriginalCreationTsz = other.mOriginalCreationTsz;
        this.mLastModifiedTsz = other.mLastModifiedTsz;
        this.mPrice = other.mPrice;
        this.mCurrencyCode = other.mCurrencyCode;
        this.quantity = other.quantity;
        this.mTags = other.mTags;
        this.mCategoryPath = other.mCategoryPath;
        this.mCategoryPathIds = other.mCategoryPathIds;
        this.mMaterials = other.mMaterials;
        this.mShopSectionId = other.mShopSectionId;
        this.mFeaturedRank = other.mFeaturedRank;
        this.mStateTsz = other.mStateTsz;
        this.mUrl = other.mUrl;
        this.mViews = other.mViews;
        this.mNumFavorers = other.mNumFavorers;
        this.mShippingTemplateId = other.mShippingTemplateId;
        this.mProcessingMin = other.mProcessingMin;
        this.mProcessingMax = other.mProcessingMax;
        this.mWhoMade = other.mWhoMade;
        this.mIsSupply = other.mIsSupply;
        this.mWhenMade = other.mWhenMade;
        this.mPrivate = other.mPrivate;
        this.mRecipient = other.mRecipient;
        this.mOccasion = other.mOccasion;
        this.mStyle = other.mStyle;
        this.mNonTaxable = other.mNonTaxable;
        this.mCustomizable = other.mCustomizable;
        this.mDigital = other.mDigital;
        this.mFileData = other.mFileData;
        this.mLanguage = other.mLanguage;
        this.mHasVariations = other.mHasVariations;
        this.mUsedManufacturer = other.mUsedManufacturer;
        this.taxonomyId = other.taxonomyId;
        this.taxonomyPath = other.taxonomyPath;
        this.mImages = other.mImages;
        this.shop = other.shop;

    }
}
