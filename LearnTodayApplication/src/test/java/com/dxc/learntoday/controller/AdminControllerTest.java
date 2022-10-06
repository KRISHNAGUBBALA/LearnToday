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
import com.dxc.learntoday.service.AdminService;

@ExtendWith(MockitoExtension.class)
public class AdminControllerTest {
	
	@InjectMocks
	AdminController adminController;
	
	@Mock
	AdminService adminService;
	
	
	@Test
	public void testGetAllCources() {
		MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        ResponseEntity<List<Course>> responseEntity = adminController.getAllCourse();
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	}
	
	@Test
    public void testGetByIdCourse() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Course course = new Course();
        course.setCourseId(1);
        ResponseEntity<Course> responseEntity = adminController.getCourseById(1);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
    }

}
