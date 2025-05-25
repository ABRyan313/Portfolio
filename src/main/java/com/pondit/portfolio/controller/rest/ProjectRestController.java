package com.pondit.portfolio.controller.rest;



import com.pondit.portfolio.exception.NotFoundException;
import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import com.pondit.portfolio.model.dto.UpdateProjectRequest;
import com.pondit.portfolio.service.ProjectService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Project Resource", description = "API for managing projects")
@RestController
@RequestMapping("/api/projects")
public class ProjectRestController {

    @Autowired
    ProjectService projectService;


    @Operation(summary = "Get all Projects")
    @GetMapping
    public List<Project> getAllProjects(){
        return projectService.getAllProjects();
    }

    @Operation(summary = "Get a project by id")
    @GetMapping("{id}")
    public ResponseEntity<Project> getProject(@PathVariable Long id) {
        Project project;
        try{
            project = projectService.getProjectById(id);
        }
        catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
        catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(project);
    }


    @Operation(summary = "Create new project")
    @PostMapping
    public Project createProject(@RequestBody CreateProjectRequest request){

        return projectService.createProject(request);
    }

    @Operation(summary = "Update a project by id")
    @PutMapping("{id}")
    public void updateProject(@PathVariable Long id, @RequestBody UpdateProjectRequest request){
        try{
            projectService.updateProject(id, request);
        } catch(NotFoundException e) {
            ResponseEntity.notFound().build();
        }
        catch(Exception e){
            ResponseEntity.internalServerError().build();
        }
    }

    @Operation(summary = "Delete a project by id")
    @DeleteMapping("{id}")
    public void deleteProject(@PathVariable Long id){
        try{
            projectService.deleteProject(id);
        }
        catch (NotFoundException e) {
            ResponseEntity.notFound().build();
        } catch (Exception e) {
            ResponseEntity.internalServerError().build();
        }
    }
}
