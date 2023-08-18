package com.fas.connect.controller;

import com.fas.connect.entity.Announcement;
import com.fas.connect.service.AnnouncementServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/announcements")
public class AnnouncementController {

    private final AnnouncementServiceImpl AnnouncementServiceImpl;

    @Autowired
    public AnnouncementController(AnnouncementServiceImpl AnnouncementServiceImpl) {
        this.AnnouncementServiceImpl = AnnouncementServiceImpl;
    }

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return AnnouncementServiceImpl.getAllAnnouncements();
    }

    @PostMapping
    public Announcement createAnnouncement(@RequestBody Announcement announcement) {
        return AnnouncementServiceImpl.saveAnnouncement(announcement);
    }

    @DeleteMapping("/{id}")
    public void deleteAnnouncement(@PathVariable Long id) {
        AnnouncementServiceImpl.deleteAnnouncement(id);
    }
}
