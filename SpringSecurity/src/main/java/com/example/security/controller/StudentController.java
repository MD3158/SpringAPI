package com.example.security.controller;

import com.example.security.entity.Student;
import com.example.security.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @RequestMapping("/")
    public String index(Model model){
        List<Student> students = studentService.getAllStudent();
        model.addAttribute("students", students);
        return "index";
    }

    @RequestMapping(value = "add")
    public String addUser(Model model){
        model.addAttribute("student", new Student());
        return "addUser";
    }
    @RequestMapping(value = "edit", method = RequestMethod.GET)
    public String editStudent(@RequestParam("id") Long studentId, Model model) {
        Optional<Student> studentEdit = studentService.findStudentById(studentId);
        studentEdit.ifPresent(student -> model.addAttribute("student", student));
        return "editUser";
    }
    @PostMapping(value = "save")
    public String save(Student student) {
        studentService.saveStudent(student);
        return "redirect:/";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteStudent(@RequestParam("id") Long studentId, Model model) {
        studentService.deleteStudent(studentId);
        return "redirect:/";
    }
}
