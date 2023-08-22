package com.fas.connect.service;

import java.util.List;
import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostRequestDTO;
import com.fas.connect.entities.Announcement;

public interface AnnouncementService {

	public List<PostRequestDTO> getAllAnnouncements(); 
	public PostRequestDTO addAnnouncement (Long userId, PostRequestDTO feedDTO);
	public PostRequestDTO editAnnouncement(Long postId, PostRequestDTO announcementDTO);

	
}
