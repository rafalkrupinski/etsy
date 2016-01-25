package com.hashnot.etsy.service;

import com.hashnot.etsy.Receipts;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.util.Collection;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ReceiptsService extends AbstractEtsyService implements IReceiptsService {
    final private Receipts receipts;

    public ReceiptsService(Receipts receipts, Executor executor) {
        super(executor);
        this.receipts = receipts;
    }

    @Override
    public Observable<Response<Receipt>> getReceipt(
            Collection<Long> receiptsIds,
            Collection<String> includes,
            Collection<String> fields
    ) {
        return call(offset -> receipts.getReceipt(receiptsIds, includes, fields, offset));
    }
}
