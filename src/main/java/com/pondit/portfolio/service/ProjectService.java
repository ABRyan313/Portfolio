package com.pondit.portfolio.service;

import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProjectService {

    List<Project> projects = new ArrayList<>();

    public List <Project> getAllProjects(){
        return projects;
    }

    public Project createProject(CreateProjectRequest request){
        String name = request.getName();
        String description = request.getDescription();

        Project project = new Project(name, description);
        projects.add(project);
        return project;
    }
}
