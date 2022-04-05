package com.barclays.student.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.barclays.student.demo.dto.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
