package com.pondit.portfolio.persistance.repository;

import com.pondit.portfolio.persistance.entity.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

}
