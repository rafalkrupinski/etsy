package com.hashnot.etsy.dto.variation;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class SelectedProperty {
    /**
     * The numeric ID of the selected property
     */
    @JsonProperty("property_id")
    private long propertyId;
    /**
     * The numeric ID of selected value
     */
    @JsonProperty("value_id")
    private long valueId;
    /**
     * The formatted/translated name of the selected property
     */
    @JsonProperty("formatted_name")
    private String formattedName;
    /**
     * The formatted/translated name of the selected value
     */
    @JsonProperty("formatted_value")
    private String formattedValue;
    /**
     * Whether the selected variation value is a valid option for this property. NOTE: This field will not be present on Transactions.
     */
    @JsonProperty("is_valid")
    private Boolean isValid;

    public long getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(long propertyId) {
        this.propertyId = propertyId;
    }

    public long getValueId() {
        return valueId;
    }

    public void setValueId(long valueId) {
        this.valueId = valueId;
    }

    public String getFormattedName() {
        return formattedName;
    }

    public void setFormattedName(String formattedName) {
        this.formattedName = formattedName;
    }

    public String getFormattedValue() {
        return formattedValue;
    }

    public void setFormattedValue(String formattedValue) {
        this.formattedValue = formattedValue;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }
}
