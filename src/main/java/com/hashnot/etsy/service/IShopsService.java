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
    Observable<Response<Listing>> findAllShopListings(
            long shopId,
            Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<Receipt>> findAllShopReceipts(
            long shopId,
            Instant createdFrom,
            Instant createdTo,
            Boolean paid,
            Boolean shipped,
            Integer limit, Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<LedgerEntry>> findLedgerEntries(
            long shopId,
            Instant minCreated,
            Instant maxCreated,
            Integer limit,
            Collection<String> fields
    );

    Observable<Response<Listing>> findAllShopListingsFeatured(
            long shopId,
            Collection<String> includes,
            Collection<String> fields
    );

    Observable<Response<Payment>> findShopPaymentByReceipt(
            long shopId,
            long receiptId,
            Collection<String> fields
    );
}
