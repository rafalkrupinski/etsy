package com.hashnot.etsy.service;

import com.hashnot.etsy.Taxonomy;
import com.hashnot.etsy.dto.Category;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.util.concurrent.Executor;

/**
 * @author Rafał Krupiński
 */
public class TaxonomyService extends AbstractEtsyService {
    private Taxonomy taxonomy;

    public TaxonomyService(Taxonomy taxonomy, String apiKey, Executor executor) {
        super(apiKey, executor);
        this.taxonomy = taxonomy;
    }

    /**
     * Retrieves all top-level Categories.
     */
    public Observable<Response<Category>> findAllTopCategory() {
        return call(offset -> taxonomy.findAllTopCategory(null, offset));
    }

    /**
     * Retrieves children of a top-level Category by tag.
     */

    public Observable<Response<Category>> findAllTopCategoryChildren(String tag) {
        return call(offset -> taxonomy.findAllTopCategoryChildren(tag, null, offset));
    }

    /**
     * Retrieves children of a second-level Category by tag and subtag.
     */
    public Observable<Response<Category>> findAllSubCategoryChildren(
            String tag,
            String subtag
    ) {
        return call(offset -> taxonomy.findAllSubCategoryChildren(tag, subtag, null, offset));
    }
}
