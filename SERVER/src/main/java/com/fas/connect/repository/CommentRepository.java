package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entities.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long>{

}
