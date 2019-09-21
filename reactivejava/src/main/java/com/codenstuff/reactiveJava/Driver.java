package com.codenstuff.reactiveJava;

import io.reactivex.Observable;
import io.reactivex.ObservableConverter;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import java.net.Socket;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author MalkeithSingh on 20-09-2019
 */
public class Driver {

    private Service service;

    public Driver(Service service) {
        this.service = service;
    }

    public static void main(String[] args) throws InterruptedException {

        Driver driver = new Driver(new Service());
        Observable.zip(driver.service.getGetStringData(),driver.service.getGetIntegerData(),(x,y)->x+y).subscribe(System.out::println);

//        Socket socket = new Socket();
//        socket.
    }

    class CookEggs implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(5000);
            return true;
        }
    }

    class ToastBread implements Callable<Boolean> {

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(5000);
            return true;
        }
    }

    class GetBreakfast implements Callable<Boolean> {

        private Boolean CookEggs;
        private Boolean tostBread;

        public GetBreakfast(Boolean cookEggs, Boolean tostBread) {
            CookEggs = cookEggs;
            this.tostBread = tostBread;
        }

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(5000);
            return true;
        }
    }
}
