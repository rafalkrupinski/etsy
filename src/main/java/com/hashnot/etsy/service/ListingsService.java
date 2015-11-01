package com.hashnot.etsy.service;

import com.hashnot.etsy.Listings;
import com.hashnot.etsy.dto.Image;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class ListingsService extends AbstractEtsyService {
    final private Listings listings;

    public ListingsService(Listings listings, String apiKey, Executor executor) {
        super(apiKey, executor);
        this.listings = listings;
    }

    public Observable<Response<Listing>> getListing(List<Long> listingIds, List<String> includes) {
        return call(offset -> listings.getListing(listingIds, includes, MAX_LIMIT, offset));
    }

    public Observable<Response<Listing>> findAllListingActive(String query, List<String> includes) {
        return call(offset -> listings.findAllListingActive(apiKey, query, includes, MAX_LIMIT, offset));
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
            Image image,
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
}
