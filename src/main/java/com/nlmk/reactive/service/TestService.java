package com.nlmk.reactive.service;

import com.nlmk.reactive.domain.Country;
import reactor.core.publisher.Flux;

public interface TestService {
    Flux<Country> findHot();
}
