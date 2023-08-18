package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fas.connect.entity.Announcement;

public interface AnnouncementRepository extends JpaRepository<Announcement,Long> {

}
