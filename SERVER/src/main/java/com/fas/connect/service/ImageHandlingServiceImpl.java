package com.fas.connect.service;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.UserRepository;


@Service
@Transactional
public class ImageHandlingServiceImpl implements ImageHandlingService {
	@Autowired
	private UserRepository userRepo;

	@Value("${folder.location}")
	private String folderLocation;

	@PostConstruct
	public void init() {
		System.out.println("in init " + folderLocation);
		File folder = new File(folderLocation);
		if (folder.exists()) {
			System.out.println("folder exists alrdy !");
		} else {
			// no --create a folder
			folder.mkdir();
			System.out.println("created a folder !");
		}
	}

	@Override
	public FeedDTO addImageInFeed(FeedDTO feedDTO,MultipartFile image)
	{
		String path = folderLocation.concat(feedDTO.getType()+image.getOriginalFilename());
		System.out.println(path);
		try
		{
		FileUtils.writeByteArrayToFile(new File(path), image.getBytes());
		}catch(IOException e)
		{
			throw new RuntimeException("image handling prob");
		}
		feedDTO.setFeedImg(path);
		return feedDTO;
	}
	
	@Override
	public ApiResponse uploadImage(Long userId, MultipartFile image){
		User user = userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("Invalid user ID!!!!"));
		String path = folderLocation.concat("User"+user.getFirstName()+user.getId());
		try
		{
		FileUtils.writeByteArrayToFile(new File(path), image.getBytes());
		}catch(IOException e)
		{
			throw new RuntimeException("image handling prob");
		}
		user.setProfileImg(path);
		return new ApiResponse("Image file uploaded successfully for user id " + userId);
	}

	
}
