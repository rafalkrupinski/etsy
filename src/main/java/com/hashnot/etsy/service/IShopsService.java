package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.*;
import com.hashnot.etsy.dto.fin.LedgerEntry;
import com.hashnot.etsy.dto.fin.Payment;
import rx.Observable;

import java.time.Instant;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public interface IShopsService {
    Observable<Response<Listing>> findAllShopListings(String shopId, Collection<String> includes, Collection<String> fields);

    Observable<Response<Receipt>> findAllShopReceipts(
            String shopId,
            Instant createdFrom,
            Instant createdTo,
            Boolean paid,
            Boolean shipped,
            Integer limit, Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<LedgerEntry>> findLedgerEntries(
            String shopId,
            Instant minCreated,
            Instant maxCreated,
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
