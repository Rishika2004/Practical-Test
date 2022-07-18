package com.ajmera.test.service;

import java.util.List;

import com.ajmera.test.dto.BookDto;
import com.ajmera.test.entity.Book;

public interface BookService {

	//create
	Book createBook(Book b, long authorId);
				
	//get
	Book getBook(Long bookId);
			
	//get All
	List<Book> getBooks();

	List<BookDto> getBooksByBookName(String bookName);
}
