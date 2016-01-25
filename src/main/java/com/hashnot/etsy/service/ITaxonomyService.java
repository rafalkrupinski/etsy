package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Category;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

/**
 * @author Rafał Krupiński
 */
public interface ITaxonomyService {
    Observable<Response<Category>> findAllTopCategory();

    Observable<Response<Category>> findAllTopCategoryChildren(String tag);

    Observable<Response<Category>> findAllSubCategoryChildren(
            String tag,
            String subtag
    );
}
