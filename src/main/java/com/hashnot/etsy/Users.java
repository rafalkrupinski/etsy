package com.hashnot.etsy;

import com.hashnot.etsy.dto.*;
import com.hashnot.etsy.dto.dict.ChargesMetadata;
import com.hashnot.etsy.dto.dict.DictionaryResponse;
import com.hashnot.etsy.dto.fin.BillCharge;
import com.hashnot.etsy.dto.fin.BillingOverview;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface Users {
    @GET
    @Path("/users/{userId}")
    Response<User> getUser(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String user,
            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    @GET
    @Path("/users/{userId}/shipping/templates")
    Response<ShippingTemplate> findAllUserShippingProfiles(
            @PathParam("userId") String userId
    ) throws IOException;

    @GET
    @Path("/users/{userId}/shops")
    Response<Shop> findAllUserShops(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String userId,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    @GET
    @Path("/users/{userId}/billing/overview")
    Response<BillingOverview> getUserBillingOverview(
            @PathParam("userId") String userId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    @GET
    @Path("/users/{userId}/charges/meta")
    DictionaryResponse<ChargesMetadata> getUserChargesMetadata(
            @PathParam("userId") String userId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Time window between min_created and max_created must be no more than 2678400 seconds (31 days)
     */
    @GET
    @Path("/users/{userId}/charges")
    Response<BillCharge> findAllUserCharges(
            @PathParam("userId") String userId,
            @QueryParam("sort_order") SortOrder sortOrder,
            @QueryParam("min_created") long from,
            @QueryParam("max_created") long to,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    enum SortOrder {
        up, down
    }
}
