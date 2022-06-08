package com.nlmk.reactive.service;

import com.nlmk.reactive.domain.Country;
import com.nlmk.reactive.repository.TestRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
@SpringBootTest
class TestServiceImplTest {
    private TestService testService;

    @Autowired
    private TestRepository repository;

    @BeforeEach
    void setUp(){
        testService = new TestServiceImpl(repository);
    }

    @Test
    void test(){
        var expected = new Country().setId(3L).setName("Brazil").setHot(true);
        StepVerifier
                .create(testService.findHot().onErrorResume(t -> {log.error("Error", t); return Mono.empty();}))
                .expectNext(expected)
                .expectComplete()
                .verify();
    }
}
