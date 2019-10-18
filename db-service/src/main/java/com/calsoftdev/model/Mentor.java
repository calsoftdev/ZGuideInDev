package com.calsoftdev.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table
public class Mentor {
	
	  	@Id
	  	@GeneratedValue(strategy =  GenerationType.AUTO)
	    private int mentorId;
	  	private String mentorName;
	  	private String mentorQualification;
	  	private String mentorAbout;
	  	private String mentorExperience;
	  	
	  	@OneToMany(cascade = CascadeType.ALL)
	  	@JoinColumn(name = "mentorId")
	  	private List<Student> student;
	  	
		public int getMentorId() {
			return mentorId;
		}
		public void setMentorId(int mentorId) {
			this.mentorId = mentorId;
		}
		public List<Student> getStudent() {
			return student;
		}
		public void setStudent(List<Student> student) {
			this.student = student;
		}
		public String getMentorName() {
			return mentorName;
		}
		public void setMentorName(String mentorName) {
			this.mentorName = mentorName;
		}
		public String getMentorQualification() {
			return mentorQualification;
		}
		public void setMentorQualification(String mentorQualification) {
			this.mentorQualification = mentorQualification;
		}
		public String getMentorAbout() {
			return mentorAbout;
		}
		public void setMentorAbout(String mentorAbout) {
			this.mentorAbout = mentorAbout;
		}
		public String getMentorExperience() {
			return mentorExperience;
		}
		public void setMentorExperience(String mentorExperience) {
			this.mentorExperience = mentorExperience;
		}
}
