package com.likelion.ktc.mysqljpabasics.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.likelion.ktc.mysqljpabasics.dto.StudentDto;
import com.likelion.ktc.mysqljpabasics.entity.Student;

@Mapper(componentModel = "spring")
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDtoList(List<Student> students);
    List<Student> toEntityList(List<StudentDto> studentDtos);
}
