package com.calsoftdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.calsoftdev.model.Student;

public interface DBserviceStudentRepository extends JpaRepository<Student, Integer>{
	public List<Student> findByStudentName(String studentName);
	
	@Query("select s from Student s where s.studentSatResult > 800")
	public List<Student> getStudentNameByClassifiedBySAT();
}
