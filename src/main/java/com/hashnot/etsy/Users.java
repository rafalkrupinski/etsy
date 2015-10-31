package com.hashnot.etsy;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.ShippingTemplate;
import com.hashnot.etsy.dto.Shop;
import com.hashnot.etsy.dto.User;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;
import java.util.List;

/**
 * @author Rafał Krupiński
 */
@Path("v2")
public interface Users {
    @GET
    @Path("/users/{userId}/shops")
    Response<Shop> findAllUserShops(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String user
    ) throws IOException;

    @GET
    @Path("/users/{userId}")
    Response<User> getUser(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String user,
            @QueryParam("includes") List<String> includes
    ) throws IOException;

    @GET
    @Path("/users/{userId}/shipping/templates")
    Response<ShippingTemplate> findAllUserShippingProfiles(@PathParam("userId") String userId) throws IOException;

    @GET
    @Path("/users/{userId}/shops")
    Response<Shop> findAllUserShops(
            @QueryParam("api_key") String apiKey,
            @PathParam("userId") String userId,
            @QueryParam("includes") List<String> includes)
            throws IOException;
}
