package com.fas.connect.service;

import java.util.List;
import com.fas.connect.dto.PostDTO;

public interface AnnouncementService {

	public List<PostDTO> getAllAnnouncements(); 
	public PostDTO addAnnouncement (Long userId, PostDTO feedDTO);
	public PostDTO editAnnouncement(Long postId, PostDTO announcementDTO);

	
}