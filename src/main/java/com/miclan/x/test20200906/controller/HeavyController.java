package com.miclan.x.test20200906.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.miclan.x.test20200906.service.AsyncService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import avro.shaded.com.google.common.collect.Lists;

@RestController
@RequestMapping("/heavy")
public class HeavyController {

    @Autowired
    private AsyncService asyncService;

    @GetMapping("/hello")
    public List<String> sayHello() {
        System.out.println("getHeavy");
        return Stream.iterate(1, i -> i + 1).limit(100).map(value -> "hello22 " + value).collect(Collectors.toList());
    }

    @GetMapping("/async")
    public List<String> async() throws InterruptedException, ExecutionException {

        CompletableFuture<String> cf1 = asyncService.getString1("1");
        CompletableFuture<String> cf2 = asyncService.getString1("2");
        CompletableFuture<String> cf3 = asyncService.getString1("3");
        CompletableFuture<String> cf4 = asyncService.getString1("4");
        CompletableFuture<String> cf5 = asyncService.getString1("5");
        
        // CompletableFuture.allOf(cf1, cf2, cf3).join();

        System.out.println("-----");
        // return Lists.newArrayList(cf1.get(), cf2.get(), cf3.get(), cf4.get(), cf5.get());

        String s1 = cf1.get();
        String s2 = cf2.get();
        String s3 = cf3.get();
        String s4 = cf4.get();
        String s5 = cf5.get();

        System.out.println(s1 + s2 + s3 + s4 + s5);

        return null;
    }

    

}