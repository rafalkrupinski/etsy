package com.hashnot.etsy;

import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Collections;

public class Example {
    public static void main(String[] args) throws IOException {
        Listings listings = RestProxyFactory.createProxy(Listings.class, "https://openapi.etsy.com/v2/");
        listings.getListing(Collections.singleton(1L), 1, 0, null, null, "API_KEY");
    }
}
