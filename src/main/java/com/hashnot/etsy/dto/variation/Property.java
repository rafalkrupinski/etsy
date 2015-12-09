package com.hashnot.etsy.dto.variation;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class Property {
    @JsonProperty("property_id")
    private long propertyId;

    @JsonProperty("formatted_name")
    private String name;

    @JsonProperty
    private List<Option> options;

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
}
