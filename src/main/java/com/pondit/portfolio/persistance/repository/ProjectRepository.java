package com.pondit.portfolio.persistance.repository;

import com.pondit.portfolio.persistance.entity.ProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {
}
