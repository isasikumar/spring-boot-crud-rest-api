package com.isasi.school.crud.springbootpostgresqlcrudrestapi.service;


import com.isasi.school.crud.springbootpostgresqlcrudrestapi.model.Student;
import com.isasi.school.crud.springbootpostgresqlcrudrestapi.repository.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;


	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	public Student getStudentById(Long id) {
		return studentRepository.findById(id).orElse(null);
	}

	@Override
	public Student createStudent(Student reqData) {
		return studentRepository.save(reqData);
	}

	@Override
	public Student updateStudent(Long id, Student reqData) {
		Student student = studentRepository.findById(id).orElse(null);
		if(student!=null){
			if(reqData.getName()!=null){
				student.setName(reqData.getName());
			}
			if(reqData.getDob()!=null){
				student.setDob(reqData.getDob());
			}
			if(reqData.getDoj()!=null){
				student.setDoj(reqData.getDoj());
			}
			if(reqData.getClassName()!=null){
				student.setClassName(reqData.getClassName());
			}

			return  studentRepository.save(student);
		}

		return null;
	}

	@Override
	public boolean deleteStudentById(Long id) {
		Student student = studentRepository.findById(id).orElse(null);
		if(student!=null){
			studentRepository.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public List<Student> searchStudent(String searchValue) {
		Long id = Long.MIN_VALUE;
		try{
			id = Long.parseLong(searchValue);
		}catch (Exception e){
			System.out.println("Filter Not a Long Value");
		}
		return studentRepository.findByIdOrNameIgnoreCaseOrClassNameIgnoreCase(id,searchValue,searchValue);
	}
}
