package com.hashnot.etsy;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
@Path("/v2/receipts")
public interface Receipts {
    /**
     * Retrieves a Receipt by id
     */
    @GET
    @Path("/{receipt_id}")
    Response<Receipt> getReceipt(
            @PathParam("receipt_id") Collection<Long> receiptsIds,

            @QueryParam("offset") Integer offset,

            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields
    ) throws IOException;

    /**
     * Retrieves a set of Transaction objects associated to a Receipt
     */
    @GET
    @Path("/{receipt_id}/transactions")
    Response<Transaction> findAllReceiptTransactions(
            @PathParam("receipt_id") long receiptId,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page,

            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields
    ) throws IOException;
}
