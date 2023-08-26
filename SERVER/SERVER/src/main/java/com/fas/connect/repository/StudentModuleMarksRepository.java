package com.fas.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fas.connect.entities.StudentModuleMark;

@Repository
public interface StudentModuleMarksRepository extends JpaRepository<StudentModuleMark, Long> {

}