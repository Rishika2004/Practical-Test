package com.ajmera.test.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmera.test.dto.BookDto;
import com.ajmera.test.entity.Author;
import com.ajmera.test.entity.Book;
import com.ajmera.test.exception.ResourceNotFoundException;
import com.ajmera.test.repo.AuthorRepo;
import com.ajmera.test.repo.BookRepo;
import com.ajmera.test.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepo bookRepo;
	
	@Autowired
	AuthorRepo authorRepo;
	
	@Override
	public Book createBook(Book b, long authorId) {
		Author a = this.authorRepo.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("author", "author id", authorId+""));
		b.setAuthor(a);
		return bookRepo.save(b);
	}

	@Override
	public Book getBook(Long bookId) {
		Book b = this.bookRepo.findById(bookId).orElseThrow(() -> new ResourceNotFoundException("book", "book id", bookId+""));
		return b;
	}

	
	@Override
	public List<Book> getBooks() {
		List<Book> bookList = this.bookRepo.findAll();
		return bookList;
	}
	
	@Override
	public List<BookDto> getBooksByBookName(String bookName)
	{
		List<Book> books = this.bookRepo.findByBookNameLike(bookName+"%");
		List<BookDto> bookDtos = new ArrayList<>();
		for(Book b : books)
		{
			BookDto bd = new BookDto();
			bd.setBookName(b.getBookName());
			bd.setAuthName(b.getAuthor().getAuthorName());
			bookDtos.add(bd);
		}
		return bookDtos;
	}
	
}
