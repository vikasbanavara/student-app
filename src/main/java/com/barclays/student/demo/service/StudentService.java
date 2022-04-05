package com.barclays.student.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.barclays.student.demo.dao.StudentDao;
import com.barclays.student.demo.dto.ResponseStructure;
import com.barclays.student.demo.dto.Student;

@Service
public class StudentService {

	@Autowired
	private StudentDao studentDao;
	
	public ResponseStructure<Student> saveStudent(Student student) {
		
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("Saved data");
		Student savedStudent = studentDao.saveStudent(student);
		responseStructure.setData(savedStudent);
		return responseStructure;
	}
	
	public ResponseStructure<Student> updateStudent(Student student) {
		
		Student existStudent = studentDao.getStudentById(student.getId());
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		if(existStudent != null) {
			Student updatedStudent = studentDao.updateStudent(student);
			responseStructure.setData(updatedStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist to updated");
		}
		
		return responseStructure;
	}
	
	public ResponseStructure<Student> getStudentById(int id) {
		Student existStudent = studentDao.getStudentById(id);
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		if(existStudent != null) {
			responseStructure.setData(existStudent);
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data updated");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist");
		}
		return responseStructure;
	}
	
	public ResponseStructure<Student> deleteStudentById(int id) {
		ResponseStructure<Student> responseStructure = new ResponseStructure<Student>();
		boolean res = studentDao.deleteStudentById(id);
		if(res) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("Student data deleted");
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("Student ID does not exist to delete");
		}
		return responseStructure;
	}
	
	public ResponseStructure<List<Student>> getAllStudnet() {
		ResponseStructure<List<Student>> responseStructure = new ResponseStructure<List<Student>>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setData(studentDao.getAll());
		responseStructure.setMessage("all student data");
		return responseStructure;
	}
}
