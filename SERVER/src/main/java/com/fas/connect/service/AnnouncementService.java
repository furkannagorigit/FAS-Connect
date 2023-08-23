package com.fas.connect.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.fas.connect.dto.PostDTO;

public interface AnnouncementService {

//	public List<PostDTO> getAllAnnouncements(); 
	public Page<PostDTO> getAllAnnouncements(Pageable pageable);
	public PostDTO addAnnouncement (Long userId, PostDTO feedDTO);
	public PostDTO editAnnouncement(Long postId, PostDTO announcementDTO);

	
}