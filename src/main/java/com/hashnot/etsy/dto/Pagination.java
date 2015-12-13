package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class Pagination {
    @JsonProperty("effective_limit")
    private int effectiveLimit;

    @JsonProperty("effective_offset")
    private int effectiveOffset;

    @JsonProperty("next_offset")
    private Integer nextOffset;

    @JsonProperty("effective_page")
    private int effectivePage;

    @JsonProperty("next_page")
    private Integer nextPage;

    public int getEffectiveLimit() {
        return effectiveLimit;
    }

    public int getEffectiveOffset() {
        return effectiveOffset;
    }

    public Integer getNextOffset() {
        return nextOffset;
    }

    public int getEffectivePage() {
        return effectivePage;
    }

    public Integer getNextPage() {
        return nextPage;
    }
}
