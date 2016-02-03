package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import rx.Observable;

import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public interface IReceiptsService {
    /**
     * Retrieves a Receipt by id
     */
    Observable<Response<Receipt>> getReceipt(
            Collection<Long> receiptsIds,
            Collection<String> includes,
            Collection<String> fields
    );

    /**
     * Retrieves a set of Transaction objects associated to a Receipt
     */
    Observable<Response<Transaction>> findAllReceiptTransactions(
            long receiptId,

            Collection<String> includes,
            Collection<String> fields
    );
}
