package com.calsoftdev.democontroller;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calsoftdev.model.Mentor;
import com.calsoftdev.model.Student;
import com.calsoftdev.repository.DBServiceMentorRepository;
import com.calsoftdev.repository.DBserviceStudentRepository;

@RestController
@RequestMapping("/db-service")
public class DBServiceController {
	
	private DBserviceStudentRepository dbserviceStudentRepository;
	
	private DBServiceMentorRepository dbServiceMentorRepository;


	public DBServiceController(DBserviceStudentRepository dbserviceStudentRepository,
			DBServiceMentorRepository dbServiceMentorRepository) {
		super();
		this.dbserviceStudentRepository = dbserviceStudentRepository;
		this.dbServiceMentorRepository = dbServiceMentorRepository;
	}

	@GetMapping("/getstudent/{studentName}")
	@Cacheable("student")
	public List<Student> getName(@PathVariable("studentName") final String studentName) throws InterruptedException{
		return dbserviceStudentRepository.findByStudentName(studentName);
				//.stream().map(Student::getStudentName).collect(Collectors.toList());
	}
	
	@PostMapping("/addstudent")
	public ResponseEntity<Student> addStudentInfo(@RequestBody Student student){
		try {
			dbserviceStudentRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
	
	@GetMapping("/classifiedbysat")
	public List<Student> getStudentNameByClassifiedBySAT(){
		return dbserviceStudentRepository.getStudentNameByClassifiedBySAT();
	}
	
	@PostMapping("/addmentor")
	public ResponseEntity<Mentor> addMentorInfo(@RequestBody Mentor mentor){
		try {
			dbServiceMentorRepository.save(mentor);
			return new ResponseEntity<Mentor>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
	
	@GetMapping("/getmentor/{mentorname}")
	@Cacheable("student")
	public List<Mentor> getMentorName(@PathVariable("mentorname") final String mentorName) throws InterruptedException{
		return dbServiceMentorRepository.findByMentorName(mentorName);
	}
}
