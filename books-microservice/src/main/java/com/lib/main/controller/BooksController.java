package com.lib.main.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.main.entity.Books;
import com.lib.main.repository.BooksRepository;


@RestController
public class BooksController {
	
	@Autowired
	private BooksRepository booksRepository;
	
	
	@GetMapping("/allbooks")
	public List<Books> getallBooks(){
		return booksRepository.findAll();
	}
	
	@GetMapping("/books/{id}")
	 public ResponseEntity<Books> getBookById(@PathVariable Integer id) throws NotFoundException {
        Books book = booksRepository.findById(id).orElseThrow(() -> new NotFoundException());
        return ResponseEntity.ok(book);
    }
	
	@PostMapping("/book")
	public Books createBook(@RequestBody Books book) {
		return booksRepository.save(book);
	}
	
	@PutMapping("/books/{id}")
    public ResponseEntity<Books> updateBook(@PathVariable Integer id, @RequestBody Books bookDetails) throws NotFoundException {
        Books book = booksRepository.findById(id).orElseThrow(() -> new NotFoundException());

        book.setBookName(bookDetails.getBookName());
        book.setBookAuthor(bookDetails.getBookAuthor());
        book.setBookGenre(bookDetails.getBookGenre());
        book.setNoOfCopies(bookDetails.getNoOfCopies());
	book.setPublisher(bookDetails.getPublisher());
        book.setMain_genere_id(bookDetails.getMain_genere_id());
        book.setShelfId(bookDetails.getShelfId());

        Books updatedBook = booksRepository.save(book);
        return ResponseEntity.ok(updatedBook);
    }
	
	
	@DeleteMapping("/books/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteBook(@PathVariable Integer id) throws NotFoundException {
        Books book = booksRepository.findById(id).orElseThrow(() -> new NotFoundException());

        booksRepository.delete(book);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
	

}
