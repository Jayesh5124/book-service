package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.demo.dao.BookRepository;
import com.example.demo.model.Book;

@RestController
@RequestMapping("/api")
public class BookController {

	@Autowired
	BookRepository bookRepo;
	
	
	@GetMapping("/books")
	public List<Book> getAllBooks(){
		
		return this.bookRepo.findAll();
	}
	
	@GetMapping("/books/{bid}")
	public Book getABook(@PathVariable int bid){
		
		return this.bookRepo.findById(bid).get();
	}
	
	@PostMapping("/books")
	public Book addBook(@RequestBody Book newBook)
	{
		return this.bookRepo.saveAndFlush(newBook);
	}
	
	@DeleteMapping("/books/{bid}")
	public void deleteBook(@PathVariable int bid)
	{
		this.bookRepo.deleteById(bid);
		return;
	}
	
	
	
}
