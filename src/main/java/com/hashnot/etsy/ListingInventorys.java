package com.hashnot.etsy;

import com.hashnot.etsy.dto.ListingInventory;
import com.hashnot.etsy.dto.dict.DictionaryResponse;

import javax.ws.rs.*;
import java.io.IOException;

/**
 * @author rougeSE
 */
@Path("v2/listings")
public interface ListingInventorys {

	/**
	 * Get the inventory for a listing
	 * 
	 * When a listing has not been edited using the 
	 * new inventory tools, it will have no inventory
	 * records. We generate suitable records on the
	 * fly, but don’t write them out by default. If you 
	 * need to get stable product_id and offering_id fields, 
	 * pass the write_missing_inventory parameter as true 
	 * and we’ll persist the records. 
	 * 
	 * @param listingId
	 * @param writeMissingInventory
	 * @param limit
	 * @param offset
	 * @param includes
	 * @param fields
	 * @param apiKey
	 * @return
	 * @throws IOException
	 */
    @GET
    @Path("{listing_id}/inventory")
    @Produces("application/json")
    DictionaryResponse<ListingInventory> getInventory(
            @PathParam("listing_id") int listingId,
            
            @QueryParam("write_missing_inventory") Boolean writeMissingInventory,
           
            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("api_key")String apiKey
    ) throws IOException;
    
    /**
     * Update the inventory for a listing 
     * 
     *  price_on_property is an array of the 
     *  property_ids of the properties which 
     *  price depends on (if any).
     *  quantity_on_property is an array of the 
     *  property_ids of the properties which quantity 
     *  depends on (if any).
     *  sku_on_property is an array of the property_ids 
     *  of the properties which sku depends on (if any).
     *  The update will fail if the supplied values for 
     *  product sku and offering quantity and price are 
     *  incompatible with the supplied values of the 
     *  "on_property_*" fields. When supplying a price, 
     *  supply a float equivalent to amount divided by 
     *  divisor as specified in the Money resource.
     *  The products parameter should be a JSON 
     *  array of products, even if you only send a single 
     *  product. All field names in the JSON blob should 
     *  be lowercase. 
     * @param listingId
     * @param products
     * @param priceOnProperty
     * @param quantityOnProperty
     * @param skuOnProperty
     * @param includes
     * @param fields
     * @param apiKey
     * @throws IOException
     */
    @PUT
    @Path("{listing_id}/inventory")
    @Produces("application/json")
    void updateInventory(
            @PathParam("listing_id") int listingId,
            
            @QueryParam("products") Iterable<String> products,
            @QueryParam("price_on_property") Iterable<Integer> priceOnProperty,
            @QueryParam("quantity_on_property") Iterable<Integer> quantityOnProperty,
            @QueryParam("sku_on_property") Iterable<Integer> skuOnProperty,
            
            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("api_key")String apiKey
    ) throws IOException;

}
