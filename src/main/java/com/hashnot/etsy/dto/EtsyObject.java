package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class EtsyObject {
    @JsonProperty("error_messages")
    private String[] errorMessages;

    public String[] getErrorMessages() {
        return errorMessages;
    }
}
