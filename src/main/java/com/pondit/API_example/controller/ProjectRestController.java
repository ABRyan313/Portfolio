package com.pondit.API_example.controller;

import com.pondit.API_example.model.domain.Project;
import com.pondit.API_example.model.dto.ProjectDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProjectRestController {

    List <Project> projects = new ArrayList<>();

    @GetMapping("/api/projects")
    public List<Project> getAllProjects(){
        return projects;
    }

    @PostMapping("/api/projects")
    public Project createProject(@RequestBody ProjectDTO projectDto){

        String name = projectDto.getName();
        String description = projectDto.getDescription();

        Project project = new Project(name, description);
        projects.add(project);
        return new Project(name, description);
    }
}
