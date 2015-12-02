package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.LedgerEntry;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService {
    private Shops shops;

    public ShopsService(String apiKey, Executor executor, Shops shops) {
        super(apiKey, executor);
        this.shops = shops;
    }

    public Observable<Response<Listing>> findAllShopListings(String shopId) {
        Observable<Response<Listing>> active = call(offset -> shops.findAllShopListings(shopId, "active", MAX_LIMIT, offset, null));
        Observable<Response<Listing>> expired = call(offset -> shops.findAllShopListings(shopId, "expired", MAX_LIMIT, offset, null));
        Observable<Response<Listing>> inactive = call(offset -> shops.findAllShopListings(shopId, "inactive", MAX_LIMIT, offset, null));
        return Observable.concat(active, expired, inactive);
    }

    public Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            Date createdFrom,
            Date createdTo,
            Boolean paid,
            Boolean shipped,
            List<String> includes,
            Integer limit
    ) {
        return call(offset -> shops.findAllShopReceipts(shopId, createdFrom, createdTo, paid, shipped, includes, limit, offset, null));
    }

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    public Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            Date minCreated,
            Date maxCreated,
            Integer limit
    ) {
        return call(offset -> shops.findLedgerEntries(shopId, minCreated, maxCreated, limit, offset, null));
    }

}
