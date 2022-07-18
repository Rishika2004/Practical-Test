package com.ajmera.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ajmera.test.entity.Author;
import com.ajmera.test.entity.Book;

public interface AuthorRepo extends JpaRepository<Author, Long> {

	public List<Author> findByAuthorNameLike(String authorName);
}
