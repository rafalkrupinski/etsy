package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListingOffering extends EtsyObject 
{
	@JsonProperty("offering_id")
    private int offeringId;
	
	@JsonProperty
    private Money price;
	
	@JsonProperty
    private int quantity;
	
	@JsonProperty("is_enabled")
    private Boolean isEnabled;
	
	@JsonProperty("is_deleted")
    private Boolean isDeleted;


	/**
	 * The numeric ID of this offering.
	 * @return
	 */
	public int getOfferingId() {
		return offeringId;
	}

	/**The numeric ID of this offering.
	 * 
	 * @param offeringId
	 */
	public void setOfferingId(int offeringId) {
		this.offeringId = offeringId;
	}

	/**
	 * The price of the product 
	 * @return
	 */
	public Money getPrice() {
		return price;
	}

	/**
	 * The price of the product 
	 * @param price
	 */
	public void setPrice(Money price) {
		this.price = price;
	}

	/**
	 * How many of this product are available?
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * How many of this product are available?
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Is the offering shown to buyers? 
	 * @return
	 */
	public Boolean isEnabled() {
		return isEnabled;
	}

	/**
	 * Is the offering shown to buyers? 
	 * @param isEnabled
	 */
	public void setEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	/**
	 * Has the offering been deleted? 
	 * @return
	 */
	public Boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * Has the offering been deleted? 
	 * @param isDeleted
	 */
	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	
	@Override
    public String toString() {
        return "Offering{" +
                "offeringId=" + offeringId+
                ", price='" + price.toString()+ '\'' +
                ", quantity=" + quantity +
                ", isEnabled=" + isEnabled +
                ", isDeleted='" + isDeleted +
                '}';
    }
	
}
