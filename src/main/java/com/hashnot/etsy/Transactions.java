package com.hashnot.etsy;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;

/**
 * @author Rafał Krupiński
 */
@Path("v2/transactions")
public interface Transactions {
    /**
     * Retrieves a set of Transaction objects associated to a Listing.
     */
    @GET
    @Path("/{transaction_id}")
    Response<Transaction> getTransaction(
            @PathParam("transaction_id") long transactionId,

            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;
}
