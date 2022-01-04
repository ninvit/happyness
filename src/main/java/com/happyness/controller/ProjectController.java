package com.happyness.controller;

import com.happyness.document.Project;
import com.happyness.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.UUID;

@RestController
public class ProjectController {

    @Autowired
    ProjectService projectService;

    @GetMapping(value = "/project")
    public Flux<Project> findAll() {
        return projectService.findAll();
    }

    @GetMapping(value = "/project/{id}")
    public Mono<Project> getProjectId(@PathVariable UUID id) {
        return projectService.findById(id);
    }

    @PostMapping(value = "/project")
    public Mono<Project> save(@RequestBody Project project) {
        return projectService.save(project);
    }

    @GetMapping(value = "/project/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, Project>> getProjectlistByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<Project> events = projectService.findAll();
        System.out.println("BATEU EVENTS");
        return Flux.zip(interval, events);
    }
}
