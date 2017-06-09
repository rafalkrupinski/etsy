package com.hashnot.etsy.dto.dict;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.hashnot.etsy.dto.Pagination;

/**
 * @author Rafał Krupiński
 */
public class DictionaryResponse<T> {
    @JsonProperty
    private int count;

    @JsonProperty
    private T results;

    @JsonProperty
    private String type;

    @JsonProperty("pagination")
    private Pagination pagination;
	
	public T getResult() {
		return results;
	}
}
