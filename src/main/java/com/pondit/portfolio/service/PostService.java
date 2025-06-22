package com.pondit.portfolio.service;

import com.pondit.portfolio.model.domain.Post;
import com.pondit.portfolio.persistance.entity.PostEntity;
import com.pondit.portfolio.persistance.repository.PostRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public List<Post> getAllPosts(Pageable pageable){
        List<PostEntity> entityList = postRepository.findAll(pageable).getContent();
        return entityList.stream().map(entity ->{
            Post domain = new Post();
            BeanUtils.copyProperties(entity, domain);
            return domain;
        }).toList();
    }
}
