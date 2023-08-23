package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fas.connect.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
