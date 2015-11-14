package com.hashnot.etsy;

import com.hashnot.etsy.dto.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.Date;
import java.util.List;

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
    @Path("/shops/{shopId}/receipts")
    Response<Shop> findAllShopReceipts(
            @QueryParam("api_key") String apiKey,
            @PathParam("shopId") String user
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/sections")
    Response<ShopSection> findAllShopSections(
            @PathParam("shopId") String shopId
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/listings/{status}")
    Response<Listing> findAllShopListings(
            @PathParam("shopId") String shopId,
            @PathParam("status") String status,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/receipts")
    Response<Receipt> findAllShopReceipts(
            @PathParam("shopId") String shopId,
            @QueryParam("min_created") Date createdFrom,
            @QueryParam("max_created") Date createdTo,

            @QueryParam("was_paid") Boolean paid,
            @QueryParam("was_shipped") Boolean shipped,

            @QueryParam("includes") List<String> includes,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;

    /**
     * Get a Shop Payment Account Ledger
     */
    @GET
    @Path("/shops/{shopId}/ledger/")
    Response<Ledger> findLedger(@PathParam("shopId") String shopId) throws IOException;

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    @GET
    @Path("/shops/{shopId}/ledger/entries")
    Response<LedgerEntry> findLedgerEntries(
            @PathParam("shopId") String shopId,
            @QueryParam("min_created") Date minCreated,
            @QueryParam("max_created") Date maxCreated,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;

    /**
     * Get a Payment by Shop Receipt ID
     */
    @GET
    @Path("/shops/{shop_id}/receipts/{receipt_id}/payments")
    Response<Payment> findShopPaymentByReceipt(
            @PathParam("receipt_id") long receiptId,
            @PathParam("shop_id") String shopId,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;
}
