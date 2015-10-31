package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class ShippingTemplate {
    @JsonProperty("shipping_template_id")
    private long shippingTemplateId;

    public long getShippingTemplateId() {
        return shippingTemplateId;
    }

    public void setShippingTemplateId(long shippingTemplateId) {
        this.shippingTemplateId = shippingTemplateId;
    }
}
