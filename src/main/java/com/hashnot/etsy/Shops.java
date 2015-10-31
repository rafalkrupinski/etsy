package com.hashnot.etsy;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.Shop;
import com.hashnot.etsy.dto.ShopSection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface Shops {

    @GET
    @Path("/shops")
    Response<Shop> findAllShops(
            @QueryParam("api_key") String apiKey,
            @QueryParam("shop_name") String shopName
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/receipts")
    Response<Shop> findAllShopReceipts(
            @QueryParam("api_key") String apiKey,
            @PathParam("shopId") long user
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/sections")
    Response<ShopSection> findAllShopSections(
            @PathParam("shopId") String shopId
    ) throws IOException;

    @GET
    @Path("/shops/{shopId}/listings/{status}")
    Response<Listing>findAllShopListings(
            @PathParam("shopId")String shopId,
            @PathParam("status")String status,
            @QueryParam("limit")Integer limit,
            @QueryParam("offset")Integer offset,
            @QueryParam("page")Integer page
    );
}
