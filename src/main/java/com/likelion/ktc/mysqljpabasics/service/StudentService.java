package com.likelion.ktc.mysqljpabasics.service;

import java.util.List;

import com.likelion.ktc.mysqljpabasics.dto.StudentDto;

public interface StudentService {
    List<StudentDto> getAllStudents();
    StudentDto getStudentById(Long id);
    StudentDto createStudent(StudentDto studentDto);
    StudentDto updateStudent(Long id, StudentDto studentDto);
    void deleteStudent(Long id);
}
