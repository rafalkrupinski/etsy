package com.hashnot.etsy.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ListingInventory extends EtsyObject 
{
	@JsonProperty
    private List<ListingProduct> products;
	
	@JsonProperty("price_on_property")
    private List<Integer> priceOnProperty;
	
	@JsonProperty("quantity_on_property")
    private List<Integer> quantityOnProperty;
	
	@JsonProperty("sku_on_property")
    private List<Integer> skuOnProperty;
	
	/**
	 * The products available for this listing. 	
	 * @return
	 */
	public List<ListingProduct> getProducts() {
		return products;
	}

	/**
	 * The products available for this listing. 
	 * @param products
	 */
	public void setProducts(List<ListingProduct> products) {
		this.products = products;
	}

	/**
	 * Which properties control price? 
	 * @return
	 */
	public List<Integer> getPriceOnProperty() {
		return priceOnProperty;
	}

	/**
	 * Which properties control price? 
	 * @param priceOnProperty
	 */
	public void setPriceOnProperty(List<Integer> priceOnProperty) {
		this.priceOnProperty = priceOnProperty;
	}

	/**
	 * Which properties control quantity?
	 * @return
	 */
	public List<Integer> getQuantityOnProperty() {
		return quantityOnProperty;
	}

	/**
	 * Which properties control quantity?
	 * @param quantityOnProperty
	 */
	public void setQuantityOnProperty(List<Integer> quantityOnProperty) {
		this.quantityOnProperty = quantityOnProperty;
	}

	/**
	 * Which properties control SKU? 
	 * @return
	 */
	public List<Integer> getSkuOnProperty() {
		return skuOnProperty;
	}

	/**
	 * Which properties control SKU? 
	 * @param skuOnProperty
	 */
	public void setSkuOnProperty(List<Integer> skuOnProperty) {
		this.skuOnProperty = skuOnProperty;
	}


	@Override
    public String toString() {
        return "Inventory{" +
                "products=" + products.toString()+
                ", priceOnProperty=" + String.valueOf(priceOnProperty)+
                ", quantityOnProperty=" + String.valueOf(quantityOnProperty) +
                ", skuOnProperty=" + String.valueOf(skuOnProperty) +
                '}';
    }
	
}
