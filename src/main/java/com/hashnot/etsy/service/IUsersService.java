package com.hashnot.etsy.service;

import com.hashnot.etsy.Users;
import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.ShippingTemplate;
import com.hashnot.etsy.dto.Shop;
import com.hashnot.etsy.dto.User;
import com.hashnot.etsy.dto.dict.ChargesMetadata;
import com.hashnot.etsy.dto.dict.DictionaryResponse;
import com.hashnot.etsy.dto.fin.BillCharge;
import com.hashnot.etsy.dto.fin.BillPayment;
import com.hashnot.etsy.dto.fin.BillingOverview;
import rx.Observable;

import java.time.Instant;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public interface IUsersService {
    /**
     * @see Users#getUser(String, String, Iterable)
     */
    Observable<Response<User>> getUser(
            String userId,
            Iterable<String> includes
    );

    /**
     * @see Users#findAllUserShippingProfiles(String)
     */
    Observable<Response<ShippingTemplate>> findAllUserShippingProfiles(
            String userId
    );

    /**
     * @see Users#findAllUserShops(String, String, Iterable, Iterable)
     */
    Observable<Response<Shop>> findAllUserShops(
            String userId,
            Iterable<String> fields,
            Iterable<String> includes
    );

    /**
     * @see Users#getUserBillingOverview(String, Integer, Integer, Integer, Collection)
     */
    Observable<Response<BillingOverview>> getUserBillingOverview(
            String userId,
            Collection<String> fields
    );

    /**
     * @see Users#getUserChargesMetadata(String, Integer, Integer, Integer, Collection)
     */
    Observable<DictionaryResponse<ChargesMetadata>> getUserChargesMetadata(
            String userId,

            Collection<String> fields
    );

    /**
     * @see Users#findAllUserCharges(String, Users.SortOrder, long, long, Integer, Integer, Integer, Collection)
     */
    Observable<Response<BillCharge>> findAllUserCharges(
            String userId,
            Users.SortOrder sortOrder,
            Instant from,
            Instant to,

            Collection<String> fields
    );

    /**
     * @see Users#findAllUserPayments(String, Users.SortOrder, long, long, Integer, Integer, Integer, Collection)
     */
    Observable<Response<BillPayment>> findAllUserPayments(
            String userId,
            Users.SortOrder sortOrder,
            Instant from,
            Instant to,

            Collection<String> fields
    );
}
