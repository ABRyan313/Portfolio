package com.pondit.portfolio.model.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Post {
        private Long id;
        private String title;
        private String content;
        private String slug;
        private Boolean published;
        private LocalDateTime publishedAt;
    }

