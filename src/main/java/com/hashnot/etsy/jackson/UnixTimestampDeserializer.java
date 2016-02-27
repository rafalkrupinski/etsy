package com.hashnot.etsy.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.Instant;

/**
 * @author Rafał Krupiński
 */
public class UnixTimestampDeserializer extends JsonDeserializer<Instant> {

    @Override
    public Instant deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        return Instant.ofEpochSecond(jp.getValueAsLong());
    }
}

