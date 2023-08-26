package com.fas.connect.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.fas.connect.entities.PostType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PostDTO {
	private String text;
    private LocalDateTime createdAt = LocalDateTime.now();
    private PostType type;
    private String createdByName;
    private Long createdById;
}