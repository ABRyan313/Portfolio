package com.pondit.API_example.controller.rest;

import com.pondit.API_example.model.domain.Project;
import com.pondit.API_example.model.dto.CreateProjectRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    List <Project> projects = new ArrayList<>();

    @GetMapping
    public List<Project> getAllProjects(){
        return projects;
    }

//    @GetMapping("/{id}")
//    public Project getProjectById(@PathVariable int id) {
//        return null;
//    }

    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request){

        String name = request.getName();
        String description = request.getDescription();

        Project project = new Project(name, description);
        projects.add(project);
        return new Project(name, description);
    }
}
