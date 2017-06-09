package com.hashnot.etsy.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.deser.impl.PropertyValue;

/**
 * A class representing a single product in Etsy.
 */
public class ListingProduct extends EtsyObject {

	@JsonProperty("product_id")
    private int productId;
	
	@JsonProperty("property_values")
	private List<PropertyValue> propertyValues;
	
	@JsonProperty
	private String sku;
	
	@JsonProperty
	private List<ListingOffering> offerings;
	
	@JsonProperty("is_deleted")
	private Boolean isDeleted;

	/**
	 * The numeric ID of this product. 
	 * @return
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * The numeric ID of this product. 
	 * @param productId
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * A list of 0-2 properties associated with 
	 * this product and their values. 
	 * @return
	 */
	public List<PropertyValue> getPropertyValues() {
		return propertyValues;
	}

	/**
	 * A list of 0-2 properties associated with 
	 * this product and their values. 
	 * @param propertyValues
	 */
	public void setPropertyValues(List<PropertyValue> propertyValues) {
		this.propertyValues = propertyValues;
	}

	/**
	 * The product identifier (if set). 
	 * @return
	 */
	public String getSku() {
		return sku;
	}

	/**
	 * The product identifier (if set). 
	 * @param sku
	 */
	public void setSku(String sku) {
		this.sku = sku;
	}

	/**
	 * A JSON list of active offerings 
	 * for this product. 
	 * @return
	 */
	public List<ListingOffering> getOfferings() {
		return offerings;
	}

	/**
	 * A JSON list of active offerings 
	 * for this product. 
	 * @param offerings
	 */
	public void setOfferings(List<ListingOffering> offerings) {
		this.offerings = offerings;
	}

	/**
	 * Has the product been deleted?
	 * @return
	 */
	public Boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * Has the product been deleted?
	 * @param isDeleted
	 */
	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
    public String toString() {
        return "Product{" +
                "productId=" + productId+
                ", propertyValues='" + propertyValues.toString()+ '\'' +
                ", sku=" + sku +
                ", offerings=" + offerings.toString() +
                ", isDeleted='" + isDeleted +
                '}';
    }
	
}
