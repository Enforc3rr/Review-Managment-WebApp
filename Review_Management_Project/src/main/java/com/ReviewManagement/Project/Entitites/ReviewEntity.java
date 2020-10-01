package com.ReviewManagement.Project.Entitites;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class ReviewEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;
	private String review;
	private String bookName;
	private String reviewAddedBy;
	
	public ReviewEntity() {
		
	}

	public ReviewEntity(String review, String bookName, String reviewAddedBy) {
		super();
		this.review = review;
		this.bookName = bookName;
		this.reviewAddedBy = reviewAddedBy;
	}

	public long getReviewId() {
		return reviewId;
	}

	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getReviewAddedBy() {
		return reviewAddedBy;
	}

	public void setReviewAddedBy(String reviewAddedBy) {
		this.reviewAddedBy = reviewAddedBy;
	}

	
	
	
}
