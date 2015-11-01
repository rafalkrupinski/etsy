package com.hashnot.etsy;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.io.IOException;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("/v2/receipts")
public interface Receipts {
    @GET
    @Path("/{receiptIds}")
    Response<Receipt> getReceipt(
            @PathParam("receipt_id") List<Long> receiptsIds
    ) throws IOException;
}
