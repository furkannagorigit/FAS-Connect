package com.fas.connect.service;

import java.util.List;

import com.fas.connect.dto.AnnouncementDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entity.Announcement;

public interface IAnnouncementService {

	public List<AnnouncementDTO> getAllAnnouncements(); 
	
	public AnnouncementDTO saveAnnouncement(AnnouncementDTO announcementDTO);
}
