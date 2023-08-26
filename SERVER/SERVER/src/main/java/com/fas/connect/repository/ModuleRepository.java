package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fas.connect.entities.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Long>{

}
