package com.lib.main.entity;
import lombok.Builder;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Builder
@Entity
@Table(name="books")
public class Books {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String publisher;
	private Integer main_genere_id;
    private String bookGenre;
    private Integer noOfCopies;
    private Integer shelfId;
    
    
    
    
    
    
    

	public Books(Integer bookId, String bookName, String bookAuthor, String publisher, Integer main_genere_id,
			String bookGenre, Integer noOfCopies, Integer shelfId) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.main_genere_id = main_genere_id;
		this.bookGenre = bookGenre;
		this.noOfCopies = noOfCopies;
		this.shelfId = shelfId;
	}


	public Integer getBookId() {
		return bookId;
	}


	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}


	public String getBookName() {
		return bookName;
	}


	public void setBookName(String bookName) {
		this.bookName = bookName;
	}


	public String getBookAuthor() {
		return bookAuthor;
	}


	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}


	public String getBookGenre() {
		return bookGenre;
	}


	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}


	public Integer getNoOfCopies() {
		return noOfCopies;
	}


	public void setNoOfCopies(Integer noOfCopies) {
		this.noOfCopies = noOfCopies;
	}
	
	public String getPublisher() {
		return publisher;
	}


	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	public Integer getMain_genere_id() {
		return main_genere_id;
	}


	public void setMain_genere_id(Integer main_genere_id) {
		this.main_genere_id = main_genere_id;
	}


	public Integer getShelfId() {
		return shelfId;
	}


	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}


	public void borrowBook() {
        this.noOfCopies--;
    }

    public void returnBook() {
        this.noOfCopies++;
    }

}

