package dev.rishit.vibecoder.service;

import dev.rishit.vibecoder.dto.project.ProjectRequest;
import dev.rishit.vibecoder.dto.project.ProjectResponse;
import dev.rishit.vibecoder.dto.project.ProjectSummaryResponse;
import dev.rishit.vibecoder.service.auth.PostgresqlUserPrincipal;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProjectService {

    public ProjectResponse createProject(ProjectRequest request, PostgresqlUserPrincipal loggedInUser);
    public List<ProjectSummaryResponse> getUserProject (PostgresqlUserPrincipal loggedInUser);
    public ProjectResponse getUserProjectById(PostgresqlUserPrincipal loggedInUse, Long projectId);
    public ProjectResponse updateProject(Long id, ProjectRequest request, PostgresqlUserPrincipal loggedInUser);
    public void softDelete(PostgresqlUserPrincipal loggedInUser, Long projectId);
}
