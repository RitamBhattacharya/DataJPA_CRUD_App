package com.wipro.service;

import java.util.List;
import java.util.Optional;

import com.wipro.entity.Student;

public interface IStudentService {
	//Insert Methods
	public Student insertOne(Student s);
	public List<Student> insertMany(List<Student> s);
	
	//Update Methods
	public Student updateOne(Student s);
	public List<Student> updateMany(List<Student> s);
	
	//Searching Method
	public Optional<Student> findById(Integer id);
	public boolean existsById(Integer id);
	public List<Student> findAll();
	public List<Student> findAllById(List<Integer> ids);
	public long count();
	
	//Delete Methods
	public void deleteById(Integer id);
	public void delete(Student s);
	public void deleteAllById(List<Integer> ids);
	public void deleteAll(List<Student> s);
	public void deleteAll();
}
