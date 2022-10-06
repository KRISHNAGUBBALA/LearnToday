package com.dxc.learntoday.controller;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.model.Student;
import com.dxc.learntoday.service.StudentService;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

	@InjectMocks
	StudentController studentController;

	@Mock
	StudentService studentService;

	@Test
	public void testGetAllCources() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		ResponseEntity<List<Course>> responseEntity = studentController.getAllCourses();
		assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	 @Test
	    public void testCreateStudent() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	        Student student = new Student();
	        student.setEnrollmentId(1);
	        student.setStudentId(101);
	        ResponseEntity<String> responseEntity = studentController.enrollStudent(student);
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
	    }
	 
	 @Test
	    public void testDeleteStudent() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	        Student student = new Student();
	        student.setEnrollmentId(1);
	        student.setStudentId(101);
	        ResponseEntity<String> responseEntity = studentController.deleteStudent(1);
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
	    }

}
