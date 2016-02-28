package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.fin.Payment;
import com.hashnot.etsy.dto.fin.PaymentAdjustment;
import com.hashnot.etsy.dto.fin.PaymentAdjustmentItem;
import rx.Observable;

/**
 * @author Rafał Krupiński
 */
public interface IPaymentsService {
    Observable<Response<Payment>> findPayment(
            Iterable<Long> paymentIds
    );

    Observable<Response<Payment>> findPayment(
            long paymentId
    );

    Observable<Response<PaymentAdjustment>> findPaymentAdjustments(
            long paymentId
    );

    Observable<Response<PaymentAdjustmentItem>> findPaymentAdjustmentItem(
            long paymentId,
            long paymentAdjustmentId
    );
}
