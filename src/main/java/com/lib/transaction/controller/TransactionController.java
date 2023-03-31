package com.lib.transaction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lib.transaction.entity.Transaction;
import com.lib.transaction.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping (path="/get/{id}")
	public ResponseEntity<Transaction> getTransaction(@PathVariable int id) {
		try {
			return ResponseEntity.ok(transactionService.getTransaction(id));
		}catch(RuntimeException e) {
			throw new RuntimeException("Error getting transaction info");
		}
	}
	
	@PostMapping(path="/assignBook")
	public ResponseEntity<String> assignBook(@RequestBody Transaction trnObj) {
		try {
			transactionService.assignBook(trnObj);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		
		return ResponseEntity.ok("Book assignment successful!");
	}
	
	@PutMapping (path="/complete/{id}")
	public ResponseEntity<String> completeTransaction(@PathVariable int id) {
		try {
			transactionService.completeTransaction(id);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
		return ResponseEntity.ok("Book has been returned.");
	}
}
