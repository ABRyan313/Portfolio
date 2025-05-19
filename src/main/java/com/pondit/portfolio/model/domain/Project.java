package com.pondit.portfolio.model.domain;

public class Project {

    private Long id;
    private String name;
    private String description;

    public Project(Long Id, String name, String description ) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
