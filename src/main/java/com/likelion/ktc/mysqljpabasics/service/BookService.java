package com.likelion.ktc.mysqljpabasics.service;

import org.springframework.stereotype.Service;

import com.likelion.ktc.mysqljpabasics.entity.Book;
import com.likelion.ktc.mysqljpabasics.repository.BookRepository;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuditService auditService;

    public BookService(BookRepository bookRepository, AuditService auditService) {
        this.bookRepository = bookRepository;
        this.auditService = auditService;
    }

    public Book save(Book book) {
        return bookRepository.save(book);
    }

    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    public Book getById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Transactional
    public Book saveWithAudit(Book book) {
        Book savedBook = bookRepository.save(book);
        auditService.log("Book saved: " + savedBook.getTitle());

        // Simulate an error to demonstrate rollback
        if (book.getTitle().equalsIgnoreCase("error")) {
            throw new RuntimeException("Simulated error - transaction should roll back");
        }

        return savedBook;
    }
}
