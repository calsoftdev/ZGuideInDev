package com.calsoftdev.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.calsoftdev.model.Mentor;

public interface DBServiceMentorRepository extends JpaRepository<Mentor, Integer>{
	public List<Mentor> findByMentorName(String mentorName);
}
