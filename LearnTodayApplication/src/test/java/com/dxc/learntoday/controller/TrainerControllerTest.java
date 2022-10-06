package com.dxc.learntoday.controller;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dxc.learntoday.model.AuthRequest;
import com.dxc.learntoday.model.Trainer;
import com.dxc.learntoday.service.TrainerService;

@ExtendWith(MockitoExtension.class)
public class TrainerControllerTest {
	
	@InjectMocks
	TrainerController trainerCOntroller;
	
	@Mock
	TrainerService trainerService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	@Test
    public void testTrainerSingnUp() 
    {
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
        Trainer trainer = new Trainer();
        trainer.setTrainerId(101);
        trainer.setPassword("12345");
        ResponseEntity<String> responseEntity = trainerCOntroller.trainerSave(trainer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(201);
    }
	
	   @Test
	    public void testUpdateTrainer() 
	    {
	        MockHttpServletRequest request = new MockHttpServletRequest();
	        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	        Trainer trainer = new Trainer();
	        trainer.setTrainerId(101);
	        trainer.setPassword("12345");
	        ResponseEntity<String> responseEntity = trainerCOntroller.update(trainer, 1);
	        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(200);
	    }
}
