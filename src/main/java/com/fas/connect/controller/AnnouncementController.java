package com.fas.connect.controller;


import com.fas.connect.dto.PostDTO;
import com.fas.connect.service.AnnouncementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {
	@Autowired
    private AnnouncementService announcementService;
  
    @GetMapping
    public ResponseEntity<List<PostDTO>> getAllAnnouncements() {
        List<PostDTO> announcementDTOs = announcementService.getAllAnnouncements();
        if (announcementDTOs.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.ok(announcementDTOs);
    }
     
    @PostMapping("/addAnnouncement/{userId}")
    public ResponseEntity<?> addAnnouncement(@RequestBody  PostDTO announcementDTO,@PathVariable Long userId) {
//        	System.out.println(announcementDTO.toString());
        	return ResponseEntity.status(HttpStatus.OK).body(announcementService.addAnnouncement(userId,announcementDTO));
    }

    @PutMapping("/editAnnouncement/{postId}")
    public ResponseEntity<?> editAnnouncement(@RequestBody  PostDTO announcementDTO,@PathVariable Long postId) {
    	System.out.println(announcementDTO.toString());
    	return ResponseEntity.status(HttpStatus.CREATED).body(announcementService.editAnnouncement(postId,announcementDTO));

    }
}