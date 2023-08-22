package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fas.connect.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}