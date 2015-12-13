package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Response<T> {
    @JsonProperty
    private int count;

    @JsonProperty
    private List<T> results;

    @JsonProperty
    private String type;

    @JsonProperty("pagination")
    private Pagination pagination;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getResults() {
        return results;
    }

    public void setResults(List<T> results) {
        this.results = results;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Pagination getPagination() {
        return pagination;
    }
}
