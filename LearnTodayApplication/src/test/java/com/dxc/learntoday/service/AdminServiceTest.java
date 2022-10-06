package com.dxc.learntoday.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dxc.learntoday.model.Course;
import com.dxc.learntoday.repositary.AdminRepositary;

@ExtendWith(MockitoExtension.class)
public class AdminServiceTest {
	
	@InjectMocks
	AdminService adminService;
	
	@Mock
	AdminRepositary adminRepositary;
	
	@Test
	public void testGetAllCourse() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Course course = new Course();
		course.setCourseId(101);
		List<Course> responseEntity = adminService.getAllCources();
		assertThat(responseEntity);
	}

	@Test
	public void testGetAllAuthor1() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Course course = new Course();
		course.setCourseId(101);
		assertThat(course);
	}

}
