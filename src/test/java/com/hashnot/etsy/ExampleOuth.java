package com.hashnot.etsy;

import si.mazi.rescu.ClientConfig;
import si.mazi.rescu.RestProxyFactory;

import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

import com.hashnot.etsy.dto.Listing;
import com.hashnot.etsy.dto.Response;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

public class ExampleOuth {
	private static final Logger LOGGER = Logger.getLogger(ExampleOuth.class.getName());
	private static final String API_KEY = "Replace with your etsy api key";
	private static final String SECRET_KEY = "My Oauth Secret Key";
	public static void main(String[] args) throws IOException {
    	
    	ClientConfig config = new ClientConfig();
    	
    	
    	OAuthConsumer oAuthConsumer = new DefaultOAuthConsumer(API_KEY,
    			SECRET_KEY);
		config.setOAuthConsumer(oAuthConsumer );
        Listings listings = RestProxyFactory.createProxy(Listings.class, Etsy.BASE_URL, config);
        Response<Listing> response = listings.getListing(Collections.singleton(263361609L), 1, 0, null, null, API_KEY);
        
        List<Listing> rlistings = response.getResults();
        for(Listing listing : rlistings)
        {
        	LOGGER.info(listing.toString());
        }
        
        
    }
}
