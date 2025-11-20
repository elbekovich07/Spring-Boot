package com.programm.Spring.Boot.project;

import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ProjectMapper {
    Project toEntity(ProjectDto projectDto);

    ProjectDto toDto(Project project);

    List<ProjectDto> toDto(List<Project> project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectDto projectDto, @MappingTarget Project project);

    Project toEntity(ProjectCreateDto projectCreateDto);

    ProjectCreateDto toDto1(Project project);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Project partialUpdate(ProjectCreateDto projectCreateDto, @MappingTarget Project project);
}

