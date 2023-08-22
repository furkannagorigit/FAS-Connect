package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fas.connect.entities.Announcement;

@Repository
public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

}