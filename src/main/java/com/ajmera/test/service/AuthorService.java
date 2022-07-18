package com.ajmera.test.service;

import java.util.List;

import com.ajmera.test.dto.AuthorDto;
import com.ajmera.test.entity.Author;
import com.ajmera.test.entity.Book;

public interface AuthorService {

	//create
	Author createAuthor(Author a);
		
	//update
	Author updateAuthor(Author a, Long authorId);
		
	//delete
	void deleteAuthor(Long authorId);
		
	//get
	Author getAuthor(Long authorId);
		
	//get All
	List<Author> getAuthors();

	List<AuthorDto> getAuthorsByAuthorName(String authorName);
		
}
