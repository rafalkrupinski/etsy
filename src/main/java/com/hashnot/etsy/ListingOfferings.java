package com.hashnot.etsy;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.dict.DictionaryResponse;

import javax.ws.rs.*;
import java.io.IOException;

/**
 * @author rougeSE
 */
@Path("v2/listings")
public interface ListingOfferings {

    @GET
    @Path("{listing_id}/products/{product_id}/offerings/{offering_id}")
    @Produces("application/json")
    DictionaryResponse<Listing> getOffering(
            @PathParam("listing_id") int listingId,
            @PathParam("product_id") int productId,
            @PathParam("offering_id") int offeringId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,

            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("api_key")String apiKey
    ) throws IOException;
}
