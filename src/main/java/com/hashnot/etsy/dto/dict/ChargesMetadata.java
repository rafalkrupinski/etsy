package com.hashnot.etsy.dto.dict;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.hashnot.etsy.jackson.UnixTimestampDeserializer;

import java.time.Instant;

/**
 * @author Rafał Krupiński
 */
public class ChargesMetadata {
    private Long count;

    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant minCreateDate;

    @JsonDeserialize(using = UnixTimestampDeserializer.class)
    private Instant maxCreateDate;

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Instant getMinCreateDate() {
        return minCreateDate;
    }

    public void setMinCreateDate(Instant minCreateDate) {
        this.minCreateDate = minCreateDate;
    }

    public Instant getMaxCreateDate() {
        return maxCreateDate;
    }

    public void setMaxCreateDate(Instant maxCreateDate) {
        this.maxCreateDate = maxCreateDate;
    }
}
