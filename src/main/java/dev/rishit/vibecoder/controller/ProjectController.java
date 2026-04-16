package dev.rishit.vibecoder.controller;

import dev.rishit.vibecoder.service.ProjectService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/projects")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectController {

    final ProjectService projectService;

    // Project CRUD
    @PostMapping
    public ResponseEntity<Map<String, Object>> createProject(@RequestBody Object request) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping("/{id}")
    public Object getProject(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping
    public Object getAllProjects() {
        // TODO: Complete Logic
        return null;
    }

    @PutMapping("/{id}")
    public Object updateProject(@PathVariable Long id, @RequestBody Object request) {
        // TODO: Complete Logic
        return null;
    }

    @DeleteMapping("/{id}")
    public Object deleteProject(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    // Files
    @GetMapping("/{id}/files")
    public Object getFileTree(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping("/{id}/files/**")
    public Object downloadFile(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }

    @GetMapping("/{id}/download-zip")
    public Object downloadZip(@PathVariable Long id) {
        // TODO: Complete Logic
        return null;
    }
}
