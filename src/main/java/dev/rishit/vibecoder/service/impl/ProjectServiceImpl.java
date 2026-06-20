package dev.rishit.vibecoder.service.impl;

import dev.rishit.vibecoder.dto.project.ProjectRequest;
import dev.rishit.vibecoder.dto.project.ProjectResponse;
import dev.rishit.vibecoder.dto.project.ProjectSummaryResponse;
import dev.rishit.vibecoder.entity.Project;
import dev.rishit.vibecoder.entity.ProjectMember;
import dev.rishit.vibecoder.entity.ProjectMemberId;
import dev.rishit.vibecoder.entity.User;
import dev.rishit.vibecoder.enums.ProjectRole;
import dev.rishit.vibecoder.error.ResourceNotFoundException;
import dev.rishit.vibecoder.mapper.ProjectMapper;
import dev.rishit.vibecoder.repository.ProjectMemberRepository;
import dev.rishit.vibecoder.repository.ProjectRepository;
import dev.rishit.vibecoder.repository.UserRepository;
import dev.rishit.vibecoder.security.AuthUtil;
import dev.rishit.vibecoder.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
@EnableMethodSecurity
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
//        User owner = userRepository.findById(userId).orElseThrow(
//                () -> new ResourceNotFoundException("User", userId.toString())
//        );
        User owner = userRepository.getReferenceById(userId);

        Project project = Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project = projectRepository.save(project);


        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), owner.getId());
        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId = authUtil.getCurrentUserId();
        var projects = projectRepository.findAllAccessibleByUser(userId);
        return projectMapper.toListOfProjectSummaryResponse(projects);
    }

    @Override
    /*
    * PreAuthorize() -> uses `SpEL`: Spring Expression Language
    * @<component_name>.<method_name>.#<argument_variables>
    */
    @PreAuthorize(
            "@security.canViewProject(#projectId)"
    )
    public ProjectResponse getUserProjectById(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize(
            "@security.canEditProject(#projectId)"
    )
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setName(request.name());
        project = projectRepository.save(project);

        return projectMapper.toProjectResponse(project);
    }

    @Override
    //Trying another way (SpEL)
//    @PreAuthorize(
//            "@security.hasPermission(#projectId, T(dev.rishit.vibecoder.enums.ProjectPermission).DELETE)"
//    )
    @PreAuthorize(
            "@security.canDeleteProject(#projectId)"
    )
    public void softDelete(Long projectId) {
        Long userId = authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId, userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }

    ///  INTERNAL FUNCTIONS

    public Project getAccessibleProjectById(Long projectId, Long userId) {
        return projectRepository.findAccessibleProjectById(projectId, userId)
                .orElseThrow(() -> new ResourceNotFoundException("Project", projectId.toString()));
    }
}
