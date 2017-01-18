package com.hashnot.etsy.service;

import com.hashnot.etsy.Receipts;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public class ReceiptsService extends AbstractEtsyService implements IReceiptsService {
    final private Receipts receipts;

    public ReceiptsService(Receipts receipts, Executor2 executor) {
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
