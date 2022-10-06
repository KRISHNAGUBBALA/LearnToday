package com.dxc.learntoday.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.learntoday.exception.LTANotFoundException;
import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.model.Student;
import com.dxc.learntoday.repositary.AdminRepositary;
import com.dxc.learntoday.repositary.StudentRepositary;

@Service
public class StudentService {
	
	private static final Logger logger = LoggerFactory.getLogger(StudentService.class);
	
	@Autowired
	StudentRepositary studentRepositary;
	
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
	
	public void save(Student student) {
		try {
			logger.info("Get Student save inside service method");
			studentRepositary.save(student);
		} catch (Exception e) {
			throw new LTANotFoundException("student enrollment is not created");
		}

	}
	
	public void delete(int id) {
		try {
			logger.info("Get student delete inside service method");
			studentRepositary.deleteById(id);
		} catch (Exception e) {
			throw new LTANotFoundException("student is not deleted" + id);
		}
	}

}
