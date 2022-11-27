package com.example.springbootassignment.repository;

import com.example.springbootassignment.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Booksrepo extends JpaRepository<Books, Long> {
}
