package com.ajmera.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajmera.test.dto.AuthorDto;
import com.ajmera.test.dto.BookDto;
import com.ajmera.test.entity.Book;
import com.ajmera.test.service.AuthorService;
import com.ajmera.test.service.BookService;

@RestController
@CrossOrigin
@RequestMapping(value = "api/")
public class BookController {

	@Autowired
	private BookService bookService;
	
	//create book
	@PostMapping("author/{authorId}/book")
	public ResponseEntity<Book> createBook(@RequestBody Book b, @PathVariable Long authorId)
	{
		Book createdBook = this.bookService.createBook(b, authorId);
		return new ResponseEntity<Book>(createdBook, HttpStatus.CREATED);
	}
	
	//get book
	@GetMapping("book/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable Long bookId)
	{
		Book b = this.bookService.getBook(bookId);
		return new ResponseEntity<Book>(b, HttpStatus.OK);
	}
	
	//get all books
	@GetMapping("books/{bookName}")
	public ResponseEntity<List<BookDto>> getBooksByName(@PathVariable String bookName)
	{
		List<BookDto> books = this.bookService.getBooksByBookName(bookName);
		return new ResponseEntity<List<BookDto>>(books, HttpStatus.OK);
	}
}