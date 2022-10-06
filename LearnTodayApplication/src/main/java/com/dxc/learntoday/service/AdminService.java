package com.dxc.learntoday.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.learntoday.exception.LTANotFoundException;
import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.repositary.AdminRepositary;

@Service
public class AdminService {

	private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

	@Autowired
	AdminRepositary adminRepositary;

	public List<Course> getAllCources() {

		try {
			logger.info("Get Course inside service method");
			List<Course> course = new ArrayList<Course>();
			adminRepositary.findAll().forEach(noOfauthors -> course.add(noOfauthors));
			return course;
		} catch (Exception e) {
			throw new LTANotFoundException("No Course Found");
		}

	}
	
	public Course getCourseById(int id) {
		try {

			logger.info("Get course by id inside service method");
			return adminRepositary.findById(id).get();
		} catch (Exception e) {
			throw new LTANotFoundException("No course Found" + id);
		}
	}

}
