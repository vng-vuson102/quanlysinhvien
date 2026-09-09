package com.example.quanlysinhvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/students")
public class StudentWebController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        model.addAttribute("newStudent", new Student());
        return "students";
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute("newStudent") Student student) {
        studentService.createStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable UUID id) {
        studentService.deleteStudent(id);
        return "redirect:/students";
    }
}