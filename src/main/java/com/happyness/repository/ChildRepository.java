package com.happyness.repository;

import com.happyness.document.Child;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import java.util.UUID;

public interface ChildRepository extends ReactiveMongoRepository<Child, UUID> {
}
