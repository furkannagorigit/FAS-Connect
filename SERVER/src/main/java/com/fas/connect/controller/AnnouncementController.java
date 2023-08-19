package com.fas.connect.controller;

import com.fas.connect.dto.AnnouncementDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.entity.Announcement;
import com.fas.connect.entity.Post;
import com.fas.connect.service.AnnouncementServiceImpl;
import com.fas.connect.service.PostServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    private final AnnouncementServiceImpl announcementServiceImpl;

    private PostServiceImpl postServiceImpl;
    
    @Autowired
    public AnnouncementController(AnnouncementServiceImpl AnnouncementServiceImpl) {
        this.announcementServiceImpl = AnnouncementServiceImpl;
    }

    @GetMapping
    public ResponseEntity<List<AnnouncementDTO>> getAllAnnouncements() {
        List<AnnouncementDTO> announcementDTOs = announcementServiceImpl.getAllAnnouncements();
        if (announcementDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(announcementDTOs);
    }
  
    @PostMapping("/addAnnouncement")
    public ResponseEntity<?> createAnnouncement(@RequestBody AnnouncementDTO announcementDTO) {
    	Post post = announcementDTO.getPost();
    	postServiceImpl.savePost(post);
    	return ResponseEntity.status(HttpStatus.CREATED).body(announcementServiceImpl.saveAnnouncement(announcementDTO));
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        announcementServiceImpl.deleteAnnouncement(id);
    }
}
