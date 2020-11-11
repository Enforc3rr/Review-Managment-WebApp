package com.rm.project.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reviews")
public class ReviewsEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long reviewId;
	private long reviewOfBookId;
	private long reviewAddedByUserId;
	private String review;
	public ReviewsEntity() {
		
	}
	public ReviewsEntity(long reviewOfBookId, long reviewAddedByUserId, String review) {
		super();
		this.reviewOfBookId = reviewOfBookId;
		this.reviewAddedByUserId = reviewAddedByUserId;
		this.review = review;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public long getReviewOfBookId() {
		return reviewOfBookId;
	}
	public void setReviewOfBookId(long reviewOfBookId) {
		this.reviewOfBookId = reviewOfBookId;
	}
	public long getReviewAddedByUserId() {
		return reviewAddedByUserId;
	}
	public void setReviewAddedByUserId(long reviewAddedByUserId) {
		this.reviewAddedByUserId = reviewAddedByUserId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	
}
