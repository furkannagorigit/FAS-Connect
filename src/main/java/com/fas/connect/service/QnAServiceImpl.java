package com.fas.connect.service;


import com.fas.connect.dto.AnswerReqDTO;
import com.fas.connect.dto.ApiResponse;
import com.fas.connect.dto.CommentDTO;
import com.fas.connect.dto.FeedDTO;
import com.fas.connect.dto.PostDTO;
import com.fas.connect.dto.QnAResponseDTO;
import com.fas.connect.entities.Announcement;
import com.fas.connect.entities.Comment;
import com.fas.connect.entities.Faculty;
import com.fas.connect.entities.Feed;
import com.fas.connect.entities.Post;
import com.fas.connect.entities.QnA;
import com.fas.connect.entities.User;
import com.fas.connect.exception_handler.ResourceNotFoundException;
import com.fas.connect.repository.CommentRepository;
import com.fas.connect.repository.FacultyRepository;
import com.fas.connect.repository.QnARepository;
import com.fas.connect.repository.UserRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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
	private FacultyRepository facultyRepo;
	
	@Autowired
	private CommentRepository commentRepo;

    @Autowired
    private ModelMapper modelMapper;

	@Override
    public List<QnAResponseDTO> getAllQnAs() {
    	return qnARepo.findAll().stream()
            .map(post -> {
            	QnAResponseDTO qna = modelMapper.map(post, QnAResponseDTO.class);
            	if (post.getAnswerBy() != null) {
            		qna.setAnsweredByName(post.getAnswerBy().getUser().getFirstName() + " " + post.getAnswerBy().getUser().getLastName());
            	    qna.setAnsweredById(post.getAnswerBy().getUserId());
            	}
            	if (post.getCreatedBy() != null) {
            	    qna.setCreatedByName(post.getCreatedBy().getFirstName() + " " + post.getCreatedBy().getLastName());
            	    qna.setCreatedById(post.getCreatedBy().getId());
            	}
            	return qna;
            	})
            .collect(Collectors.toList());
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
		System.out.println(c.getPostId().getId()+" "+c.getUser().getId()+" "+c.getText());
		commentRepo.save(c);
		return new ApiResponse("commented");

	}


	@Override
	public ApiResponse uncommentQnA(Long commentId) {
		Comment c = commentRepo.findById(commentId).orElseThrow(() -> new ResourceNotFoundException("comment not found"));
		User foundUser = userRepo.findById(c.getUser().getId()).orElseThrow(() -> new ResourceNotFoundException("User not found"));
		QnA foundQnA = qnARepo.findById(c.getPostId().getId()).orElseThrow(() -> new ResourceNotFoundException("Post not found"));
		foundQnA.removeComment(c,foundUser);
		qnARepo.save(foundQnA);
		commentRepo.delete(c);

		return new ApiResponse("Post uncommented");

	}
	
	@Override
	public QnAResponseDTO addAnswer(Long qnaId, AnswerReqDTO answerReqDTO) {
		QnA qna = qnARepo.findById(qnaId).orElseThrow(()->new ResourceNotFoundException("Question not found"));
		Faculty faculty = facultyRepo.findById(answerReqDTO.getAnsweredById())
					.orElseThrow(()-> new ResourceNotFoundException("User not found"));
		qna.setAnswerBy(faculty);
		qna.setAnswer(answerReqDTO.getAnswer());
		return modelMapper.map(qnARepo.save(qna), QnAResponseDTO.class);
	}

	}
