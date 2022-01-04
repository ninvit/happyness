package com.happyness.services;

import com.happyness.document.Child;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ChildService {

    Flux<Child> findAll();
    Mono<Child> findById(UUID id);
    Mono<Child> save(Child child);
}
