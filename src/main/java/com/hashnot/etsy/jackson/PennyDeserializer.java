package com.hashnot.etsy.jackson;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.math.BigDecimal;

/**
 * Deserialize number and multiply by 100. Intended for money amounts represented in pennies.
 *
 * @author Rafał Krupiński
 */
public class PennyDeserializer extends JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        String str = p.getValueAsString();
        return str == null ? null : new BigDecimal(str).movePointLeft(2);
    }
}
