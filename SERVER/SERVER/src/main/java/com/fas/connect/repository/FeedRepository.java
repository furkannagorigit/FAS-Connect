package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entities.Feed;

public interface FeedRepository extends JpaRepository<Feed,Long> {
	
}