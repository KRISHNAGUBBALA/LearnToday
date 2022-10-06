package com.dxc.learntoday.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dxc.learntoday.model.AuthRequest;
import com.dxc.learntoday.model.Trainer;
import com.dxc.learntoday.service.TrainerService;
import com.dxc.learntoday.utill.JwtUtil;

@RestController
public class TrainerController {
	
	private static final Logger logger = LoggerFactory.getLogger(TrainerController.class);
	
	@Autowired
	TrainerService trainerService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JwtUtil jwtUtil;
	
	
	@PostMapping("/trainerSingUp")
	public ResponseEntity<String> trainerSave(@RequestBody Trainer trainer) {
		trainerService.save(trainer);
		logger.info("trainerService is create reaches controller");
		return new ResponseEntity<>("Trainer is created Successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/updatePassword/{trainerId}")
	public ResponseEntity<String> update(@RequestBody Trainer trainer,Integer trainerId) {
		trainerService.update(trainer, trainerId);
		logger.info("trainer is Update reaces controller");
		return new ResponseEntity<>("Password is Updated Successfully",HttpStatus.OK);
	}
	
	@PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getTrainerId(), authRequest.getPassword())
            );
        } catch (Exception ex) {
            throw new Exception("invalid userId/password");
        }
        return jwtUtil.generateToken(authRequest.getTrainerId()+"");
    }

}
