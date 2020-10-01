package com.ReviewManagement.Project.Entitites;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookId;
	private String nameOfBook;
	private String authorOfBook;
	private String genreOfBook;
	private String bookAddedBy;
//	@OneToMany(mappedBy = "addedBy")
//	private List<UserEntity> users;
	public BookEntity() {
		
	}
	public BookEntity(String nameOfBook, String authorOfBook, String genreOfBook, String bookAddedBy) {
		super();
		this.nameOfBook = nameOfBook;
		this.authorOfBook = authorOfBook;
		this.genreOfBook = genreOfBook;
		this.bookAddedBy = bookAddedBy;
	}
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
	public String getNameOfBook() {
		return nameOfBook;
	}
	public void setNameOfBook(String nameOfBook) {
		this.nameOfBook = nameOfBook;
	}
	public String getAuthorOfBook() {
		return authorOfBook;
	}
	public void setAuthorOfBook(String authorOfBook) {
		this.authorOfBook = authorOfBook;
	}
	public String getGenreOfBook() {
		return genreOfBook;
	}
	public void setGenreOfBook(String genreOfBook) {
		this.genreOfBook = genreOfBook;
	}
	public String getBookAddedBy() {
		return bookAddedBy;
	}
	public void setBookAddedBy(String bookAddedBy) {
		this.bookAddedBy = bookAddedBy;
	}
	

}
