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
    @Path("/users/{userId}")
    Response<User> getUser(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String user,
            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    /**
     * Retrieves a set of ShippingTemplate objects associated to a User.
     */
    @GET
    @Path("/users/{userId}/shipping/templates")
    Response<ShippingTemplate> findAllUserShippingProfiles(
            @PathParam("userId") String userId
    ) throws IOException;

    /**
     * Retrieves a set of Shop objects associated to a User.
     */
    @GET
    @Path("/users/{userId}/shops")
    Response<Shop> findAllUserShops(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String userId,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("includes") Iterable<String> includes
    ) throws IOException;

    /**
     * Retrieves the user's current balance.
     */
    @GET
    @Path("/users/{userId}/billing/overview")
    Response<BillingOverview> getUserBillingOverview(
            @PathParam("userId") String userId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Metadata for the set of BillCharges objects associated to a User
     */
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
     * Retrieves a set of BillCharge objects associated to a User
     * Time window between min_created and max_created must be no more than 2678400 seconds (31 days)
     *
     * @param from closed lower bound of the BillCharge creation time
     * @param to open upper bound of the BillCharge creation time
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

    /**
     * Retrieves a set of BillPayment objects associated to a User
     */
    @GET
    @Path("/users/{userId}/payments")
    Response<BillPayment> findAllUserPayments(
            @PathParam("userId") String userId,
            @QueryParam("sort_order") SortOrder sortOrder,
            @QueryParam("min_created") long from,
            @QueryParam("max_created") long to,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;
}
