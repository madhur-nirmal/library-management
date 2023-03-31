package com.lib.transaction.service;

import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lib.transaction.entity.Transaction;
import com.lib.transaction.repository.TransactionRepository;


@Service
public class TransactionService {
	@Autowired
	private TransactionRepository transactionRepository;
	
	public Transaction getTransaction(int id) {
		Optional<Transaction> opObj= transactionRepository.findById(id);
		return opObj.get();
	}
	
	public void assignBook(Transaction trnObj) {
		if(Objects.nonNull(trnObj.getAmount()) &&  Objects.nonNull(trnObj.getBook_id()) && Objects.nonNull(trnObj.getUser_id()) 
				&& Objects.nonNull(trnObj.getLibrarian_id())) {
			transactionRepository.save(trnObj);
		}else {
			throw new RuntimeException("Please enter required information");
		}
	}
	
	public void completeTransaction(int id) {
		Optional<Transaction> opObj= transactionRepository.findById(id);
            Transaction trn=opObj.get();
            trn.setReturn_status(true);
            transactionRepository.save(trn);
	}
}
