package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entities.Post;

public interface PostRepository extends JpaRepository<Post,Long> {

}