package com.isasi.school.crud.springbootpostgresqlcrudrestapi.service;

import com.isasi.school.crud.springbootpostgresqlcrudrestapi.model.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();
    public Student getStudentById(Long id);
    public Student createStudent(Student reqData);
    public Student updateStudent(Long id, Student reqData);
    public boolean deleteStudentById(Long id);
    public List<Student> searchStudent(String searchValue);
}
