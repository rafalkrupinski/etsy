package com.hashnot.etsy;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface FeaturedTreasuries {

    /**
     * Finds all FeaturedTreasury listings.
     */
    @GET
    @Path("/featured_treasuries/listings")
    Response<Listing> findAllFeaturedListings(
            @QueryParam("includes") List<String> includes,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("region") String region
    ) throws IOException;
}
