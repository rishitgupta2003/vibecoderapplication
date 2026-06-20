package dev.rishit.vibecoder.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import java.util.Set;
import static dev.rishit.vibecoder.enums.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR  (Set.of(EDIT, DELETE)),
    VIEWER  (Set.of(VIEW)),
    OWNER   (Set.of(VIEW, EDIT, DELETE, MANAGE_MEMBERS));

    ProjectRole(ProjectPermission... permissions){
        this.permissions = Set.of(permissions);
    }

    private final Set<ProjectPermission> permissions;
}