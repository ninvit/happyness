package com.happyness.services;

import com.happyness.document.Project;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface ProjectService {

    Flux<Project> findAll();
    Mono<Project> findById(UUID id);
    Mono<Project> save(Project project);
}
