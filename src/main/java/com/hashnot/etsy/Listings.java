package com.hashnot.etsy;


import com.hashnot.etsy.dto.Image;
import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface Listings {

    @POST
    @Path("listings")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response<Listing> createListing(
            @FormParam("quantity") int quantity,
            @FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("price") BigDecimal price,
            @FormParam("shipping_template_id") long shippingTemplateId,
            @FormParam("state") String state,
            @FormParam("who_made") String whoMade,
            @FormParam("is_supply") boolean isSupply,
            @FormParam("when_made") String whenMade
    ) throws IOException;

    @POST
    @Path("listings")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    Response<Listing> createListing(
            @FormParam("quantity") int quantity,
            @FormParam("title") String title,
            @FormParam("description") String description,
            @FormParam("price") BigDecimal price,
            @FormParam("materials") List<String> materials,
            @FormParam("shipping_template_id") long shippingTemplateId,
            @FormParam("shop_section_id") Long shopSectionId,
            @FormParam("image_ids") List<Long> imageIds,
            @FormParam("is_customizable") Boolean isCustomizable,
            @FormParam("non_taxable") Boolean nonTaxable,
            @FormParam("image") Image image,
            @FormParam("state") String state,
            @FormParam("processing_min") Integer processingMin,
            @FormParam("processing_max") Integer processingMax,
            @FormParam("category_id") Long categoryId,
            @FormParam("taxonomy_id") Long taxonomyId,
            @FormParam("tags") List<String> tags,
            @FormParam("who_made") String whoMade,
            @FormParam("is_supply") boolean isSupply,
            @FormParam("when_made") String whenMade,
            @FormParam("recipient") String recipient,
            @FormParam("occasion") String occasion,
            @FormParam("style") List<String> style
    ) throws IOException;

    @GET
    @Path("listings/active.json")
    Response<Listing> findAllListingActive(
            @QueryParam("api_key") String apiKey,
            @QueryParam("keywords") String keywords,
            @QueryParam("includes") List<String> includes,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;

    @GET
    @Path("listings/{listingId}.json")
    Response<Listing> getListing(
            @PathParam("listingId") List<Long> listingId,
            @QueryParam("includes") List<String> includes,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;

    @GET
    @Path("listings/{listingId}.json")
    Response<Listing> updateLisitng(
            @PathParam("listingId") long listingId,
/*
@QueryParam("quantity")            int	quantity,
@QueryParam("title")                    String	title,
@QueryParam("description")                    String	description,
@QueryParam("price")                    BigDecimal	price,
@QueryParam                    ("wholesale_price")BigDecimal	wholesalePrice,
@QueryParam("materials")                    List<String>	materials,
*/
            @QueryParam("renew") Boolean renew,
/*
    int	shipping_template_id
    int	shop_section_id
*/
            @QueryParam("state")    /*enum(active, inactive, draft)*/ String state
/*
                                     array(int)	image_ids
    boolean	is_customizable
    float	item_weight
    float	item_length
    float	item_width
    float	item_height
    string	item_weight_unit
    string	item_dimensions_unit
    boolean	non_taxable
    int	category_id
    int	taxonomy_id
    array(string)	tags
    enum(i_did, collective, someone_else)	who_made
    boolean	is_supply
    enum(made_to_order, 2010_2015, 2000_2009, 1996_1999, before_1996, 1990_1995, 1980s, 1970s, 1960s, 1950s, 1940s, 1930s, 1920s, 1910s, 1900s, 1800s, 1700s, before_1700)	when_made
    enum(men, women, unisex_adults, teen_boys, teen_girls, teens, boys, girls, children, baby_boys, baby_girls, babies, birds, cats, dogs, pets, not_specified)	recipient
    enum(anniversary, baptism, bar_or_bat_mitzvah, birthday, canada_day, chinese_new_year, cinco_de_mayo, confirmation, christmas, day_of_the_dead, easter, eid, engagement, fathers_day, get_well, graduation, halloween, hanukkah, housewarming, kwanzaa, prom, july_4th, mothers_day, new_baby, new_years, quinceanera, retirement, st_patricks_day, sweet_16, sympathy, thanksgiving, valentines, wedding)	occasion
                                                                                                                                                                                                                                                                                                                                                                                                                  array(string)	style
    int	processing_min
    int	processing_max
    featured_rank	featured_rank
*/

    ) throws IOException;

}
