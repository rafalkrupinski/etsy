package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Payment;
import com.hashnot.etsy.dto.PaymentAdjustment;
import com.hashnot.etsy.dto.PaymentAdjustmentItem;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.util.List;

/**
 * @author Rafał Krupiński
 */
public interface IPaymentsService {
    Observable<Response<Payment>> findPayment(
            List<Long> paymentId
    );

    Observable<Response<PaymentAdjustment>> findPaymentAdjustments(
            long paymentId
    );

    Observable<Response<PaymentAdjustmentItem>> findPaymentAdjustmentItem(
            long paymentId,
            long paymentAdjustmentId
    );
}
