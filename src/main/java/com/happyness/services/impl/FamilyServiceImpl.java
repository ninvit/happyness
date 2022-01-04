package com.happyness.services.impl;

import com.happyness.document.Family;
import com.happyness.document.Project;
import com.happyness.repository.FamilyRepository;
import com.happyness.services.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class FamilyServiceImpl implements FamilyService {

    @Autowired
    FamilyRepository familyRepository;

    @Override
    public Flux<Family> findAll() {
        return familyRepository.findAll();
    }

    @Override
    public Mono<Family> findById(UUID id) {
        return familyRepository.findById(id);
    }

    @Override
    public Mono<Family> save(Family family) {
        return familyRepository.save(family);
    }
}
