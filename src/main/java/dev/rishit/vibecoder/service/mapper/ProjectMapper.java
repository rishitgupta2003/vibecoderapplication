package dev.rishit.vibecoder.service.mapper;

import dev.rishit.vibecoder.dto.project.ProjectResponse;
import dev.rishit.vibecoder.dto.project.ProjectSummaryResponse;
import dev.rishit.vibecoder.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    /*
    *  @Mapping(source = `source_field_name`, target = `target_field_name`)
    */
    ProjectResponse toProjectResponse(Project entity);
    ProjectSummaryResponse toProjectSummaryResponse(Project entity);
    List<ProjectSummaryResponse> toListProjectSummaryResponse(List<Project> projects);

    Project toProject(ProjectResponse projectResponse);
    List<Project> toProject(List<ProjectSummaryResponse> summaryResponseList);

}
