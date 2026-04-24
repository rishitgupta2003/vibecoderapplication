package dev.rishit.vibecoder.controller;

import dev.rishit.vibecoder.service.ProjectMemberService;
import dev.rishit.vibecoder.util.ResponseBuilder;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/projects/{id}/members")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectMemberController {

    ProjectMemberService projectMemberService;
    ResponseBuilder responseBuilder;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllMembers(@PathVariable Long id) {
        // TODO -> Complete Logic
        return null;
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> inviteByEmail(@PathVariable Long id, @RequestBody Object request) {
        // TODO -> Complete Logic
        return null;
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> changeRole(@PathVariable Long id, @PathVariable Long userId, @RequestBody Object request) {
        // TODO -> Complete Logic
        return null;
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Map<String, Object>> removeMember(@PathVariable Long id, @PathVariable Long userId) {
        // TODO -> Complete Logic
        return null;
    }
}