package com.lib.transaction.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lib.transaction.entity.Transaction;


public interface TransactionRepository extends JpaRepository<Transaction,Integer>{

}
