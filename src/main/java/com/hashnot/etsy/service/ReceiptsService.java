package com.hashnot.etsy.service;

import com.hashnot.etsy.Receipts;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
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
        return call(offset -> receipts.getReceipt(receiptsIds, offset, includes, fields));
    }

    public Observable<Response<Transaction>> findAllReceiptTransactions(
            long receiptId,

            Collection<String> includes,
            Collection<String> fields
    ) {
        return call(offset -> receipts.findAllReceiptTransactions(receiptId, null, offset, null, includes, fields));
    }

}
