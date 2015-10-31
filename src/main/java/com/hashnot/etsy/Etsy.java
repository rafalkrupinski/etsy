package com.hashnot.etsy;

/**
 * @author Rafał Krupiński
 */
public interface Etsy {
    String SELF = "__SELF__";
    String BASE_URL = "https://openapi.etsy.com/";

    /**
     * Read a member's email address
     */
    String EMAIL_R = "email_r";
    /**
     * Read a members's inactive and expired (i.e., non-public) listings.
     */
    String LISTINGS_R = "listings_r";
    /**
     * Create and edit a members's listings.
     */
    String LISTINGS_W = "listings_w";
    /**
     * Delete a members's listings.
     */
    String LISTINGS_D = "listings_d";
    /**
     * Read a member's purchase and sales data. This applies to buyers as well as sellers.
     */
    String TRANSACTIONS_R = "transactions_r";
    /**
     * Update a member's sales data.
     */
    String TRANSACTIONS_W = "transactions_w";
    /**
     * Read a member's Etsy bill charges and payments.
     */
    String BILLING_R = "billing_r";
    /**
     * Read a member's private profile information.
     */
    String PROFILE_R = "profile_r";
    /**
     * Update a member's private profile information.
     */
    String PROFILE_W = "profile_w";
    /**
     * Read a member's shipping addresses.
     */
    String ADDRESS_R = "address_r";
    /**
     * Update and delete a member's shipping address.
     */
    String ADDRESS_W = "address_w";
    /**
     * Add to and remove from a member's favorite listings and users.
     */
    String FAVORITES_RW = "favorites_rw";
    /**
     * Update a member's shop description, messages and sections.
     */
    String SHOPS_RW = "shops_rw";
    /**
     * Add and remove listings from a member's shopping cart.
     */
    String CART_RW = "cart_rw";
    /**
     * View, accept and reject a member's recommended listings.
     */
    String RECOMMEND_RW = "recommend_rw";
    /**
     * View all details of a member's feedback (including purchase history.)
     */
    String FEEDBACK_R = "feedback_r";
    /**
     * Read a member's treasuries and treasury comments.
     */
    String TREASURY_R = "treasury_r";
    /**
     * Create and delete treasuries and treasury comments.
     */
    String TREASURY_W = "treasury_w";

}
