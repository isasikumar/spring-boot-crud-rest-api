package com.isasi.school.crud.springbootpostgresqlcrudrestapi.controller;

import com.isasi.school.crud.springbootpostgresqlcrudrestapi.bean.ResultDTO;
import com.isasi.school.crud.springbootpostgresqlcrudrestapi.model.Student;
import com.isasi.school.crud.springbootpostgresqlcrudrestapi.service.StudentService;
import com.isasi.school.crud.springbootpostgresqlcrudrestapi.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@GetMapping("")
	public ResponseEntity<?> getAllStudents() {
		return new ResponseEntity<>(new ResultDTO<>(studentService.getAllStudents(),
				"Students fetched successfully !!", true),HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(new ResultDTO<>(student,
				(student!=null)? "Students fetched successfully !" : "Student Not Found!", true),(student!=null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping("")
	public ResponseEntity<?> createStudent(@RequestBody Student reqstudent) {
		return new ResponseEntity<>(new ResultDTO<>( studentService.createStudent(reqstudent),
				"Student created successfully !", true),HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateStudent(@PathVariable("id") Long id, @RequestBody Student reqstudent) {
		Student student = studentService.updateStudent(id,reqstudent);
		return new ResponseEntity<>(new ResultDTO<>( student,
				(student!=null) ? "Student updated successfully !" : "Student Not Found", true),(student!=null) ?HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteStudentById(@PathVariable("id") Long id) {
		boolean isDeleted = studentService.deleteStudentById(id);
		return new ResponseEntity<>(new ResultDTO<>(isDeleted,
				(isDeleted) ? "Student Deleted successfully !" : "Student Not Found", true),(isDeleted) ?HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@GetMapping("search/{id}")
	public ResponseEntity<?> searchStudent(@PathVariable("id") String searchValue) {
		List<Student> student = studentService.searchStudent(searchValue);
		return new ResponseEntity<>(new ResultDTO<>(student,
				(student!=null)? "Students fetched successfully !" : "Student Not Found!", true),(student!=null) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

}
