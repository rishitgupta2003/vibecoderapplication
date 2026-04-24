package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.project.ProjectRequest;
import dev.rishit.vibecoder.dto.project.ProjectResponse;
import dev.rishit.vibecoder.dto.project.ProjectSummaryResponse;
import dev.rishit.vibecoder.entity.Project;
import dev.rishit.vibecoder.entity.User;
import dev.rishit.vibecoder.exceptions.ProjectNotFoundException;
import dev.rishit.vibecoder.exceptions.UserNotFoundException;
import dev.rishit.vibecoder.repository.ProjectRepository;
import dev.rishit.vibecoder.repository.UserRepository;
import dev.rishit.vibecoder.service.ProjectService;
import dev.rishit.vibecoder.service.auth.PostgresqlUserDetailService;
import dev.rishit.vibecoder.service.auth.PostgresqlUserPrincipal;
import dev.rishit.vibecoder.service.mapper.ProjectMapper;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;

    @Override
    public ProjectResponse createProject(ProjectRequest request, PostgresqlUserPrincipal loggedInUser) {
        User owner = userRepository.findByEmail(loggedInUser.getUsername())
                .orElseThrow(() -> new UserNotFoundException(loggedInUser.getUsername()));

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .owner(owner)
                .build();

        Project saveProject = projectRepository.save(project);
        return projectMapper.toProjectResponse(saveProject);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProject(PostgresqlUserPrincipal loggedInUser) {
        List<Project> projectByOwner = projectRepository.getUserProject(loggedInUser.getUserId());

//        return projectByOwner
//                .stream()
//                .map(projectMapper::toProjectSummaryResponse)
//                .toList();

        return projectMapper
                .toListProjectSummaryResponse(projectByOwner);
    }

    @Override
    public ProjectResponse getUserProjectById(PostgresqlUserPrincipal loggedInUser, Long projectId) {
        Project project = projectRepository
                .findAccessibleProjectById(projectId, loggedInUser.getUserId())
                .orElseThrow( () ->  new ProjectNotFoundException(String.valueOf(projectId)));

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, PostgresqlUserPrincipal loggedInUser) {
        Project project = projectRepository
                .findAccessibleProjectById(id, loggedInUser.getUserId())
                .orElseThrow( () ->  new ProjectNotFoundException(String.valueOf(id)));

        project.setName(request.name());

        Project save = projectRepository.save(project);

        return projectMapper.toProjectResponse(save);
    }

    @Override
    public void softDelete(PostgresqlUserPrincipal loggedInUser, Long projectId) {
        Project project = projectRepository.findAccessibleProjectById(projectId, loggedInUser.getUserId())
                .orElseThrow(() -> new ProjectNotFoundException(String.valueOf(projectId)));

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }
}
