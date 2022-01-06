package com.happyness.services;

import com.happyness.document.Family;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface FamilyService {

    Flux<Family> findAll();
    Mono<Family> findById(UUID id);
    Mono<Family> save(Family project);
    Mono<Void> delete(UUID id);
}
