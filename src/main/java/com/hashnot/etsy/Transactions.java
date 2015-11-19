package com.hashnot.etsy;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("v2/transactions")
public interface Transactions {
    /**
     * Retrieves a set of Transaction objects associated to a Listing.
     */
    @GET
    @Path("{transaction_id}")
    Response<Transaction> getTransaction(
            @PathParam("transaction_id") List<Long> transactionId,
            @QueryParam("includes") List<String> includes,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;
}
