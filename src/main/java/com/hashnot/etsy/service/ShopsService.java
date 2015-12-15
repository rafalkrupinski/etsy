package com.hashnot.etsy.service;

import com.hashnot.etsy.Shops;
import com.hashnot.etsy.dto.LedgerEntry;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ShopsService extends AbstractEtsyService {
    private Shops shops;

    public ShopsService(Executor executor, Shops shops) {
        super(executor);
        this.shops = shops;
    }

    public Observable<Response<Listing>> findAllShopListings(String shopId) {
        Observable<Response<Listing>> active = call(offset -> shops.findAllShopListings(shopId, "active", null, offset, null, null, null));
        Observable<Response<Listing>> expired = call(offset -> shops.findAllShopListings(shopId, "expired", null, offset, null, null, null));
        Observable<Response<Listing>> inactive = call(offset -> shops.findAllShopListings(shopId, "inactive", null, offset, null, null, null));
        return Observable.concat(active, expired, inactive);
    }

    public Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            ZonedDateTime createdFrom,
            ZonedDateTime createdTo,
            Boolean paid,
            Boolean shipped,
            List<String> includes,
            Integer limit
    ) {
        return call(offset -> shops.findAllShopReceipts(shopId, toTimeStamp(createdFrom), toTimeStamp(createdTo), paid, shipped, includes, limit, offset, null));
    }

    /**
     * Get a Shop Payment Account Ledger's Entries
     */
    public Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            ZonedDateTime minCreated,
            ZonedDateTime maxCreated,
            Integer limit
    ) {
        return call(offset -> shops.findLedgerEntries(shopId, toTimeStamp(minCreated), toTimeStamp(maxCreated), limit, offset, null));
    }

}
