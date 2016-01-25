package com.hashnot.etsy.service;

import com.hashnot.etsy.Payments;
import com.hashnot.etsy.dto.Payment;
import com.hashnot.etsy.dto.PaymentAdjustment;
import com.hashnot.etsy.dto.PaymentAdjustmentItem;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class PaymentsService extends AbstractEtsyService implements IPaymentsService {
    private final Payments payments;

    public PaymentsService(Payments payments, Executor executor) {
        super(executor);
        this.payments = payments;
    }

    /**
     * Get a Direct Checkout Payment
     */
    @Override
    public Observable<Response<Payment>> findPayment(
            List<Long> paymentId
    ) {
        return call(limit -> payments.findPayment(paymentId));
    }

    /**
     * Get a Payment Adjustments from a Payment Id
     */
    @Override
    public Observable<Response<PaymentAdjustment>> findPaymentAdjustments(
            long paymentId
    ) {
        return call(offset -> payments.findPaymentAdjustments(paymentId, null, offset, null));
    }

    /**
     * Get Direct Checkout Payment Adjustment Items
     */
    @Override
    public Observable<Response<PaymentAdjustmentItem>> findPaymentAdjustmentItem(
            long paymentId,
            long paymentAdjustmentId
    ) {
        return call(offset -> payments.findPaymentAdjustmentItem(paymentId, paymentAdjustmentId, null, offset, null));
    }

}
