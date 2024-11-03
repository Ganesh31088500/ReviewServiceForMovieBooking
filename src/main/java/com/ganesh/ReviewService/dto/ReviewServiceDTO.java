package com.ganesh.ReviewService.dto;

public class ReviewServiceDTO {
	private Integer review_id;
	private int rating;
	private String feedback;
	public Integer getReview_id() {
		return review_id;
	}
	public void setReview_id(Integer review_id) {
		this.review_id = review_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	@Override
	public String toString() {
		return "ReviewService [review_id=" + review_id + ", rating=" + rating + ", feedback=" + feedback + "]";
	}
}
