package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.*;
import com.hashnot.etsy.dto.fin.LedgerEntry;
import com.hashnot.etsy.dto.fin.Payment;
import rx.Observable;

import java.time.Instant;
import java.util.Collection;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService implements IShopsService {
    private Shops shops;

    public ShopsService(Executor executor, Shops shops) {
        super(executor);
        this.shops = shops;
    }

    @Override
    public Observable<Response<Listing>> findAllShopListings(String shopId, Collection<String> includes, Collection<String> fields) {
        Observable<Response<Listing>> result = null;
        for (Listing.AvailableState state : Listing.AvailableState.values()) {
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
            String shopId,
            Instant createdFrom,
            Instant createdTo,
            Boolean paid,
            Boolean shipped,
            Integer limit, Collection<String> includes,
            Collection<String> fields
    ) {
        return call(offset -> shops.findAllShopReceipts(shopId, toTimeStamp(createdFrom), toTimeStamp(createdTo), paid, shipped, limit, offset, null, includes, fields));
    }

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    @Override
    public Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            Instant minCreated,
            Instant maxCreated,
            Integer limit,
            Collection<String> fields
    ) {
        return call(offset -> shops.findLedgerEntries(shopId, toTimeStamp(minCreated), toTimeStamp(maxCreated), limit, offset, null, fields));
    }

    /**
     * Retrieves Listings associated to a Shop that are featured
     */
    @Override
    public Observable<Response<Listing>> findAllShopListingsFeatured(
            String shopId,
            Collection<String> includes,
            Collection<String> fields
    ) {
        return call(offset -> shops.findAllShopListingsFeatured(shopId, includes, fields, null, offset, null));
    }

    @Override
    public Observable<Response<Payment>> findShopPaymentByReceipt(
            long receiptId,
            String shopId,
            Collection<String> fields
    ) {
        return call(offset -> shops.findShopPaymentByReceipt(receiptId, shopId, null, offset, null, fields));
    }

}
