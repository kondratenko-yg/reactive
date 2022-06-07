package com.nlmk.reactive.service;

import com.nlmk.reactive.domain.Country;
import com.nlmk.reactive.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

    private final TestRepository repository;

    @Override
    public Flux<Country> findHot() {
        return repository.findByHotTrue()
                .doOnNext(country -> log.info("Found hot country {}", country));
    }
}
