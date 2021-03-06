package com.hashnot.etsy;

import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;

public class Example {
	private static final Logger LOGGER = Logger.getLogger(Example.class.getName());
	private static final String API_KEY = "Replace with your etsy api key";
	public static void main(String[] args) throws IOException {
    	
    	Listings listings = RestProxyFactory.createProxy(Listings.class, Etsy.BASE_URL);
        Response<Listing> response = listings.getListing(Collections.singleton(263361609L), 1, 0, null, null, API_KEY);
        
        List<Listing> rlistings = response.getResults();
        for(Listing listing : rlistings)
        {
        	LOGGER.info(listing.toString());
        }
    }
}
