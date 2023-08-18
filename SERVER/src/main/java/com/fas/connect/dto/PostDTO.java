package com.fas.connect.dto;

import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Lob;

import org.springframework.format.annotation.DateTimeFormat;

import com.fas.connect.entity.PostType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private String text;
    private LocalDateTime createdAt;
    private PostType type;
}
