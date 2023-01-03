package io.github.xsmair.neturalsample.dto;

import io.github.xsmair.neturalsample.model.Project;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ProjectDto {
    private String name;

    private String description;

    public static ProjectDto fromEntity(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setName(project.getName());
        projectDto.setDescription(project.getDescription());
        return projectDto;
    }

    public static Project toEntity(ProjectDto projectDto) {
        Project project = new Project();
        project.setName(projectDto.getName());
        project.setDescription(projectDto.getDescription());
        return project;
    }
}
