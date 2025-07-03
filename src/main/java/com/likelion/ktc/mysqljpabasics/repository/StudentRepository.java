package com.likelion.ktc.mysqljpabasics.repository;

import com.likelion.ktc.mysqljpabasics.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
} 