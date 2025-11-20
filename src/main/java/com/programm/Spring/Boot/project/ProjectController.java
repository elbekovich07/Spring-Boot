package com.programm.Spring.Boot.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/project")
public class ProjectController {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    public ProjectController(ProjectRepository projectRepository, ProjectMapper projectMapper) {
        this.projectRepository = projectRepository;
        this.projectMapper = projectMapper;
    }

    @GetMapping
    public List<ProjectDto> getAllProjects() {
        List<Project> projectList = projectRepository.findAll();
        return projectMapper.toDto(projectList);

    }

    @PostMapping
    public Project create(@RequestBody ProjectCreateDto dto){
        Project project = projectMapper.toEntity(dto);
        project.setCode(dto.getName().replace(" ", "_").toUpperCase());
        projectRepository.save(project);
        return project;
    }

}
