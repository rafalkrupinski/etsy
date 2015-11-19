package com.hashnot.etsy;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("/v2/receipts")
public interface Receipts {
    @GET
    @Path("/{receipt_id}")
    Response<Receipt> getReceipt(
            @PathParam("receipt_id") List<Long> receiptsIds,
            @QueryParam("includes") List<String> includes
    ) throws IOException;
}
