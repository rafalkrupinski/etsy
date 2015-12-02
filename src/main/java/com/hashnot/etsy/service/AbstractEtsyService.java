package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import rx.Observable;
import rx.Observer;
import rx.subjects.ReplaySubject;

import java.util.concurrent.Executor;
import java.util.function.Function;

/**
 * @author Rafał Krupiński
 */
public class AbstractEtsyService {
    public static final int MAX_LIMIT = 100;
    protected final String apiKey;
    protected Executor executor;

    public AbstractEtsyService(String apiKey, Executor executor) {
        this.apiKey = apiKey;
        this.executor = executor;
    }

    static <O, I> O ns(I o, Function<I, O> conv) {
        return o == null ? null : conv.apply(o);
    }

    protected <T> Observable<Response<T>> call(ThrowingFunction<Integer, Response<T>> method) {
        ReplaySubject<Response<T>> result = ReplaySubject.create();
        executor.execute(new Retriever<>(method, result, executor));
        return result;
    }

    private static class Retriever<T> implements Runnable {
        final protected Logger log = LoggerFactory.getLogger(Retriever.class);

        private ThrowingFunction<Integer, Response<T>> supplier;
        private Observer<Response<T>> observer;
        private Executor executor;
        private int count = 0;

        public Retriever(ThrowingFunction<Integer, Response<T>> supplier, Observer<Response<T>> observable, Executor executor) {
            this.supplier = supplier;
            this.observer = observable;
            this.executor = executor;
        }

        @Override
        public void run() {
            try {
                Response<T> active = supplier.apply(count);
                observer.onNext(active);
                count += active.getResults().size();

                if (active.getCount() > count)
                    executor.execute(this::run);
                else
                    observer.onCompleted();

            } catch (Throwable e) {
                log.warn("Error", e);
                observer.onError(e);
            }
        }
    }

    protected interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }
}
