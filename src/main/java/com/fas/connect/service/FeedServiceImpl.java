package com.fas.connect.service;

import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.FeedResponseDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.entities.Comment;
import com.fas.connect.entities.Feed;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.CommentRepository;
import com.fas.connect.repository.FeedRepository;
import com.fas.connect.repository.PostRepository;
import com.fas.connect.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
@Service
@Transactional
public class FeedServiceImpl implements FeedService{


	@Autowired
	private CommentRepository commentRepo;

	@Autowired
	private FeedRepository feedRepo;
	@Autowired
	private UserRepository userRepo;
	@PersistenceContext
	private EntityManager entityManager;


	@Autowired
	private ModelMapper modelMapper;

//	public List<FeedResponseDTO> getAllFeeds() {
//	    return feedRepo.findAll().stream()
//	        .map(feed -> {
//	            FeedResponseDTO f = new FeedResponseDTO();
//	            f.setId(feed.getId());
//	            f.setFeed(modelMapper.map(feed, FeedDTO.class));
//	            f.setLikes((int) feed.getLikes().size());
//	            f.setComments(feed.getComments());
//	            return f;
//	        })
//	        .collect(Collectors.toList());
//	}

	@Override
    public Page<FeedResponseDTO> getAllFeeds(Pageable pageable) {
        Page<Feed> feedPage = feedRepo.findAll(pageable);
        return feedPage.map(feed -> {
            FeedResponseDTO f = new FeedResponseDTO();
            f.setId(feed.getId());
            f.setFeed(modelMapper.map(feed, FeedDTO.class));
            f.setLikes((int) feed.getLikes().size());
            f.setComments(feed.getComments());
            f.setCreatedById(feed.getCreatedBy().getId());
            f.setCreatedByName(feed.getCreatedBy().getFirstName()
            					+" "+ feed.getCreatedBy().getLastName());
            return f;
        });
    }
	
	@Override
	public FeedDTO addFeed(Long userId, FeedDTO feedDTO) {
		Feed feed = modelMapper.map(feedDTO, Feed.class);
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found"));
		feed.setCreatedBy(user);
		user.addPost(feed);
		return modelMapper.map(feedRepo.save(feed), FeedDTO.class);
	}

	@Override
	public FeedDTO editFeed(Long postId, FeedDTO feedDTO) {
		Feed feed = feedRepo.findById(postId)
				.orElseThrow(()-> new RuntimeException());
		User user = feed.getCreatedBy();

		Post postInUser = user.getPosts().stream()
				.filter(myPost-> myPost.equals(feed))
				.findFirst().orElseThrow();

		user.deletePost(postInUser);
		modelMapper.map(feedDTO, feed);
		feed.setId(postId);
		user.addPost((Post)feed);
		return modelMapper.map(feed, FeedDTO.class);
	}

	public void deleteFeed(Long id) {
		feedRepo.deleteById(id);
	}

	@Override
	public FeedResponseDTO getFeedbyId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public ApiResponse likeFeed(Long user, Long feed) {
		User foundUser = userRepo.findById(user).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Feed foundFeed = feedRepo.findById(feed).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		foundFeed.addLike(foundUser);
		return new ApiResponse("Post liked");

	}


	@Override
	public ApiResponse disLikeFeed(Long user, Long feed) {
		User foundUser = userRepo.findById(user).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Feed foundFeed = feedRepo.findById(feed).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		foundFeed.removeLike(foundUser);
		return new ApiResponse("Post disliked");

	}

	@Override
	public ApiResponse commentFeed(CommentDTO commentDTO) {
		User foundUser = userRepo.findById(commentDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Feed foundFeed = feedRepo.findById(commentDTO.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		Comment c = new Comment();
		c.setUser(foundUser);
		c.setPostId(foundFeed);
		c.setText(commentDTO.getText());
		foundFeed.addComment(c, foundUser);
		commentRepo.save(c);
		return new ApiResponse("commented");

	}


	@Override
	public ApiResponse uncommentFeed(Long commentId) {
		Comment c = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment not found"));
		User foundUser = userRepo.findById(c.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		Feed foundFeed = feedRepo.findById(c.getPostId().getId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		foundFeed.removeComment(c,foundUser);
		return new ApiResponse("Post disliked");

	}

}