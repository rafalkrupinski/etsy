package com.hashnot.etsy.service;

import com.hashnot.etsy.Listings;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.ListingImage;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;
import rx.Observable;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

/**
 * @author Rafał Krupiński
 */
public class ListingsService extends AbstractEtsyService {
    final private Listings listings;

    public ListingsService(Listings listings, Executor executor) {
        super(executor);
        this.listings = listings;
    }

    public Observable<Response<Listing>> getListing(Iterable<Long> listingIds, List<String> includes) {
        return call(offset -> listings.getListing(listingIds, includes, null, offset));
    }

    public Observable<Response<Listing>> findAllListingActive(String query, List<String> includes) {
        return call(offset -> listings.findAllListingActive(null, query, includes, null, offset));
    }

    public Observable<Response<Listing>> createListing(
            int quantity,
            String title,
            String description,
            BigDecimal price,
            List<String> materials,
            long shippingTemplateId,
            Long shopSectionId,
            List<Long> imageIds,
            Boolean isCustomizable,
            Boolean nonTaxable,
            ListingImage image,
            String state,
            Integer processingMin,
            Integer processingMax,
            Long categoryId,
            Long taxonomyId,
            List<String> tags,
            String whoMade,
            boolean isSupply,
            String whenMade,
            String recipient,
            String occasion,
            List<String> style
    ) {
        return call(offset -> listings.createListing(quantity, title, description, price, materials, shippingTemplateId, shopSectionId, imageIds, isCustomizable, nonTaxable, image, state, processingMin, processingMax, categoryId, taxonomyId, tags, whoMade, isSupply, whenMade, recipient, occasion, style));
    }

    public Observable<Response<Listing>> createListing(Listing l, List<Long> imageIds) {
        return createListing(
                l.getQuantity(),
                l.getTitle(),
                l.getDescription(),
                l.getPrice(),
                l.getMaterials(),
                l.getShippingTemplateId(),
                l.getShopSectionId(),
                imageIds,
                l.isCustomizable(),
                l.isNonTaxable(),
                l.getMainImage(),
                l.getState(),
                l.getProcessingMin(),
                l.getProcessingMax(),
                l.getCategoryId(),
                l.getTaxonomyId(),
                l.getTags(),
                l.getWhoMade(),
                l.isSupply(),
                l.getWhenMade(),
                l.getRecipient(),
                l.getOccasion(),
                l.getStyle()
        );
    }

    public Observable<Response<Listing>> updateListing(
            long listingId,
            Integer quantity,
            String title,
            String description,
            BigDecimal price,
            BigDecimal wholesalePrice,
            List<String> materials,
            Boolean renew,
            Long shippingTemplateId,
            Long shopSectionId,
            String state,
            List<Long> imageIds,
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
            List<String> tags,
            String whoMade,
            Boolean isSupply,
            String whenMade,
            String recipient,
            String occasion,
            List<String> style,
            Integer processingMin,
            Integer processingMax,
            Integer featuredRank
    ) {
        return call(offset -> listings.updateListing(listingId, quantity, title, description, price, wholesalePrice, materials, renew, shippingTemplateId, shopSectionId, state, imageIds, customizable, weight, length, width, height, weightUnit, dimensionsUnit, nonTaxable, categoryId, taxonomyId, tags, whoMade, isSupply, whenMade, recipient, occasion, style, processingMin, processingMax, featuredRank));
    }

    public Observable<Response<Listing>> updateListing(Listing l, BigDecimal wholesalePrice, Boolean renew) {
        return updateListing(
                l.getListingId(),
                l.getQuantity(),
                l.getTitle(),
                l.getDescription(),
                l.getPrice(),
                wholesalePrice,
                l.getMaterials(),
                renew,
                l.getShippingTemplateId(),
                l.getShopSectionId(),
                l.getState(),
                ns(l.getImages(), i -> i.stream().map(ListingImage::getListingImageId).collect(Collectors.toList())),
                l.isCustomizable(),
                l.getWeight(),
                l.getItemLength(),
                l.getItemWidth(),
                l.getItemHeight(),
                l.getWeightUnits(),
                l.getItemDimensionsUnit(),
                l.isNonTaxable(),
                l.getCategoryId(),
                l.getTaxonomyId(),
                l.getTags(),
                l.getWhoMade(),
                l.isSupply(),
                l.getWhenMade(),
                l.getRecipient(),
                l.getOccasion(),
                l.getStyle(),
                l.getProcessingMin(),
                l.getProcessingMax(),
                l.getFeaturedRank()
        );
    }

    /**
     * Retrieves a set of Transaction objects associated to a Listing.
     */
    public Observable<Response<Transaction>> findAllListingTransactions(
            long listingId,
            List<String> includes
    ) {
        return call(offset -> listings.findAllListingTransactions(listingId, includes, null, offset));
    }
}
