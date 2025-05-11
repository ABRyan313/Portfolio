package com.pondit.portfolio.controller.rest;

import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Project Resource", description = "API for managing projects")
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    List <Project> projects = new ArrayList<>();

    @Tag(name = "Get all projects", description = "Get all projects")
    @GetMapping
    public List<Project> getAllProjects(){
        return projects;
    }

//    @GetMapping("/{id}")
//    public Project getProjectById(@PathVariable int id) {
//        return null;
//    }
    @Tag(name = "Create project", description = "Create a new project")
    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request){

        String name = request.getName();
        String description = request.getDescription();

        Project project = new Project(name, description);
        projects.add(project);
        return new Project(name, description);
    }
}
