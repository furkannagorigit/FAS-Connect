package com.fas.connect.dto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import com.fas.connect.entities.Comment;
import com.fas.connect.entities.PostType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class QnAResponseDTO {
	private Long id;
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
	private final PostType type = PostType.QNA;
    private String answer;
    private Long answeredById;
    private String answeredByName;
	private String createdByName;
    private Long createdById;
	private List<Comment> comments = new ArrayList<Comment>();
}