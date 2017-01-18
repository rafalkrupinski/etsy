package com.hashnot.etsy;

import com.hashnot.etsy.dto.*;
import com.hashnot.etsy.dto.fin.Ledger;
import com.hashnot.etsy.dto.fin.LedgerEntry;
import com.hashnot.etsy.dto.fin.Payment;

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
public interface Shops {

    @GET
    @Path("/shops")
    Response<Shop> findAllShops(
            @QueryParam("api_key") String apiKey,
            @QueryParam("shop_name") String shopName
    ) throws IOException;

    @GET
    @Path("/shops/{shop_id}/receipts")
    Response<Shop> findAllShopReceipts(
            @PathParam("shop_id") long shopId,
            @QueryParam("api_key") String apiKey
    ) throws IOException;

    @GET
    @Path("/shops/{shop_id}/sections")
    Response<ShopSection> findAllShopSections(
            @PathParam("shop_id") long shopId
    ) throws IOException;

    @GET
    @Path("/shops/{shop_id}/listings/{status}")
    Response<Listing> findAllShopListings(
            @PathParam("shop_id") long shopId,
            @PathParam("status") String status,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,
            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * <a href='https://www.etsy.com/developers/documentation/reference/receipt#method_findallshopreceipts'>findAllShopReceipts</a>
     */
    @GET
    @Path("/shops/{shop_id}/receipts")
    Response<Receipt> findAllShopReceipts(
            @PathParam("shop_id") long shopId,

            @QueryParam("min_created") Integer createdFrom,
            @QueryParam("max_created") Integer createdTo,
            @QueryParam("was_paid") Boolean paid,
            @QueryParam("was_shipped") Boolean shipped,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Get a Shop Payment Account Ledger
     */
    @GET
    @Path("/shops/{shop_id}/ledger/")
    Response<Ledger> findLedger(
            @PathParam("shop_id") long shopId,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    @GET
    @Path("/shops/{shop_id}/ledger/entries")
    Response<LedgerEntry> findLedgerEntries(
            @PathParam("shop_id") long shopId,

            @QueryParam("min_created") Integer minCreated,
            @QueryParam("max_created") Integer maxCreated,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Get a Payment by Shop Receipt ID
     */
    @GET
    @Path("/shops/{shop_id}/receipts/{receipt_id}/payments")
    Response<Payment> findShopPaymentByReceipt(
            @PathParam("shop_id") long shopId,
            @PathParam("receipt_id") long receiptId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Retrieves Listings associated to a Shop that are featured
     */
    @GET
    @Path("/shops/{shop_id}/listings/featured")
    Response<Listing> findAllShopListingsFeatured(
            @PathParam("shop_id") long shopId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields
    ) throws IOException;
}
