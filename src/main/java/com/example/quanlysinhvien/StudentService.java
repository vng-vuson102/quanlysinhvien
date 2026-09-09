package com.example.quanlysinhvien;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(UUID id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy sinh viên với ID: " + id));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(UUID id, Student studentDetails) {
        Student student = getStudentById(id);
        student.setStudentCode(studentDetails.getStudentCode());
        student.setFullName(studentDetails.getFullName());
        student.setEmail(studentDetails.getEmail());
        student.setPhone(studentDetails.getPhone());
        student.setClassName(studentDetails.getClassName());
        return studentRepository.save(student);
    }

    public void deleteStudent(UUID id) {
        Student student = getStudentById(id);
        studentRepository.delete(student);
    }
}