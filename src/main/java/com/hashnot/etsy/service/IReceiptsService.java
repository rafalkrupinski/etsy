package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Receipt;
import com.hashnot.etsy.dto.Response;
import rx.Observable;

import java.util.Collection;

/**
 * @author Rafał Krupiński
 */
public interface IReceiptsService {
    Observable<Response<Receipt>> getReceipt(
            Collection<Long> receiptsIds,
            Collection<String> includes,
            Collection<String> fields
    );
}
