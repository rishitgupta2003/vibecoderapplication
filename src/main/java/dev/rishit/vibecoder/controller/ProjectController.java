package dev.rishit.vibecoder.controller;

import dev.rishit.vibecoder.dto.project.ProjectRequest;
import dev.rishit.vibecoder.dto.project.ProjectResponse;
import dev.rishit.vibecoder.dto.project.ProjectSummaryResponse;
import dev.rishit.vibecoder.service.ProjectService;
import dev.rishit.vibecoder.service.auth.PostgresqlUserPrincipal;
import dev.rishit.vibecoder.util.ResponseBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class ProjectController {

    ProjectService projectService;
    ResponseBuilder responseBuilder;

    // Project CRUD
    @PostMapping
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody ProjectRequest request, @AuthenticationPrincipal PostgresqlUserPrincipal loggedInUser) {
        ProjectResponse project = projectService.createProject(request, loggedInUser);
        return responseBuilder.buildCreatedResponse(project);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getProject(@PathVariable Long id, @AuthenticationPrincipal PostgresqlUserPrincipal loggedInUser) {
        ProjectResponse userProjectById = projectService.getUserProjectById(loggedInUser, id);
        return responseBuilder.buildOkResponse(userProjectById);
    }

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllProjects(@AuthenticationPrincipal PostgresqlUserPrincipal loggedInUser) {
        List<ProjectSummaryResponse> userProject = projectService.getUserProject(loggedInUser);
        return responseBuilder.buildOkResponse(userProject);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateProject(
            @AuthenticationPrincipal PostgresqlUserPrincipal loggedInUser,
            @PathVariable Long id, @RequestBody ProjectRequest request)
    {
        ProjectResponse projectResponse = projectService.updateProject(id, request,  loggedInUser);

        return responseBuilder.buildOkResponse(projectResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteProject(@AuthenticationPrincipal PostgresqlUserPrincipal loggedInUser ,@PathVariable Long id) {
        projectService.softDelete(loggedInUser, id);
        return responseBuilder.buildNoContentResponse();
    }

    // Files
    @GetMapping("/{id}/files")
    public ResponseEntity<Map<String, Object>> getFileTree(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping("/{id}/files/**")
    public ResponseEntity<Map<String, Object>> downloadFile(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping("/{id}/download-zip")
    public ResponseEntity<Map<String, Object>> downloadZip(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }
}
