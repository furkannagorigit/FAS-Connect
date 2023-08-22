package com.fas.connect.dto;

import java.time.LocalDate;
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
    private LocalDate createdAt;
    private PostType type;
}