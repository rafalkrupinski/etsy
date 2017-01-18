package com.hashnot.etsy.service;

import com.hashnot.etsy.Taxonomy;
import com.hashnot.etsy.dto.Category;
import com.hashnot.etsy.dto.Response;
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

/**
 * @author Rafał Krupiński
 */
public class TaxonomyService extends AbstractEtsyService implements ITaxonomyService {
    private Taxonomy taxonomy;

    public TaxonomyService(Taxonomy taxonomy, Executor2 executor) {
        super(executor);
        this.taxonomy = taxonomy;
    }

    /**
     * Retrieves all top-level Categories.
     */
    @Override
    public Observable<Response<Category>> findAllTopCategory() {
        return call(offset -> taxonomy.findAllTopCategory(null, offset));
    }

    /**
     * Retrieves children of a top-level Category by tag.
     */

    @Override
    public Observable<Response<Category>> findAllTopCategoryChildren(String tag) {
        return call(offset -> taxonomy.findAllTopCategoryChildren(tag, null, offset));
    }

    /**
     * Retrieves children of a second-level Category by tag and subtag.
     */
    @Override
    public Observable<Response<Category>> findAllSubCategoryChildren(
            String tag,
            String subtag
    ) {
        return call(offset -> taxonomy.findAllSubCategoryChildren(tag, subtag, null, offset));
    }
}
