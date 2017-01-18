package com.hashnot.etsy.service;

import com.hashnot.etsy.Transactions;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

/**
 * @author Rafał Krupiński
 */
public class TransactionsService extends AbstractEtsyService implements ITransactionsService {
    private final Transactions transactions;

    public TransactionsService(Transactions transactions, Executor2 executor) {
        super(executor);
        this.transactions = transactions;
    }

    /**
     * Get a Direct Checkout Payment
     */
    @Override
    public Observable<Response<Transaction>> getTransaction(
            long transactionId,
            Iterable<String> includes,
            Iterable<String> fields,
            Integer limit
    ) {
        return call(offset -> transactions.getTransaction(transactionId, includes, fields, limit, offset));
    }
}
