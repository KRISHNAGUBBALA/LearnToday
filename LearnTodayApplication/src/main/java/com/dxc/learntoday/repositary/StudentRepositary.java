package com.dxc.learntoday.repositary;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dxc.learntoday.model.Student;

@Repository
public interface StudentRepositary extends CrudRepository<Student, Integer>{

}
