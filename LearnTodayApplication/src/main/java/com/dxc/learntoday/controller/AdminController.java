package com.dxc.learntoday.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.service.AdminService;

@RestController
public class AdminController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	AdminService adminService;

	@GetMapping("/getAllCourses")
	public ResponseEntity<List<Course>> getAllCourses() {
		logger.info("Get All Course in controller");
		return new ResponseEntity<List<Course>>(adminService.getAllCources(), HttpStatus.OK);
	}

	@GetMapping("getCourseById/{courseId}")
	public ResponseEntity<Course> getCourseById(@PathVariable("courseId") int courseid) {
		logger.info("Get Course By id controller");
		return new ResponseEntity<Course>(adminService.getCourseById(courseid), HttpStatus.OK);
	}

}
