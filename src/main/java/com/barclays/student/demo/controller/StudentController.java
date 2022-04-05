package com.barclays.student.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.barclays.student.demo.dto.ResponseStructure;
import com.barclays.student.demo.dto.Student;
import com.barclays.student.demo.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@PostMapping("/student")
	public ResponseStructure<Student> saveStudent(@RequestBody @Valid Student student) {
		return studentService.saveStudent(student);
	}
	
	
	@PutMapping("/student")
	public ResponseStructure<Student> updateStudent(@RequestBody Student student) {
		return studentService.updateStudent(student);
	}
	
	@GetMapping("/student")
	public  ResponseStructure<Student> getStudentById(@RequestParam int id) {
		return studentService.getStudentById(id);
	}
	
	@GetMapping("/student/all")
	public ResponseStructure<List<Student>> getALl() {
		return studentService.getAllStudnet();
	}
	
	
	@DeleteMapping("/student/{id}")
	public ResponseStructure<Student> deleteStudent(@PathVariable  int id) {
		return studentService.deleteStudentById(id);
	}
}
