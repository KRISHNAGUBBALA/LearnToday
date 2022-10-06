package com.dxc.learntoday.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.learntoday.model.Trainer;

@Repository
public interface TrainerRepositary extends CrudRepository<Trainer, Integer>{
	
	Trainer findByTrainerId(int trainerId);

}
