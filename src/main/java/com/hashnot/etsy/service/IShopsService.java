package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.*;
import rx.Observable;

import java.time.ZonedDateTime;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public interface IShopsService {
    Observable<Response<Listing>> findAllShopListings(String shopId, Collection<String> includes, Collection<String> fields);

    Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            ZonedDateTime createdFrom,
            ZonedDateTime createdTo,
            Boolean paid,
            Boolean shipped,
            Collection<String> includes,
            Integer limit
    );

    Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            ZonedDateTime minCreated,
            ZonedDateTime maxCreated,
            Integer limit
    );

    Observable<Response<Listing>> findAllShopListingsFeatured(
            String shopId,
            Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<Payment>> findShopPaymentByReceipt(
            long receiptId,
            String shopId
    );
}
