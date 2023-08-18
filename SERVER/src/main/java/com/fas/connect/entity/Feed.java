package com.fas.connect.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
public class Feed {
    @Id
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id")
    private Post post;

//    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL)
//    private Set<Like> likes = new HashSet<>();
//
//    @OneToMany(mappedBy = "feed", cascade = CascadeType.ALL) 
//    private List<Comment> comments = new ArrayList<>();

}
