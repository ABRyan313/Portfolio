package com.pondit.portfolio.model.domain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Project {


    private Long id;


    public String name;


    private String description;
}
