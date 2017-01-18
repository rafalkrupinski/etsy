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
import com.hashnot.u.async.executor.Executor2;
import rx.Observable;

import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public class UsersService extends AbstractEtsyService implements IUsersService {

    private Users users;

    public UsersService(Users users, Executor2 executor) {
        super(executor);
        this.users = users;
    }

    @Override
    public Observable<Response<User>> getUser(String user, Iterable<String> includes) {
        return call(p -> users.getUser(user, null, includes));
    }

    @Override
    public Observable<Response<ShippingTemplate>> findAllUserShippingProfiles(long userId) {
        return call(p -> users.findAllUserShippingProfiles(userId));
    }

    @Override
    public Observable<Response<Shop>> findAllUserShops(long userId, Iterable<String> fields, Iterable<String> includes) {
        return call(p -> users.findAllUserShops(userId, fields, includes));
    }

    @Override
    public Observable<Response<BillingOverview>> getUserBillingOverview(long userId, Collection<String> fields) {
        return call(offset -> users.getUserBillingOverview(userId, null, offset, null, fields));
    }

    @Override
    public Observable<DictionaryResponse<ChargesMetadata>> getUserChargesMetadata(long userId, Collection<String> fields) {
        return callDict(offset -> users.getUserChargesMetadata(userId, null, offset, null, fields));
    }

    @Override
    public Observable<Response<BillCharge>> findAllUserCharges(long userId, Users.SortOrder sortOrder, Instant _from, Instant _to, Collection<String> fields) {
        Instant from = _from.truncatedTo(ChronoUnit.SECONDS);
        Instant to = _to.truncatedTo(ChronoUnit.SECONDS);

        Observable<Response<BillCharge>> result = null;

        Duration remainingDuration = Duration.between(from, to);

        Instant actualFrom = from;
        Instant actualTo;

        do {
            Duration duration = min(remainingDuration, Users.MAX_DURATION);
            actualTo = actualFrom.plus(duration);
            Instant finalFrom = actualFrom;
            Instant finalTo = actualTo;

            Observable<Response<BillCharge>> observable = call(offset -> users.findAllUserCharges(userId, sortOrder, finalFrom.getEpochSecond(), finalTo.getEpochSecond(), null, offset, null, fields));
            result = (result == null) ? observable : result.concatWith(observable);

            actualFrom = actualTo;
            remainingDuration = remainingDuration.minus(duration);
        } while (remainingDuration.getSeconds() > 0);

        return result;
    }

    private static Duration min(Duration a, Duration b) {
        return a.compareTo(b) <= 0 ? a : b;
    }

    @Override
    public Observable<Response<BillPayment>> findAllUserPayments(long userId, Users.SortOrder sortOrder, Instant from, Instant to, Collection<String> fields) {
        return call(offset -> users.findAllUserPayments(userId, sortOrder, toTimeStamp(from), toTimeStamp(to), null, offset, null, fields));
    }
}

