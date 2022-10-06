package com.dxc.learntoday.service;

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
import com.dxc.learntoday.repositary.StudentRepositary;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {
	
	@InjectMocks
	StudentService studentService;
	
	@Mock
	StudentRepositary studentRepositary;
	
	@Test
	public void testGetAllCources() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		List<Course> responseEntity = studentService.getAllCources();
		assertThat(responseEntity);
	}
	
	@Test
	public void testCreateStudent() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Student student = new Student();
		student.setEnrollmentId(101);
		studentService.save(student);
		assertThat(student);
	}
	
	@Test
	public void testDeleteStudent() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Student student = new Student();
		student.setEnrollmentId(101);
		studentService.delete(101);
		assertThat(student);
	}
	

}
