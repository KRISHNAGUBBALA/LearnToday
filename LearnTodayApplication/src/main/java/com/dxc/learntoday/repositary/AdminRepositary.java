package com.dxc.learntoday.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.learntoday.model.Course;

@Repository
public interface AdminRepositary extends CrudRepository<Course, Integer>{
	

}
