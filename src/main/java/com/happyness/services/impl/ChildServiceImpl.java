package com.happyness.services.impl;

import com.happyness.document.Child;
import com.happyness.repository.ChildRepository;
import com.happyness.services.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ChildServiceImpl implements ChildService {

    @Autowired
    ChildRepository childRepository;

    @Override
    public Flux<Child> findAll() {
        return childRepository.findAll();
    }

    @Override
    public Mono<Child> findById(UUID id) {
        return childRepository.findById(id);
    }

    @Override
    public Mono<Child> save(Child child) {
        return childRepository.save(child);
    }
}
