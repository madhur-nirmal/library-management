package com.lib.transaction.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lib.transaction.entity.Transaction;
import com.lib.transaction.repository.TransactionRepository;

@RestController
public class TransactionController {

	
	@Autowired
	TransactionRepository transactionRepository;
	
	@GetMapping (path="/transaction/get/{id}")
	public Transaction getTransaction(@PathVariable int id) {
		Optional<Transaction> opObj= transactionRepository.findById(id);
		
		return opObj.get();
	}
	
//	@GetMapping (path="/transaction/get")
//	public List<Transaction> getAllTransaction() {
//		List<Transaction> trnLst=transactionRepository.findAll();
//		
//		return trnLst;
//	}
	
	
	@PostMapping(path="/transaction/assignBook")
	public String assignBook(@RequestBody Transaction trnObj) {
			
		System.out.println("Received data:" +trnObj);
		
		transactionRepository.save(trnObj);
		
		return "Record inserted Successfully";
	}
	
	@PutMapping (path="/transaction/complete/{id}")
	public String completeTransaction(@PathVariable int id) {
		Optional<Transaction> opObj= transactionRepository.findById(id);
		if (opObj.isPresent()) {
			Transaction trn=opObj.get();
			trn.setReturn_status(true);
			transactionRepository.save(trn);

			return "Book has been returned";
		}
		
		return "unable to change transaction status";
		
	}
	
	
}
