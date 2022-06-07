package com.nlmk.reactive.repository;

import com.nlmk.reactive.domain.Country;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface TestRepository  extends ReactiveCrudRepository<Country, Long> {

   Flux<Country> findByHotTrue();
}
