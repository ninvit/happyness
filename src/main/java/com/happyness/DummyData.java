package com.happyness;

import com.happyness.document.Project;
import com.happyness.repository.ProjectRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final ProjectRepository projectRepository;

    DummyData(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        projectRepository.deleteAll()
                .thenMany(
                        Flux.just(
                                "API REST Spring Boot", "Deploy application", "Java11", "Github", "Spring Security",
                                "RESTFULL WS", "Spring framework"
                        )
                                .map(name -> new Project(UUID.randomUUID(), name))
                                .flatMap(projectRepository::save))
                .subscribe(System.out::println);

    }
}
