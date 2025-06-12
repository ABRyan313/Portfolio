package com.pondit.portfolio.persistance.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Table(name = "project")
@Entity
public class ProjectEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    private String name;

    @Setter
    private String description;

}
