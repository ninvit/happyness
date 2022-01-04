package com.happyness.repository;

import com.happyness.document.Family;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface FamilyRepository extends ReactiveMongoRepository<Family, UUID> {
}
