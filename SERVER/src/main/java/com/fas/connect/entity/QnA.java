package com.fas.connect.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class QnA {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

    @Lob
    @Column(name = "answer")
    private String answer;

//    @OneToMany(mappedBy = "qna", cascade = CascadeType.ALL) // Apply cascading
//    private List<Comment> comments = new ArrayList<>();
//
//    @ManyToOne(cascade = CascadeType.ALL) 
//    private Faculty answerBy;

}


