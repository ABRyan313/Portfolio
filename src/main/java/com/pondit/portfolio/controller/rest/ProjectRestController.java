package com.pondit.portfolio.controller.rest;

import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import com.pondit.portfolio.service.ProjectService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Tag(name = "Project Resource", description = "API for managing projects")
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    ProjectService projectService;


    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

//    @GetMapping("/{id}")
//    public Project getProjectById(@PathVariable int id) {
//        return null;
//    }


    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request){

        return projectService.createProject(request);
    }
}
