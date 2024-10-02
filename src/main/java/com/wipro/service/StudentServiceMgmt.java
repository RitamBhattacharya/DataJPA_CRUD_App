package com.wipro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.dao.StudentRepository;
import com.wipro.entity.Student;

@Service
public class StudentServiceMgmt implements IStudentService {

	@Autowired
	private StudentRepository repo;

	// Insert Methods
	@Override
	public Student insertOne(Student s) {
		return repo.save(s);
	}

	@Override
	public List<Student> insertMany(List<Student> s) {
		return (List<Student>) repo.saveAll(s);
	}

	// Update Methods
	@Override
	public Student updateOne(Student s) {
		return repo.save(s);
	}

	@Override
	public List<Student> updateMany(List<Student> s) {
		return (List<Student>) repo.saveAll(s);
	}

	// Searching Methods
	@Override
	public Optional<Student> findById(Integer id) {
		return repo.findById(id);
	}

	@Override
	public List<Student> findAllById(List<Integer> ids) {
		return (List<Student>) repo.findAllById(ids);
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>) repo.findAll();
	}

	@Override
	public boolean existsById(Integer id) {
		return repo.existsById(id);
	}

	@Override
	public long count() {
		return repo.count();
	}

	// Delete Methods
	@Override
	public void deleteById(Integer id) {
		repo.deleteById(id);
	}

	@Override
	public void deleteAllById(List<Integer> ids) {
		repo.deleteAllById(ids);
	}

	@Override
	public void deleteAll(List<Student> s) {
		repo.deleteAll(s);
	}

	@Override
	public void delete(Student s) {
		repo.delete(s);
	}

	@Override
	public void deleteAll() {
		repo.deleteAll();
	}
}
