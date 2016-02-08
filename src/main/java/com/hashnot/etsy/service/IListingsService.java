package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.ListingImage;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import rx.Observable;

import java.math.BigDecimal;

/**
 * @author Rafał Krupiński
 */
public interface IListingsService {
    Observable<Response<Listing>> getListing(Iterable<Long> listingIds, Iterable<String> includes, Iterable<String> fields);

    Observable<Response<Listing>> findAllListingActive(String query, Iterable<String> includes, Iterable<String> fields);

    Observable<Response<Listing>> createListing(
            int quantity,
            String title,
            String description,
            BigDecimal price,
            Iterable<String> materials,
            long shippingTemplateId,
            Long shopSectionId,
            Iterable<Long> imageIds,
            Boolean isCustomizable,
            Boolean nonTaxable,
            ListingImage image,
            String state,
            Integer processingMin,
            Integer processingMax,
            Long categoryId,
            Long taxonomyId,
            Iterable<String> tags,
            String whoMade,
            boolean isSupply,
            String whenMade,
            String recipient,
            String occasion,
            Iterable<String> style
    );

    Observable<Response<Listing>> createListing(Listing l, Iterable<Long> imageIds);

    Observable<Response<Listing>> updateListing(
            long listingId,
            Integer quantity,
            String title,
            String description,
            BigDecimal price,
            BigDecimal wholesalePrice,
            Iterable<String> materials,
            Boolean renew,
            Long shippingTemplateId,
            Long shopSectionId,
            String state,
            Iterable<Long> imageIds,
            Boolean customizable,
            BigDecimal weight,
            BigDecimal length,
            BigDecimal width,
            BigDecimal height,
            String weightUnit,
            String dimensionsUnit,
            Boolean nonTaxable,
            Long categoryId,
            Long taxonomyId,
            Iterable<String> tags,
            String whoMade,
            Boolean isSupply,
            String whenMade,
            String recipient,
            String occasion,
            Iterable<String> style,
            Integer processingMin,
            Integer processingMax,
            Integer featuredRank
    );

    Observable<Response<Listing>> updateListing(Listing l, BigDecimal wholesalePrice, Boolean renew);

    Observable<Response<Transaction>> findAllListingTransactions(
            long listingId,

            Iterable<String> includes,
            Iterable<String> fields
    );
}
