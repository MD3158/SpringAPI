package com.example.security.service;

import com.example.security.entity.Student;
import com.example.security.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired private StudentRepository userRepository;

    @Override
    public List<Student> getAllStudent() {
        return (List<Student>) userRepository.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        userRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findStudentById(Long id) {
        return userRepository.findById(id);
    }
}