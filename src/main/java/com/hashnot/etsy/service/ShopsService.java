package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.fin.LedgerEntry;
import com.hashnot.etsy.dto.fin.Payment;
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

import java.time.Instant;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService implements IShopsService {
    private Shops shops;

    public ShopsService(Executor2 executor, Shops shops) {
        super(executor);
        this.shops = shops;
    }

    @Override
    public Observable<Response<Listing>> findAllShopListings(long shopId, Collection<String> includes, Collection<String> fields) {
        Observable<Response<Listing>> result = null;
        for (Listing.Status state : Listing.Status.values()) {
            if (!state.listable)
                continue;
            Observable<Response<Listing>> observable = call(offset -> shops.findAllShopListings(shopId, state.name(), null, offset, null, includes, fields)).filter(r -> r.getCount() != 0);
            if (result != null)
                result = result.concatWith(observable);
            else
                result = observable;
        }

        return result;
    }

    @Override
    public Observable<Response<Receipt>> findAllShopReceipts(
            long shopId,
            Instant createdFrom,
            Instant createdTo,
            Boolean paid,
            Boolean shipped,

            Integer limit,

            Collection<String> includes,
            Collection<String> fields
    ) {
        Integer from = toTimeStamp(createdFrom);
        Integer to = toTimeStamp(createdTo);
        return call(offset -> shops.findAllShopReceipts(shopId, from, to, paid, shipped, limit, offset, null, includes, fields));
    }

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    @Override
    public Observable<Response<LedgerEntry>> findLedgerEntries(
            long shopId,
            Instant minCreated,
            Instant maxCreated,
            Integer limit,
            Collection<String> fields
    ) {
        Integer from = toTimeStamp(minCreated);
        Integer to = toTimeStamp(maxCreated);
        return call(offset -> shops.findLedgerEntries(shopId, from, to, limit, offset, null, fields));
    }

    /**
     * Retrieves Listings associated to a Shop that are featured
     */
    @Override
    public Observable<Response<Listing>> findAllShopListingsFeatured(
            long shopId,
            Collection<String> includes,
            Collection<String> fields
    ) {
        return call(offset -> shops.findAllShopListingsFeatured(shopId, null, offset, null, includes, fields));
    }

    @Override
    public Observable<Response<Payment>> findShopPaymentByReceipt(
            long shopId,
            long receiptId,
            Collection<String> fields
    ) {
        return call(offset -> shops.findShopPaymentByReceipt(shopId, receiptId, null, offset, null, fields));
    }

}
