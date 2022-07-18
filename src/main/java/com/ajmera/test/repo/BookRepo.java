package com.ajmera.test.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ajmera.test.entity.Book;

public interface BookRepo extends JpaRepository<Book, Long>{

	public List<Book> findByBookNameLike(String bookName);
}
