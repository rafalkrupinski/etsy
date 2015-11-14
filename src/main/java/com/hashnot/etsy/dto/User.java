package com.hashnot.etsy.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author Rafał Krupiński
 */
public class User {
    @JsonProperty("user_id")
    private long userId;

    @JsonProperty("login_name")
    private String loginName;

    @JsonProperty("primary_email")
    private String email;
    /*
        @JsonProperty("creation_tsz")
        private Date creationTime;
    */
/*
    @JsonProperty("user_pub_key")
    private String userPubKey;
*/
    @JsonProperty("referred_by_user_id")
    private Long referredByUserId;

    @JsonProperty("Shops")
    private List<Shop>shops;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getReferredByUserId() {
        return referredByUserId;
    }

    public void setReferredByUserId(Long referredByUserId) {
        this.referredByUserId = referredByUserId;
    }

    public List<Shop> getShops() {
        return shops;
    }

    public void setShops(List<Shop> shops) {
        this.shops = shops;
    }
}
