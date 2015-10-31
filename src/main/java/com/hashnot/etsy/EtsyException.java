package com.hashnot.etsy;

import si.mazi.rescu.*;

import java.util.List;
import java.util.Map;

/**
 * @author Rafał Krupiński
 */
public class EtsyException extends HttpStatusExceptionSupport implements HttpResponseAware {
    private Map<String, List<String>> headers;

    @Override
    public void setResponseHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    @Override
    public Map<String, List<String>> getResponseHeaders() {
        return headers;
    }
}
