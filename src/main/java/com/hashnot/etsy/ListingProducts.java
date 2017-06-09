package com.hashnot.etsy;

import com.hashnot.etsy.dto.ListingProduct;
import com.hashnot.etsy.dto.dict.DictionaryResponse;

import javax.ws.rs.*;
import java.io.IOException;

/**
 * @author rougeSE
 */
@Path("v2/listings")
public interface ListingProducts {

    @GET
    @Path("{listing_id}/products/{product_id}")
    @Produces("application/json")
    DictionaryResponse<ListingProduct> getProduct(
            @PathParam("listing_id") int listingId,
            @PathParam("product_id") int productId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,

            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("api_key")String apiKey
    ) throws IOException;
}
