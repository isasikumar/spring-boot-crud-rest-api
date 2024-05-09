package com.isasi.school.crud.springbootpostgresqlcrudrestapi.repository;

import com.isasi.school.crud.springbootpostgresqlcrudrestapi.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
	List<Student> findByIdOrNameIgnoreCaseOrClassNameIgnoreCase(Long id, String name, String className);
}
