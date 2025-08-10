package com.likelion.ktc.mysqljpabasics.service;

import com.likelion.ktc.mysqljpabasics.dto.StudentDto;
import com.likelion.ktc.mysqljpabasics.entity.Student;
import com.likelion.ktc.mysqljpabasics.mapper.StudentMapper;
import com.likelion.ktc.mysqljpabasics.repository.StudentRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;
    private final StudentMapper mapper;

    public StudentServiceImpl(StudentRepository repository, StudentMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    @Override
    @Transactional
    public StudentDto createStudent(StudentDto dto) {

        if (dto.getName().equalsIgnoreCase("bad") 
        || dto.getName().equalsIgnoreCase("evil")) {
            throw new RuntimeException("Invalid student name");
        }

        Student student = mapper.toEntity(dto);
        return mapper.toDto(repository.save(student));
    }

    @Override
    @Transactional
    public StudentDto updateStudent(Long id, StudentDto dto) {
        Student student = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setPhone(dto.getPhone());
        student.setEmail(dto.getEmail());
        student.setAddress(dto.getAddress());

        return mapper.toDto(repository.save(student));
    }

    @Override
    @Transactional
    public void deleteStudent(Long id) {
        repository.deleteById(id);
    }
}