package com.lib.transaction.entity;


import java.time.LocalDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="transaction")
public class Transaction {
	@Id
	int id;
	
	@Column(name="book_id")
	int book_id;
	
	@Column(name="user_id")
	int user_id;
	
	@Column(name="date")
	String date=LocalDate.now().toString();
	
	@Column(name="amount")
	int amount;
	
	@Column(name="return_status")
	boolean return_status;
	
	@Column(name="librarian_id")
	int librarian_id;
	
	Transaction(){}

	public Transaction(int id,int book_id, int user_id, int amount, int librarian_id) 
	{
		super();
		this.id=id;
		this.book_id = book_id;
		this.user_id = user_id;
		this.amount = amount;
		this.return_status = false;
		this.librarian_id = librarian_id;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate() {
		LocalDate myDate=LocalDate.now();
		
		this.date = myDate.toString();
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isReturn_status() {
		return return_status;
	}

	public void setReturn_status(boolean return_status) {
		this.return_status = return_status;
	}
	
	public int getLibrarian_id() {
		return librarian_id;
	}

	public void setLibrarian_id(int librarian_id) {
		this.librarian_id = librarian_id;
	}	
}
