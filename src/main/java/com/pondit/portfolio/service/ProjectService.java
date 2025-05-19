package com.pondit.portfolio.service;

import com.pondit.portfolio.model.domain.Project;
import com.pondit.portfolio.model.dto.CreateProjectRequest;
import com.pondit.portfolio.persistance.entity.ProjectEntity;
import com.pondit.portfolio.persistance.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public Project createProject(CreateProjectRequest request){
        String name = request.getName();
        String description = request.getDescription();

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
}
