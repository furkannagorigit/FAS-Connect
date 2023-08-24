package com.fas.connect.service;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Announcement;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.AnnouncementRepository;
import com.fas.connect.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnnouncementServiceImpl implements AnnouncementService{

	@Autowired
	private AnnouncementRepository announcementRepo;

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public List<PostDTO> getAllAnnouncements() {
		return announcementRepo.findAll().stream()
				.map(announcement -> {
					PostDTO post = modelMapper.map(announcement, PostDTO.class);
					post.setCreatedById(announcement.getCreatedBy().getId());
					post.setCreatedByName(announcement.getCreatedBy().getFirstName()+" "+announcement.getCreatedBy().getLastName());
					return post;
				})
				.collect(Collectors.toList());
	}

	@Override
	public PostDTO addAnnouncement(Long userId, PostDTO announcementDTO) {
		Announcement announcement = modelMapper.map(announcementDTO, Announcement.class);
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		announcement.setCreatedBy(user);
		user.addPost(announcement);
		return modelMapper.map(announcementRepo.save(announcement), PostDTO.class);

	}

	@Override
	public PostDTO editAnnouncement(Long postId, PostDTO announcementDTO) {
		Announcement announcement = announcementRepo.findById(postId)
				.orElseThrow(()-> new RuntimeException());

		User user = announcement.getCreatedBy();
		Post postInUser = user.getPosts().stream()
				.filter(myPost-> myPost.equals(announcement))
				.findFirst().orElseThrow();
		user.deletePost(postInUser);
		modelMapper.map(announcementDTO, announcement);
		announcement.setId(postId);
		user.addPost((Post)announcement);
		userRepo.save(user);
		return modelMapper.map(announcement, PostDTO.class);
	}



}
