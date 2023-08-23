package com.fas.connect.service;


import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.QnAResponseDTO;
import com.fas.connect.entities.Announcement;
import com.fas.connect.entities.Comment;
import com.fas.connect.entities.Feed;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.QnA;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.CommentRepository;
import com.fas.connect.repository.QnARepository;
import com.fas.connect.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class QnAServiceImpl implements QnAService{
	@Autowired
    private QnARepository qnARepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private CommentRepository commentRepo;

    @Autowired
    private ModelMapper modelMapper;

//    public List<QnAResponseDTO> getAllQnAs() {
//    	return qnARepo.findAll().stream()
//            .map(post -> modelMapper.map(post, QnAResponseDTO.class))
//            .collect(Collectors.toList());
//    }
    
    @Override
    public Page<QnAResponseDTO> getAllQnAs(Pageable pageable) {
        Page<QnA> qnAPage = qnARepo.findAll(pageable);
        return qnAPage.map(qna -> modelMapper.map(qna, QnAResponseDTO.class));
    }

	@Override
	public PostDTO addQnA(Long userId, PostDTO qnaDTO) {
			QnA qna = modelMapper.map(qnaDTO, QnA.class);
			User user = userRepo.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found"));
			qna.setCreatedBy(user);
			user.addPost(qna);
			return modelMapper.map(qnARepo.save(qna), PostDTO.class);
			
		}
	
	@Override
	public PostDTO editQnA(Long postId, PostDTO qnaDTO) {
		QnA qna = qnARepo.findById(postId)
				.orElseThrow(()-> new RuntimeException());
		User user = qna.getCreatedBy();

		Post postInUser = user.getPosts().stream()
				.filter(myPost-> myPost.equals(qna))
				.findFirst().orElseThrow();

		user.deletePost(postInUser);
		modelMapper.map(qnaDTO, qna);
		System.out.println(qna);
		qna.setId(postId);
		user.addPost((Post)qna);
		userRepo.save(user);
		return modelMapper.map(qna, PostDTO.class);
	}
	
	@Override
	public ApiResponse commentQnA(CommentDTO commentDTO) {
		User foundUser = userRepo.findById(commentDTO.getUserId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		QnA foundQnA = qnARepo.findById(commentDTO.getPostId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		Comment c = new Comment();
		c.setUser(foundUser);
		c.setPostId(foundQnA);
		c.setText(commentDTO.getText());
		foundQnA.addComment(c, foundUser);
		qnARepo.save(foundQnA);
		return new ApiResponse("commented");

	}


	@Override
	public ApiResponse uncommentQnA(Long commentId) {
//		Comment c = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment not found"));
//		User foundUser = userRepo.findById(c.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
//		QnA foundQnA = qnARepo.findById(c.getPostId().getId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
//		foundQnA.removeComment(c,foundUser);
//		qnARepo.save(foundQnA);
//		return new ApiResponse("Post uncommented");

		Comment c = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment not found"));
		User foundUser = userRepo.findById(c.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		QnA foundQnA = qnARepo.findById(c.getPostId().getId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		foundQnA.removeComment(c,foundUser);
		return new ApiResponse("Post disliked");
	}

	}
