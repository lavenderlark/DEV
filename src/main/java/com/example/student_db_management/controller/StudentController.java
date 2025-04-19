package com.example.student_db_management.controller;

import com.example.student_db_management.domain.Student;
import com.example.student_db_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    
    @Autowired
    private StudentService studentService;

    @GetMapping("/form")
    public String showForm(Model model)
    {
        model.addAttribute("student", new Student());
        return "form";
    }
    
    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("student") Student student, Model model){
        studentService.saveStudent(student);
        model.addAttribute("message", "Student saved successfully!");
        return "success";
    }

    @GetMapping("/list")
    public String listStudents(Model model)
    {
        model.addAttribute("students", studentService.getAllStudents());
        return "list";
    }

}
