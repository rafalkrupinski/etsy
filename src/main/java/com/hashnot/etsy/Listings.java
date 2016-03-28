package com.hashnot.etsy;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.ListingImage;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Transaction;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * @author Rafał Krupiński
 */
@Path("v2/listings")
public interface Listings {

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response<Listing> createListing(
            @FormParam("quantity") int quantity,
            @FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("price") BigDecimal price,
            @FormParam("materials") Iterable<String> materials,
            @FormParam("shipping_template_id") long shippingTemplateId,
            @FormParam("shop_section_id") Long shopSectionId,
            @FormParam("image_ids") Iterable<Long> imageIds,
            @FormParam("is_customizable") Boolean isCustomizable,
            @FormParam("non_taxable") Boolean nonTaxable,
            @FormParam("image") ListingImage image,
            @FormParam("state") Listing.Status state,
            @FormParam("processing_min") Integer processingMin,
            @FormParam("processing_max") Integer processingMax,
            @FormParam("category_id") Long categoryId,
            @FormParam("taxonomy_id") Long taxonomyId,
            @FormParam("tags") Iterable<String> tags,
            @FormParam("who_made") String whoMade,
            @FormParam("is_supply") boolean isSupply,
            @FormParam("when_made") String whenMade,
            @FormParam("recipient") String recipient,
            @FormParam("occasion") String occasion,
            @FormParam("style") Iterable<String> style
    ) throws IOException;

    @GET
    @Path("active.json")
    Response<Listing> findAllListingActive(
            @QueryParam("api_key") String apiKey,
            @QueryParam("keywords") String keywords,

            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,

            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields
    ) throws IOException;

    @GET
    @Path("{listingId}.json")
    Response<Listing> getListing(
            @PathParam("listingId") Iterable<Long> listingId,
            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;

    @PUT
    @Path("{listingId}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response<Listing> updateListing(
            @PathParam("listingId") long listingId,
            @QueryParam("quantity") Integer quantity,
            @QueryParam("title") String title,
            @QueryParam("description") String description,
            @QueryParam("price") BigDecimal price,
            @QueryParam("wholesale_price") BigDecimal wholesalePrice,
            @QueryParam("materials") Iterable<String> materials,
            @QueryParam("renew") Boolean renew,
            @QueryParam("shipping_template_id") Long shippingTemplateId,
            @QueryParam("shop_section_id") Long shopSectionId,
            @QueryParam("state") Listing.Status state,
            @QueryParam("image_ids") Iterable<Long> imageIds,
            @QueryParam("is_customizable") Boolean customizable,
            @QueryParam("item_weight") BigDecimal weight,
            @QueryParam("item_length") BigDecimal length,
            @QueryParam("item_width") BigDecimal width,
            @QueryParam("item_height") BigDecimal height,
            @QueryParam("item_weight_unit") String weight_unit,
            @QueryParam("item_dimensions_unit") String dimensions_unit,
            @QueryParam("non_taxable") Boolean nonTaxable,
            @QueryParam("category_id") Long categoryId,
            @QueryParam("taxonomy_id") Long taxonomyId,
            @QueryParam("tags") Iterable<String> tags,
            @QueryParam("who_made") String whoMade,
            @QueryParam("is_supply") Boolean isSupply,
            @QueryParam("when_made") String when_made,
            @QueryParam("recipient") String recipient,
            @QueryParam("occasion") String occasion,
            @QueryParam("style") Iterable<String> style,
            @QueryParam("processing_min") Integer processingMin,
            @QueryParam("processing_max") Integer processingMax,
            @QueryParam("featured_rank") Integer featuredRank
    ) throws IOException;

    /**
     * Upload a new listing image, or re-associate a previously deleted one. You may associate an image to any listing
     * within the same shop that the image's original listing belongs to. You MUST pass either a listing_image_id
     * OR an image to this method. Passing a listing_image_id serves to re-associate an image that was previously
     * deleted.
     * If you wish to re-associate an image, we strongly recommend using the listing_image_id argument as opposed
     * to re-uploading a new image each time, to save bandwidth for you as well as us. Pass overwrite=1 to replace
     * the existing image at a given rank. When uploading a new listing image with a watermark, pass is_watermarked=1;
     * existing listing images will not be affected by this parameter.
     */
/*
    @Path("listings/{listingId}/images")
    @POST
    Response<ListingImage> uploadListingImage(
            @PathParam("listingId") long listingId,
            @FormParam("listing_image_id") Long listingImageId,
            @Consumes("image/jpeg,image/gif,image/png")
            @FormParam("image") byte[] image,
            @FormParam("rank") Integer rank,
            @FormParam("overwrite") Boolean overwrite,
            @FormParam("is_watermarked") Boolean watermarked
    ) throws IOException;
*/

    /**
     * Retrieves a set of Transaction objects associated to a Listing.
     */
    @GET
    @Path("/{listing_id}/transactions")
    Response<Transaction> findAllListingTransactions(
            @PathParam("listing_id") long listingId,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset,

            @QueryParam("includes") Iterable<String> includes,
            @QueryParam("fields") Iterable<String> fields
    ) throws IOException;

}
