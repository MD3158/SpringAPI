package com.example.security.service;


import com.example.security.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
    List<Student> getAllStudent();

    void saveStudent(Student student);

    void deleteStudent(Long id);

    Optional<Student> findStudentById(Long id);
}