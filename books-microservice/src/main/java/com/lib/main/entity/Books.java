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
//    @GeneratedValue(strategy = GenerationType.AUTO)
	private String title;
    private Integer bookId;
    private String bookName;
    private String bookAuthor;
    private String publisher;
	private Integer main_genre_id;
    private String bookGenre;
    private Integer noOfCopies;
    private Integer shelfId;
    private Integer publication_year;
    private Integer price;
    private Integer popularity;
    private Integer available_copies;
    
    
    
    public Books() {
    	
    }

	
	
	public Books(String title, Integer bookId, String bookName, String bookAuthor, String publisher,
			Integer main_genre_id, String bookGenre, Integer noOfCopies, Integer shelfId, Integer publication_year,
			Integer price, Integer popularity, Integer available_copies) {
		super();
		this.title = title;
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
		this.main_genre_id = main_genre_id;
		this.bookGenre = bookGenre;
		this.noOfCopies = noOfCopies;
		this.shelfId = shelfId;
		this.publication_year = publication_year;
		this.price = price;
		this.popularity = popularity;
		this.available_copies = available_copies;
	}



	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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
	
	public Integer getMain_genre_id() {
		return main_genre_id;
	}


	public void setMain_genere_id(Integer main_genre_id) {
		this.main_genre_id = main_genre_id;
	}


	public Integer getShelfId() {
		return shelfId;
	}


	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}
	


	public Integer getPublication_year() {
		return publication_year;
	}




	public void setPublication_year(Integer publication_year) {
		this.publication_year = publication_year;
	}




	public Integer getPrice() {
		return price;
	}




	public void setPrice(Integer price) {
		this.price = price;
	}




	public Integer getPopularity() {
		return popularity;
	}




	public void setPopularity(Integer popularity) {
		this.popularity = popularity;
	}




	public Integer getAvailable_copies() {
		return available_copies;
	}




	public void setAvailable_copies(Integer available_copies) {
		this.available_copies = available_copies;
	}




	public void setMain_genre_id(Integer main_genre_id) {
		this.main_genre_id = main_genre_id;
	}




	public void borrowBook() {
        this.noOfCopies--;
    }

    public void returnBook() {
        this.noOfCopies++;
    }

}

