package com.dxc.learntoday.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dxc.learntoday.model.Student;
import com.dxc.learntoday.model.Trainer;
import com.dxc.learntoday.repositary.TrainerRepositary;

@ExtendWith(MockitoExtension.class)
public class TrainerServiceTest {
	
	@InjectMocks
	TrainerService trainerService;
	
	@Mock
	TrainerRepositary trainerRepositary;
	
	
	@Test
	public void testTrainerSingUp() throws Exception{
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Trainer trainer = new Trainer();
		trainer.setTrainerId(101);
		trainerService.save(trainer);
		assertThat(trainer);
	}
	
	@Test
	public void testUpdateAuthor() {
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
		Trainer trainer = new Trainer();
		trainer.setTrainerId(101);
		trainerService.update(trainer, 101);
		assertThat(trainer);
	}

}
