package com.hashnot.etsy.service;

import com.hashnot.etsy.dto.Response;
import com.hashnot.etsy.dto.dict.DictionaryResponse;
import com.hashnot.u.async.Async;
import rx.Observable;
import rx.Observer;
import rx.subjects.ReplaySubject;

import java.time.Instant;
import java.util.concurrent.Executor;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author Rafał Krupiński
 */
class AbstractEtsyService extends Async {
    private Executor executor;

    public AbstractEtsyService(Executor executor) {
        this.executor = executor;
    }

    static <O, I> O ns(I o, Function<I, O> conv) {
        return o == null ? null : conv.apply(o);
    }

    protected <T> Observable<Response<T>> call(ThrowingFunction<Integer, Response<T>> method) {
        ReplaySubject<Response<T>> result = ReplaySubject.create();
        Async.call(() -> method.apply(0), executor, new ResponseHandler<>(executor, method, result));
        return result;
    }

    private static class ResponseHandler<T> implements BiConsumer<Response<T>, Throwable> {
        private Executor executor;
        private ThrowingFunction<Integer, Response<T>> method;
        private Observer<Response<T>> observer;
        private int count = 0;

        private ResponseHandler(Executor executor, ThrowingFunction<Integer, Response<T>> method, Observer<Response<T>> observer) {
            this.executor = executor;
            this.method = method;
            this.observer = observer;
        }

        @Override
        public void accept(Response<T> result, Throwable throwable) {
            if (throwable != null) {
                observer.onError(throwable);
            } else {
                try {
                    count += result.getResults().size();

                    if (result.getCount() > count) {
                        Async.call(() -> method.apply(count), executor, this);
                        observer.onNext(result);
                    } else
                        observer.onNext(result);
                        observer.onCompleted();
                } catch (Exception e) {
                    observer.onError(e);
                }
            }
        }
    }

    protected interface ThrowingFunction<T, R> {
        R apply(T t) throws Exception;
    }

    protected static Integer toTimeStamp(Instant time) {
        return time == null ? null : (int) time.getEpochSecond();
    }

    protected <T> Observable<DictionaryResponse<T>> callDict(ThrowingFunction<Integer, DictionaryResponse<T>> method) {
        ReplaySubject<DictionaryResponse<T>> result = ReplaySubject.create();
        Async.call(() -> method.apply(0), executor, new DictionaryResponseHandler<>(result));
        return result;
    }

    private static class DictionaryResponseHandler<T> implements BiConsumer<DictionaryResponse<T>, Throwable> {
        private Observer<DictionaryResponse<T>> observer;

        private DictionaryResponseHandler(Observer<DictionaryResponse<T>> observer) {
            this.observer = observer;
        }

        @Override
        public void accept(DictionaryResponse<T> result, Throwable throwable) {
            if (throwable != null)
                observer.onError(throwable);
            else {
                observer.onNext(result);
                observer.onCompleted();
            }
        }
    }
}
