package com.happyness.services;

import com.happyness.document.Project;
import com.happyness.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService{

    @Autowired
    ProjectRepository projectRepository;

    @Override
    public Flux<Project> findAll() {
        return projectRepository.findAll();
    }

    @Override
    public Mono<Project> findById(UUID id) {
        return projectRepository.findById(id);
    }

    @Override
    public Mono<Project> save(Project project) {
        return projectRepository.save(project);
    }
}
