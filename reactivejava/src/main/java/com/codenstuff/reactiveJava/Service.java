package com.codenstuff.reactiveJava;


import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author MalkeithSingh on 20-09-2019
 */
public final class Service {


    private ExecutorService exservice = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    private Observable<String> getStringData = Observable.<String>create(emitter -> {
        int times = 10;
        String str = "a";
        while (times-- > 0) {
            try {
                Thread.sleep(1000);
                str = str+"a";
                emitter.onNext(str);
            } catch (InterruptedException e) {
                emitter.onError(e);
            }
        }
        emitter.onComplete();
    });

    private Observable<Integer> getIntegerData = Observable.<Integer>create(emitter -> {
        int times = 10;
        while (times-- > 0) {
            try {
                Thread.sleep(1000);
                emitter.onNext(times);
            } catch (InterruptedException e) {
                emitter.onError(e);
            }
        }
        emitter.onComplete();
    });



    public Observable<String> getGetStringData() {
        return getStringData;
    }

    public Observable<Integer> getGetIntegerData() {
        return getIntegerData;
    }
}
