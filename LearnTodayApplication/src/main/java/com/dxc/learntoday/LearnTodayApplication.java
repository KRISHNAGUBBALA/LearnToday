package com.dxc.learntoday;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dxc.learntoday.model.Trainer;
import com.dxc.learntoday.repositary.TrainerRepositary;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class LearnTodayApplication {

	@Autowired
	TrainerRepositary repositary;

	@PostConstruct
	public void initTrainer() {

		List<Trainer> trainers = Stream.of(new Trainer(1,101,"12345")).collect(Collectors.toList());
		repositary.saveAll(trainers);
		
		long count = repositary.count();
		System.out.println(count);
	}

	public static void main(String[] args) {
		SpringApplication.run(LearnTodayApplication.class, args);
	}

}
