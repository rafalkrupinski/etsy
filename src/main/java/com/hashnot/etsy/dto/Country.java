package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author Rafał Krupiński
 */
public class Country {
    /**
     * The country's numeric ID.
     */
    @JsonProperty("country_id")
    private long countryId;

    /**
     * The two-letter country code according to ISO 3166-1-alpha-2.
     */
    @JsonProperty("iso_country_code")
    private String isoCountryCode;

    /**
     * The three-letter country code according to the World Bank.
     */
    @JsonProperty("world_bank_country_code")
    private String worldBankCountryCode;

    /**
     * The country's plain-English name.
     */
    @JsonProperty("name")
    private String name;

    /**
     * The country's plain-English name slugified; suitable for interpolation into a url.
     */
    @JsonProperty("slug")
    private String slug;

    /**
     * The country's latitude.
     */
    @JsonProperty("lat")
    private float lat;

    /**
     * The country's longitude.
     */
    @JsonProperty("lon")
    private float lon;

    public long getCountryId() {
        return countryId;
    }

    public String getIsoCountryCode() {
        return isoCountryCode;
    }

    public String getWorldBankCountryCode() {
        return worldBankCountryCode;
    }

    public String getName() {
        return name;
    }

    public String getSlug() {
        return slug;
    }

    public float getLat() {
        return lat;
    }

    public float getLon() {
        return lon;
    }
}
