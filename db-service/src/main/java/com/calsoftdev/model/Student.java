package com.calsoftdev.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "STUDENT_ID")
	private Integer studentId;
	
	@Column(name = "STUDENT_NAME")
	private String studentName;
	
	
	@Column(name = "STUDENT_SCHOOL_NAME")
	private String studentSchoolName;
	
	@Column(name = "STUDENT_SAT_RESULT")
	private String studentSatResult;
	
	@Column(name = "STUDENT_PARENT_INFO")
	private String studentParentInfo;
	
	private int mentorId;


	public int getMentorId() {
		return mentorId;
	}

	public void setMentorId(int mentorId) {
		this.mentorId = mentorId;
	}

	public Student() {
		super();
	}
	
	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentSchoolName() {
		return studentSchoolName;
	}

	public void setStudentSchoolName(String studentSchoolName) {
		this.studentSchoolName = studentSchoolName;
	}

	public String getStudentSatResult() {
		return studentSatResult;
	}

	public void setStudentSatResult(String studentSatResult) {
		this.studentSatResult = studentSatResult;
	}

	public String getStudentParentInfo() {
		return studentParentInfo;
	}

	public void setStudentParentInfo(String studentParentInfo) {
		this.studentParentInfo = studentParentInfo;
	}
	
}
