package com.rm.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class BookAddition{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long bookAdditionId;
	private long bookId;
	private long userId;
	public BookAddition() {
		
	}
	public BookAddition(long bookId, long userId) {
		super();
		this.bookId = bookId;
		this.userId = userId;
	}
	public long getBookAdditionId() {
		return bookAdditionId;
	}
	public void setBookAdditionId(long bookAdditionId) {
		this.bookAdditionId = bookAdditionId;
	}
	public long getBookId() {
		return bookId;
	}
	public void setBookId(long bookId) {
		this.bookId = bookId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	
}