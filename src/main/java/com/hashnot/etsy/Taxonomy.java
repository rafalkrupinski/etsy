package com.hashnot.etsy;

import com.hashnot.etsy.dto.Category;
import com.hashnot.etsy.dto.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import java.io.IOException;

/**
 * @author Rafał Krupiński
 */
@Path("/v2")
public interface Taxonomy {
    /**
     * Retrieves all top-level Categories.
     */
    @GET
    @Path("/taxonomy/categories")
    Response<Category> findAllTopCategory(
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;

    /**
     * Retrieves children of a top-level Category by tag.
     */
    @GET
    @Path("/taxonomy/categories/{tag}")
    Response<Category> findAllTopCategoryChildren(
            @PathParam("tag") String tag,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;

    /**
     * Retrieves children of a second-level Category by tag and subtag.
     */
    @GET
    @Path("/taxonomy/categories/{tag}/{subtag}")
    Response<Category> findAllSubCategoryChildren(
            @PathParam("tag") String tag,
            @PathParam("subtag") String subtag,
            @QueryParam("limit") Integer limit,
            @QueryParam("offset") Integer offset
    ) throws IOException;
}
