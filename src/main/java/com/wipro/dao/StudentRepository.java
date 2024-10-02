package com.wipro.dao;

import org.springframework.data.repository.CrudRepository;

import com.wipro.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
	
}
