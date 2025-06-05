package com.pondit.portfolio.service;

import com.pondit.portfolio.exception.custom.NotFoundException;
import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import com.pondit.portfolio.model.dto.UpdateProjectRequest;
import com.pondit.portfolio.persistance.entity.ProjectEntity;
import com.pondit.portfolio.persistance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {

   @Autowired
   ProjectRepository projectRepository;

    public List <Project> getAllProjects(){
        List <ProjectEntity> entitiyList = projectRepository.findAll();
        return entitiyList.stream().map(projectEntity -> {
            Long entityId = projectEntity.getId();
            String entityName = projectEntity.getName();
            String entityDescription = projectEntity.getDescription();
            return new Project(entityId, entityName, entityDescription);
        }).toList();
    }

    public Project getProjectById(Long id) throws NotFoundException{
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(id);
        if(projectEntityOptional.isEmpty()){
            throw new NotFoundException("ProjectNotFound");
        }

        ProjectEntity projectEntity = projectEntityOptional.get();
        Long entityId = projectEntity.getId();
        String entityName = projectEntity.getName();
        String entityDescription = projectEntity.getDescription();

        Project project = new Project(entityId, entityName, entityDescription);
        return project;
    }

    public Project createProject(CreateProjectRequest request){
        String name = request.name();
        String description = request.description();

        //save project to database
        ProjectEntity entity = new ProjectEntity();
        entity.setName(name);
        entity.setDescription(description);
        ProjectEntity savedEntity = projectRepository.save(entity);

        //map entity to domain model
        Long savedEntityId = savedEntity.getId();
        String savedEntityName = savedEntity.getName();
        String savedEntityDescription = savedEntity.getDescription();
        return new Project(savedEntityId, savedEntityName, savedEntityDescription);
    }

    public void updateProject(Long id, UpdateProjectRequest request) throws NotFoundException{
        // request
        String name = request.name();
        String description = request.description();

        // query existing project
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(id);

        if (projectEntityOptional.isEmpty()) {
            throw new NotFoundException("Project not found");
        }

        // save to database
        ProjectEntity projectEntity = projectEntityOptional.get();
        projectEntity.setName(name);
        projectEntity.setDescription(description);
        projectRepository.save(projectEntity);
    }

    public void deleteProject(Long id) throws NotFoundException{
        // query existing project
        Optional<ProjectEntity> projectEntityOptional = projectRepository.findById(id);
        if (projectEntityOptional.isEmpty()) {
            throw new NotFoundException("Project not found");
        }

        // delete from database
        projectRepository.deleteById(id);

    }
}
