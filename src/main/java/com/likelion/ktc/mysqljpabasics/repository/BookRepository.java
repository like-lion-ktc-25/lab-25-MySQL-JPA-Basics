package com.likelion.ktc.mysqljpabasics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.likelion.ktc.mysqljpabasics.entity.Book;
public interface BookRepository extends JpaRepository<Book, Long> {
}

