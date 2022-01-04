package com.happyness;

import com.happyness.document.Project;
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
