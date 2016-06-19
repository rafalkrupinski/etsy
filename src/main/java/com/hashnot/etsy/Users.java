package com.hashnot.etsy;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.ShippingTemplate;
import com.hashnot.etsy.dto.Shop;
import com.hashnot.etsy.dto.User;
import com.hashnot.etsy.dto.dict.ChargesMetadata;
import com.hashnot.etsy.dto.dict.DictionaryResponse;
import com.hashnot.etsy.dto.fin.BillCharge;
import com.hashnot.etsy.dto.fin.BillPayment;
import com.hashnot.etsy.dto.fin.BillingOverview;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.time.Duration;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface Users {
    enum SortOrder {
        up, down
    }

    /**
     * Maximum diff between from and to when calling findAllUserCharges
     */
    Duration MAX_DURATION = Duration.ofSeconds(2678400);

    /**
     * Retrieves a User by id.
     */
    @GET
    @Path("/users/{user_id}")
    Response<User> getUser(
            @PathParam("user_id") String userId,

            @QueryParam("api_key") String apiKey,

            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    /**
     * Retrieves a User by id.
     */
    @GET
    @Path("/users/{user_id}")
    Response<User> getUser(
            @PathParam("user_id") long userId,

            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    /**
     * Retrieves a set of ShippingTemplate objects associated to a User.
     */
    @GET
    @Path("/users/{user_id}/shipping/templates")
    Response<ShippingTemplate> findAllUserShippingProfiles(
            @PathParam("user_id") long userId
    ) throws IOException;

    /**
     * Retrieves a set of Shop objects associated to a User.
     */
    @GET
    @Path("/users/{user_id}/shops")
    Response<Shop> findAllUserShops(
            @PathParam("user_id") long userId,

            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    /**
     * Retrieves the user's current balance.
     */
    @GET
    @Path("/users/{user_id}/billing/overview")
    Response<BillingOverview> getUserBillingOverview(
            @PathParam("user_id") long userId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Metadata for the set of BillCharges objects associated to a User
     */
    @GET
    @Path("/users/{user_id}/charges/meta")
    DictionaryResponse<ChargesMetadata> getUserChargesMetadata(
            @PathParam("user_id") long userId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Retrieves a set of BillCharge objects associated to a User
     * Time window between min_created and max_created must be no more than 2678400 seconds (31 days)
     *
     * @param from closed lower bound of the BillCharge creation time
     * @param to open upper bound of the BillCharge creation time
     */
    @GET
    @Path("/users/{user_id}/charges")
    Response<BillCharge> findAllUserCharges(
            @PathParam("user_id") long userId,

            @QueryParam("sort_order") SortOrder sortOrder,
            @QueryParam("min_created") long from,
            @QueryParam("max_created") long to,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Retrieves a set of BillPayment objects associated to a User
     */
    @GET
    @Path("/users/{user_id}/payments")
    Response<BillPayment> findAllUserPayments(
            @PathParam("user_id") long userId,

            @QueryParam("sort_order") SortOrder sortOrder,
            @QueryParam("min_created") long from,
            @QueryParam("max_created") long to,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;
}
