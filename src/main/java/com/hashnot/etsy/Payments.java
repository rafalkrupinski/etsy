package com.hashnot.etsy;

import com.hashnot.etsy.dto.fin.Payment;
import com.hashnot.etsy.dto.fin.PaymentAdjustment;
import com.hashnot.etsy.dto.fin.PaymentAdjustmentItem;
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
@Path("v2/payments")
public interface Payments {
    /**
     * Get a Direct Checkout Payment
     */
    @GET
    @Path("{payment_id}")
    Response<Payment> findPayment(
            @PathParam("payment_id") List<Long> paymentId
    ) throws IOException;

    /**
     * Get a Payment Adjustments from a Payment Id
     */
    @GET
    @Path("{payment_id}/adjustments")
    Response<PaymentAdjustment> findPaymentAdjustments(
            @PathParam("payment_id") long paymentId,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;

    /**
     * Get Direct Checkout Payment Adjustment Items
     */
    @GET
    @Path("{payment_id}/adjustments/{payment_adjustment_id}/items")
    Response<PaymentAdjustmentItem> findPaymentAdjustmentItem(
            @PathParam("payment_id") long paymentId,
            @PathParam("payment_adjustment_id") long paymentAdjustmentId,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,
            @QueryParam("page") Integer page
    ) throws IOException;
}
