package com.happyness.repository;

import com.happyness.document.Project;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import java.util.UUID;

public interface ProjectRepository  extends ReactiveMongoRepository<Project, UUID> {
}
