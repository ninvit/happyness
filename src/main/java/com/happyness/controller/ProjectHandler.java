package com.happyness.controller;

import com.happyness.document.Child;
import com.happyness.document.Family;
import com.happyness.document.Project;
import com.happyness.services.ChildService;
import com.happyness.services.FamilyService;
import com.happyness.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class ProjectHandler {

    @Autowired
    ProjectService projectService;

    @Autowired
    ChildService childService;

    @Autowired

    FamilyService familyService;

    public Mono<ServerResponse> findAllFamilies(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(familyService.findAll(), Family.class);
    }

    public Mono<ServerResponse> findFamilyById(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(familyService.findById(id), Family.class);
    }

    public Mono<ServerResponse> saveFamily(ServerRequest request) {
        final Mono<Family> family = request.bodyToMono(Family.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(family.flatMap(familyService::save), Family.class));
    }

    public Mono<ServerResponse> findAllChildren(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(childService.findAll(), Child.class);
    }

    public Mono<ServerResponse> findChildById(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(childService.findById(id), Child.class);
    }

    public Mono<ServerResponse> saveChild(ServerRequest request) {
        final Mono<Child> child = request.bodyToMono(Child.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(child.flatMap(childService::save), Child.class));
    }

    public Mono<ServerResponse> findAll(ServerRequest request) {
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(projectService.findAll(), Project.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        UUID id = UUID.fromString(request.pathVariable("id"));
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(projectService.findById(id), Project.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Project> project = request.bodyToMono(Project.class);
        return ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(fromPublisher(project.flatMap(projectService::save), Project.class));
    }
}
