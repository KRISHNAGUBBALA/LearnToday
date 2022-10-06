package com.dxc.learntoday.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.model.Student;
import com.dxc.learntoday.service.StudentService;
import com.dxc.learntoday.utill.JwtUtil;

@RestController
public class StudentController {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	
	@Autowired
	StudentService studentService;
	
	
	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses() {
		logger.info("Get All Course in controller");
		return new ResponseEntity<List<Course>>(studentService.getAllCources(), HttpStatus.OK);
	}
	
	@PostMapping("/enrollStudent")
	public ResponseEntity<String> enrollStudent(@RequestBody Student student) {
		studentService.save(student);
		logger.info("student is create reaches controller");
		return new ResponseEntity<>("Student created successfully",HttpStatus.CREATED);
	}
	
	@DeleteMapping("/delete/{enrollmentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("magazineid") int enrollmentId) {
		logger.info("Student is delete reaces controller");
		return new ResponseEntity<>("Sudent Deleted Successfully",HttpStatus.ACCEPTED);
	}
}
