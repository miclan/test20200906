package com.miclan.x.test20200906.service;

import java.util.concurrent.CompletableFuture;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    @Async
    public CompletableFuture<String> getString1(String input) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(input + "-----" + Thread.currentThread().getName());
        return CompletableFuture.completedFuture("output=" + input);
    }
}
