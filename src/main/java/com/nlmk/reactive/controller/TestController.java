package com.nlmk.reactive.controller;

import com.nlmk.reactive.domain.Country;
import com.nlmk.reactive.service.TestService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/test")
@AllArgsConstructor
public class TestController {
    private final TestService service;
    @GetMapping
    public Flux<Country> test(){
        return service.findHot()
                .onErrorResume(t -> Mono.empty())
                .switchIfEmpty(Mono.defer(Mono::empty));
    }
}
