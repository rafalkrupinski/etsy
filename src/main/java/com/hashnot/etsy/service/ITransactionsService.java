package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import rx.Observable;

/**
 * @author Rafał Krupiński
 */
public interface ITransactionsService {
    Observable<Response<Transaction>> getTransaction(
            long transactionId,
            Iterable<String> includes,
            Iterable<String> fields,
            Integer limit
    );
}
