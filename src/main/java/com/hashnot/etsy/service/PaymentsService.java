package com.hashnot.etsy.service;

import com.hashnot.etsy.Payments;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.fin.Payment;
import com.hashnot.etsy.dto.fin.PaymentAdjustment;
import com.hashnot.etsy.dto.fin.PaymentAdjustmentItem;
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

import static java.util.Collections.singleton;

/**
 * @author Rafał Krupiński
 */
public class PaymentsService extends AbstractEtsyService implements IPaymentsService {
    private final Payments payments;

    public PaymentsService(Payments payments, Executor2 executor) {
        super(executor);
        this.payments = payments;
    }

    /**
     * Get a Direct Checkout Payment
     */
    @Override
    public Observable<Response<Payment>> findPayment(
            Iterable<Long> paymentId
    ) {
        return call(limit -> payments.findPayment(paymentId));
    }

    /**
     * Get a Direct Checkout Payment
     */
    @Override
    public Observable<Response<Payment>> findPayment(
            long paymentId
    ) {
        return call(limit -> payments.findPayment(singleton(paymentId)));
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
