package com.likelion.ktc.mysqljpabasics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.likelion.ktc.mysqljpabasics.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
} 