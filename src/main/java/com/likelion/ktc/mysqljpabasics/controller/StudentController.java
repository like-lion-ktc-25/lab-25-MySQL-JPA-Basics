package com.likelion.ktc.mysqljpabasics.controller;

import com.likelion.ktc.mysqljpabasics.dto.StudentDto;
import com.likelion.ktc.mysqljpabasics.entity.Student;
import com.likelion.ktc.mysqljpabasics.service.StudentService;
import com.likelion.ktc.mysqljpabasics.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<StudentDto> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(studentService.getStudentById(id));

    }

    @PostMapping
    public StudentDto createStudent(@RequestBody StudentDto student) {
        return studentService.createStudent(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable(name = "id") Long id,
            @RequestBody StudentDto studentDetails) {
        StudentDto updated = studentService.updateStudent(id, studentDetails);
        if (updated == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable(name = "id") Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}