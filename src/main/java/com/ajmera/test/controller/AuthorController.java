package com.ajmera.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ajmera.test.dto.AuthorDto;
import com.ajmera.test.entity.Author;
import com.ajmera.test.service.AuthorService;

@RestController
@CrossOrigin
@RequestMapping(value = "api/")
public class AuthorController {

	@Autowired
	private AuthorService authorService;
	
	//create author
	@PostMapping("author")
	public ResponseEntity<Author> createAuthor(@RequestBody Author author)
	{
		Author createdAuthor = this.authorService.createAuthor(author);
		return new ResponseEntity<Author>(createdAuthor, HttpStatus.CREATED);
	}
	
	//update author
	@PutMapping("author/{authorId}")
	public ResponseEntity<Author> updateAuthor(@RequestBody Author author, @PathVariable Long authorId)
	{
		Author updatedAuthor = this.authorService.updateAuthor(author, authorId);
		return new ResponseEntity<Author>(updatedAuthor, HttpStatus.OK);
	}
	
	//get all authors
	@GetMapping("authors/{authorName}")
	public ResponseEntity<List<AuthorDto>> getAuthorsByName(@PathVariable String authorName)
	{
		List<AuthorDto> authors = this.authorService.getAuthorsByAuthorName(authorName);
		return new ResponseEntity<List<AuthorDto>>(authors, HttpStatus.OK);
	}
}
