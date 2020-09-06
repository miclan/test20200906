package com.miclan.x.test20200906.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/heavy")
public class HeavyController {

    @GetMapping("/heavy")
    public List<String> getHeavy() {
        return Stream.iterate(1, i -> i + 1).limit(100).map(value -> "hello " + value).collect(Collectors.toList());
    }

}