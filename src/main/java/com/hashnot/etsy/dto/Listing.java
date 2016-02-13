package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.dto.variation.Property;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

/**
 * A class representing a single listing in Etsy.
 */
public class Listing {
    /**
     * states available for querying
     */
    public enum AvailableState {
        active, inactive, expired
    }

    public enum association {
        Shop, Variations, MainImage, Images
    }

    @JsonProperty("listing_id")
    private long listingId;

    @JsonProperty("state")
    private String state;

    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("category_id")
    private Long categoryId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant creationTime;

    @JsonProperty("ending_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant endingTime;

    @JsonProperty("original_creation_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant originalCreationTime;

    @JsonProperty("last_modified_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant lastModifiedTime;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("currency_code")
    private String currencyCode;

    @JsonProperty("quantity")
    private Integer quantity;

    @JsonProperty("tags")
    private List<String> tags;

    @JsonProperty("category_path")
    private List<String> categoryPath;

    @JsonProperty("category_path_ids")
    private List<Long> categoryPathIds;

    @JsonProperty("materials")
    private List<String> materials;

    @JsonProperty("shop_section_id")
    private Long shopSectionId;

    /**
     * An int that determines the order of listings in the user's Featured Listings. Lower numbers are towards the front
     * of the queue. 0 removes the listing from the queue.
     * Note that featured ranks are reordered and normalized on the back end, so the listing's final rank may be
     * different from the value passed in, but will be correct relative to the rest of the queue.
     */
    @JsonProperty("featured_rank")
    private Integer featuredRank;

    @JsonProperty("state_tsz")
    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant stateTime;

    @JsonProperty("url")
    private String url;

    @JsonProperty("views")
    private Integer views;

    @JsonProperty("num_favorers")
    private Integer numFavorers;

    @JsonProperty("shipping_template_id")
    private Long shippingTemplateId;

    @JsonProperty("processing_min")
    private Integer processingMin;

    @JsonProperty("processing_max")
    private Integer processingMax;

    @JsonProperty("who_made")
    private String whoMade;

    @JsonProperty("is_supply")
    private Boolean isSupply;

    @JsonProperty("when_made")
    private String whenMade;

    /**
     * the item weight
     */
    @JsonProperty("item_weight")
    private BigDecimal weight;

    /**
     * the item weight units
     */
    @JsonProperty("item_weight_units")
    private String weightUnits;

    /**
     * the item length
     */
    @JsonProperty("item_length")
    private BigDecimal itemLength;

    /**
     * the item width
     */
    @JsonProperty("item_width")
    private BigDecimal itemWidth;

    /**
     * the item height
     */
    @JsonProperty("item_height")
    private BigDecimal itemHeight;

    /**
     * the item dimensions units
     */
    @JsonProperty("item_dimensions_unit")
    private String itemDimensionsUnit;

    @JsonProperty("is_private")
    private Boolean isPrivate;

    @JsonProperty("recipient")
    private String recipient;

    @JsonProperty("occasion")
    private String occasion;

    @JsonProperty("style")
    private List<String> style;

    @JsonProperty("non_taxable")
    private Boolean nonTaxable;

    @JsonProperty("is_customizable")
    private Boolean customizable;

    @JsonProperty("is_digital")
    private Boolean digital;

    @JsonProperty("file_data")
    private String fileData;

    @JsonProperty("language")
    private String language;

    @JsonProperty("has_variations")
    private Boolean hasVariations;

    @JsonProperty("used_manufacturer")
    private Boolean usedManufacturer;

    @JsonProperty("taxonomy_id")
    private Long taxonomyId;

    @JsonProperty("taxonomy_path")
    private List<String> taxonomyPath;

    @JsonProperty("MainImage")
    private ListingImage mainImage;

    @JsonProperty("Images")
    private List<ListingImage> images;

    @JsonProperty("Shop")
    private Shop shop;

    @JsonProperty("Variations")
    private List<Property> variations;

    public Long getListingId() {
        return listingId;
    }

    public String getState() {
        return state;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Instant getCreationTime() {
        return creationTime;
    }

    public Instant getEndingTime() {
        return endingTime;
    }

    public Instant getOriginalCreationTime() {
        return originalCreationTime;
    }

    public Instant getLastModifiedTime() {
        return lastModifiedTime;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public List<String> getTags() {
        return tags;
    }

    public List<String> getCategoryPath() {
        return categoryPath;
    }

    public List<Long> getCategoryPathIds() {
        return categoryPathIds;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public Long getShopSectionId() {
        return shopSectionId;
    }

    public Integer getFeaturedRank() {
        return featuredRank;
    }

    public Instant getStateTime() {
        return stateTime;
    }

    public String getUrl() {
        return url;
    }

    public Integer getViews() {
        return views;
    }

    public Integer getNumFavorers() {
        return numFavorers;
    }

    public Long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public Integer getProcessingMin() {
        return processingMin;
    }

    public Integer getProcessingMax() {
        return processingMax;
    }

    public String getWhoMade() {
        return whoMade;
    }

    public Boolean isSupply() {
        return isSupply;
    }

    public void setSupply(Boolean supply) {
        this.isSupply = supply;
    }

    public String getWhenMade() {
        return whenMade;
    }

    public Boolean isPrivate() {
        return isPrivate;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getOccasion() {
        return occasion;
    }

    public List<String> getStyle() {
        return style;
    }

    public Boolean isNonTaxable() {
        return nonTaxable;
    }

    public Boolean isCustomizable() {
        return customizable;
    }

    public Boolean isDigital() {
        return digital;
    }

    public String getFileData() {
        return fileData;
    }

    public String getLanguage() {
        return language;
    }

    public Boolean isHasVariations() {
        return hasVariations;
    }

    public Boolean isUsedManufacturer() {
        return usedManufacturer;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public ListingImage getMainImage() {
        return mainImage;
    }

    public List<ListingImage> getImages() {
        return images;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
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

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setShippingTemplateId(Long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }

    public void setShopSectionId(Long shopSectionId) {
        this.shopSectionId = shopSectionId;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCustomizable(Boolean customizable) {
        this.customizable = customizable;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public void setWhoMade(String whoMade) {
        this.whoMade = whoMade;
    }

    public void setWhenMade(String whenMade) {
        this.whenMade = whenMade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEndingTime(Instant endingTime) {
        this.endingTime = endingTime;
    }

    public void setOriginalCreationTime(Instant originalCreationTime) {
        this.originalCreationTime = originalCreationTime;
    }

    public void setLastModifiedTime(Instant lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setCategoryPath(List<String> categoryPath) {
        this.categoryPath = categoryPath;
    }

    public void setCategoryPathIds(List<Long> categoryPathIds) {
        this.categoryPathIds = categoryPathIds;
    }

    public void setFeaturedRank(Integer featuredRank) {
        this.featuredRank = featuredRank;
    }

    public void setStateTime(Instant stateTime) {
        this.stateTime = stateTime;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public void setNumFavorers(Integer numFavorers) {
        this.numFavorers = numFavorers;
    }

    public void setProcessingMin(Integer processingMin) {
        this.processingMin = processingMin;
    }

    public void setProcessingMax(Integer processingMax) {
        this.processingMax = processingMax;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public void setStyle(List<String> style) {
        this.style = style;
    }

    public void setNonTaxable(Boolean nonTaxable) {
        this.nonTaxable = nonTaxable;
    }

    public void setDigital(Boolean digital) {
        this.digital = digital;
    }

    public void setFileData(String fileData) {
        this.fileData = fileData;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setHasVariations(Boolean hasVariations) {
        this.hasVariations = hasVariations;
    }

    public void setUsedManufacturer(Boolean usedManufacturer) {
        this.usedManufacturer = usedManufacturer;
    }

    public void setImages(List<ListingImage> images) {
        this.images = images;
    }

    public void setCreationTime(Instant creationTime) {
        this.creationTime = creationTime;
    }

    public Boolean getSupply() {
        return isSupply;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightUnits() {
        return weightUnits;
    }

    public void setWeightUnits(String weightUnits) {
        this.weightUnits = weightUnits;
    }

    public BigDecimal getItemLength() {
        return itemLength;
    }

    public void setItemLength(BigDecimal itemLength) {
        this.itemLength = itemLength;
    }

    public BigDecimal getItemWidth() {
        return itemWidth;
    }

    public void setItemWidth(BigDecimal itemWidth) {
        this.itemWidth = itemWidth;
    }

    public BigDecimal getItemHeight() {
        return itemHeight;
    }

    public void setItemHeight(BigDecimal itemHeight) {
        this.itemHeight = itemHeight;
    }

    public String getItemDimensionsUnit() {
        return itemDimensionsUnit;
    }

    public void setItemDimensionsUnit(String itemDimensionsUnit) {
        this.itemDimensionsUnit = itemDimensionsUnit;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public Boolean getNonTaxable() {
        return nonTaxable;
    }

    public Boolean getCustomizable() {
        return customizable;
    }

    public Boolean getDigital() {
        return digital;
    }

    public Boolean getHasVariations() {
        return hasVariations;
    }

    public Boolean getUsedManufacturer() {
        return usedManufacturer;
    }

    public void setListingId(long listingId) {
        this.listingId = listingId;
    }

    public List<Property> getVariations() {
        return variations;
    }

    public void setVariations(List<Property> variations) {
        this.variations = variations;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public void setMainImage(ListingImage mainImage) {
        this.mainImage = mainImage;
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

    public Listing() {
    }

    public Listing(Listing other) {
        this.listingId = other.listingId;
        this.state = other.state;
        this.userId = other.userId;
        this.categoryId = other.categoryId;
        this.title = other.title;
        this.description = other.description;
        this.creationTime = other.creationTime;
        this.endingTime = other.endingTime;
        this.originalCreationTime = other.originalCreationTime;
        this.lastModifiedTime = other.lastModifiedTime;
        this.price = other.price;
        this.currencyCode = other.currencyCode;
        this.quantity = other.quantity;
        this.tags = other.tags;
        this.categoryPath = other.categoryPath;
        this.categoryPathIds = other.categoryPathIds;
        this.materials = other.materials;
        this.shopSectionId = other.shopSectionId;
        this.featuredRank = other.featuredRank;
        this.stateTime = other.stateTime;
        this.url = other.url;
        this.views = other.views;
        this.numFavorers = other.numFavorers;
        this.shippingTemplateId = other.shippingTemplateId;
        this.processingMin = other.processingMin;
        this.processingMax = other.processingMax;
        this.whoMade = other.whoMade;
        this.isSupply = other.isSupply;
        this.whenMade = other.whenMade;
        this.weight = other.weight;
        this.weightUnits = other.weightUnits;
        this.itemDimensionsUnit = other.itemDimensionsUnit;
        this.itemHeight = other.itemHeight;
        this.itemLength = other.itemLength;
        this.itemWidth = other.itemWidth;
        this.isPrivate = other.isPrivate;
        this.recipient = other.recipient;
        this.occasion = other.occasion;
        this.style = other.style;
        this.nonTaxable = other.nonTaxable;
        this.customizable = other.customizable;
        this.digital = other.digital;
        this.fileData = other.fileData;
        this.language = other.language;
        this.hasVariations = other.hasVariations;
        this.usedManufacturer = other.usedManufacturer;
        this.taxonomyId = other.taxonomyId;
        this.taxonomyPath = other.taxonomyPath;
        this.images = other.images;
        this.shop = other.shop;

    }

    @Override
    public String toString() {
        return "Listing{" +
                "listingId=" + listingId +
                ", state='" + state + '\'' +
                ", userId=" + userId +
                ", categoryId=" + categoryId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", creationTime=" + creationTime +
                ", endingTime=" + endingTime +
                ", originalCreationTime=" + originalCreationTime +
                ", lastModifiedTime=" + lastModifiedTime +
                ", price=" + price +
                ", currencyCode='" + currencyCode + '\'' +
                ", quantity=" + quantity +
                ", tags=" + tags +
                ", categoryPath=" + categoryPath +
                ", categoryPathIds=" + categoryPathIds +
                ", materials=" + materials +
                ", shopSectionId=" + shopSectionId +
                ", featuredRank=" + featuredRank +
                ", stateTime=" + stateTime +
                ", url='" + url + '\'' +
                ", views=" + views +
                ", numFavorers=" + numFavorers +
                ", shippingTemplateId=" + shippingTemplateId +
                ", processingMin=" + processingMin +
                ", processingMax=" + processingMax +
                ", whoMade='" + whoMade + '\'' +
                ", isSupply=" + isSupply +
                ", whenMade='" + whenMade + '\'' +
                ", isPrivate=" + isPrivate +
                ", recipient='" + recipient + '\'' +
                ", occasion='" + occasion + '\'' +
                ", style=" + style +
                ", nonTaxable=" + nonTaxable +
                ", customizable=" + customizable +
                ", digital=" + digital +
                ", fileData='" + fileData + '\'' +
                ", language='" + language + '\'' +
                ", hasVariations=" + hasVariations +
                ", usedManufacturer=" + usedManufacturer +
                ", taxonomyId=" + taxonomyId +
                ", taxonomyPath=" + taxonomyPath +
                ", images=" + images +
                ", shop=" + shop +
                '}';
    }
}
