package com.fas.connect.dto;

import java.time.LocalDateTime;

import com.fas.connect.entities.PostType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDTO {
	private Long id;
	private String text;
	private LocalDateTime createdAt = LocalDateTime.now();
}
