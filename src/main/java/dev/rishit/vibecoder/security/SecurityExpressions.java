package dev.rishit.vibecoder.security;

import dev.rishit.vibecoder.enums.ProjectPermission;
import dev.rishit.vibecoder.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final ProjectMemberRepository projectMemberRepository;
    private final AuthUtil authUtil;

    public boolean hasPermission(Long projectId, ProjectPermission... permission) {
        Long userId = authUtil.getCurrentUserId();
        return projectMemberRepository.
                findRoleByProjectIdAndUserId(
                        projectId, userId
                ).map(
                        role -> role.getPermissions().containsAll(List.of(permission))
                ).orElse(false);
    }

    public boolean canViewProject(Long projectId){
        return hasPermission(projectId, ProjectPermission.VIEW);
    }

    public boolean canEditProject(Long projectId){
        return hasPermission(projectId, ProjectPermission.EDIT);
    }

    public boolean canDeleteProject(Long projectId){
        return hasPermission(projectId, ProjectPermission.DELETE);
    }

    public boolean canManageMembers(Long projectId){
        return hasPermission(projectId, ProjectPermission.MANAGE_MEMBERS);
    }
}
