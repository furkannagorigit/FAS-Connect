package com.fas.connect.service;

import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.PostRequestDTO;
import com.fas.connect.entities.Announcement;
import com.fas.connect.entities.Feed;
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
    public List<PostRequestDTO> getAllAnnouncements() {
    	return announcementRepo.findAll().stream()
                .map(a -> {
                    PostRequestDTO post = modelMapper.map(a, PostRequestDTO.class);
                    return post;
                })
                .collect(Collectors.toList());
    }

	@Override
	public PostRequestDTO addAnnouncement(Long userId, PostRequestDTO announcementDTO) {
		Announcement announcement = modelMapper.map(announcementDTO, Announcement.class);
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		announcement.setCreatedBy(user);
		user.addPost(announcement);
		return modelMapper.map(announcementRepo.save(announcement), PostRequestDTO.class);
		
	}

	@Override
	public PostRequestDTO editAnnouncement(Long postId, PostRequestDTO announcementDTO) {
		Announcement announcement = announcementRepo.findById(postId)
				.orElseThrow(()-> new RuntimeException());
		
		User user = announcement.getCreatedBy();
		
		Post postInUser = user.getPosts().stream()
				.filter(myPost-> myPost.equals(announcement))
				.findFirst().orElseThrow();
		System.out.println("postInUser: "+postInUser.toString());

		user.deletePost(postInUser);
		modelMapper.map(announcementDTO, announcement);
		announcement.setId(postId);
		user.addPost((Post)announcement);
		System.out.println(user.getPosts());
		userRepo.save(user);
		return modelMapper.map(announcement, PostRequestDTO.class);
	}

	}

