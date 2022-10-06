package com.dxc.learntoday.service;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dxc.learntoday.exception.LTANotFoundException;
import com.dxc.learntoday.model.Trainer;
import com.dxc.learntoday.repositary.TrainerRepositary;

@Service
public class TrainerService implements UserDetailsService {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainerService.class);
	
	@Autowired
	TrainerRepositary trainerRepositary;
	
	public void save(Trainer trainer) {
		try {
			logger.info("Get trainer save inside service method");
			trainerRepositary.save(trainer);
		} catch (Exception e) {
			throw new LTANotFoundException("trainer is not created");
		}

	}
	
	public void update(Trainer trainer, Integer trainerId) {
		try {
			logger.info("Get trainer update inside service method");
			trainerRepositary.save(trainer);
		} catch (Exception e) {
			throw new LTANotFoundException("Searched Data not found" + trainerId);
		}
	}

	@Override
	public UserDetails loadUserByUsername(String trainerId) throws UsernameNotFoundException {
		
		Trainer trainer = trainerRepositary.findByTrainerId(Integer.parseInt(trainerId));
		
		return new org.springframework.security.core.userdetails.User(trainer.getTrainerId()+"", trainer.getPassword(), new ArrayList<>());
	}


}
