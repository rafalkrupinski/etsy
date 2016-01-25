package com.hashnot.etsy;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;

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
    @GET
    @Path("/{receipt_id}")
    Response<Receipt> getReceipt(
            @PathParam("receipt_id") Collection<Long> receiptsIds,
            @QueryParam("includes") Collection<String> includes,
            @QueryParam("fields") Collection<String> fields,
            @QueryParam("offset") Integer offset
    ) throws IOException;
}
