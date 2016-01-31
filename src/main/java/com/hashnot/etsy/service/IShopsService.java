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
            Integer limit, Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            ZonedDateTime minCreated,
            ZonedDateTime maxCreated,
            Integer limit,
            Collection<String> fields
    );

    Observable<Response<Listing>> findAllShopListingsFeatured(
            String shopId,
            Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<Payment>> findShopPaymentByReceipt(
            long receiptId,
            String shopId,
            Collection<String> fields
    );
}
