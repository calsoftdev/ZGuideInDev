package com.calsoftdev.repository;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.calsoftdev.model.Student;

public interface DBserviceRepository extends JpaRepository<Student, Integer>{
	public List<Student> findByStudentName(String studentName);
}
