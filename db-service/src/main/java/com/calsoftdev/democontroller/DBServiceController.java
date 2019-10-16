package com.calsoftdev.democontroller;

import java.io.Console;
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

import com.calsoftdev.model.Student;
import com.calsoftdev.repository.DBserviceRepository;

@RestController
@RequestMapping("/db-service")
public class DBServiceController {
	
	private DBserviceRepository dbserviceRepository;

	public DBServiceController(DBserviceRepository dbserviceRepository) {
		super();
		this.dbserviceRepository = dbserviceRepository;
	}
	
	@GetMapping("/getstudent/{studentName}")
	@Cacheable("student")
	public List<Student> getName(@PathVariable("studentName") final String studentName) throws InterruptedException{
		return dbserviceRepository.findByStudentName(studentName);
				//.stream().map(Student::getStudentName).collect(Collectors.toList());
	}
	
	@PostMapping("/add")
	public ResponseEntity<Student> addStudentInfo(@RequestBody Student student){
		try {
			dbserviceRepository.save(student);
			return new ResponseEntity<Student>(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.GONE);
		}
	}
}
