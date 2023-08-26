package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fas.connect.entities.QnA;

@Repository
public interface QnARepository extends JpaRepository<QnA,Long> {

}