package com.nlmk.reactive.service;

import com.nlmk.reactive.domain.Country;
import com.nlmk.reactive.repository.TestRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.test.StepVerifier;

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
                .create(testService.findHot())
                .expectNext(expected)
                .expectComplete()
                .verify();
    }
}
