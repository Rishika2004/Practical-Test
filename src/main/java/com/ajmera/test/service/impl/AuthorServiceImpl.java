package com.ajmera.test.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ajmera.test.dto.AuthorDto;
import com.ajmera.test.dto.BookDto;
import com.ajmera.test.entity.Author;
import com.ajmera.test.entity.Book;
import com.ajmera.test.exception.ResourceNotFoundException;
import com.ajmera.test.repo.AuthorRepo;
import com.ajmera.test.service.AuthorService;

@Service
public class AuthorServiceImpl implements AuthorService{

	@Autowired
	AuthorRepo authorRepo;
	
	@Override
	public Author createAuthor(Author a) {
		return authorRepo.save(a);
	}

	@Override
	public Author updateAuthor(Author a, Long authorId) {
		Author ua = this.authorRepo.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("author", "author id", authorId+""));
		ua.setAuthorName(a.getAuthorName());
		authorRepo.save(ua);
		return ua;	
	}

	@Override
	public void deleteAuthor(Long authorId) {
		Author a = this.authorRepo.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("author", "author id", authorId+""));
		authorRepo.delete(a);
	}

	@Override
	public Author getAuthor(Long authorId) {
		Author a = this.authorRepo.findById(authorId).orElseThrow(() -> new ResourceNotFoundException("author", "author id", authorId+""));
		return a;
	}

	@Override
	public List<Author> getAuthors() {
		List<Author> authorList = this.authorRepo.findAll();
		return authorList;
	}

	@Override
	public List<AuthorDto> getAuthorsByAuthorName(String authorName)
	{
		List<Author> authors = this.authorRepo.findByAuthorNameLike(authorName+"%");
		List<AuthorDto> authDtos = new ArrayList<>();
		for(Author a : authors)
		{
			AuthorDto ad = new AuthorDto();
			ad.setAuthorName(a.getAuthorName());
			List<String> booksName = new ArrayList<>();
			for(Book b : a.getBooks())
				booksName.add(b.getBookName());
			ad.setBooksName(booksName);
			authDtos.add(ad);
		}
		return authDtos;
	}
}
