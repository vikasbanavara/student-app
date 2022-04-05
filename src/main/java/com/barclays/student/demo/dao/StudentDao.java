package com.barclays.student.demo.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.barclays.student.demo.dto.Student;
import com.barclays.student.demo.repository.StudentRepository;

@Repository
public class StudentDao {
	
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	
	public List<Student> getAll() {
		return studentRepository.findAll();
	}
	
	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		return null;
	} 
	
	public boolean deleteStudentById(int id) {
		Student student = getStudentById(id);
		if(student!=null) {
			studentRepository.delete(student);
			return true;
		} 
		return false;
	}
}
