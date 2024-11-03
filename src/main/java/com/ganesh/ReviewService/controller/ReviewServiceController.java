package com.ganesh.ReviewService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ganesh.ReviewService.dto.ReviewServiceDTO;
import com.ganesh.ReviewService.exception.ReviewServiceException;
import com.ganesh.ReviewService.service.ReviewServiceImpl;

@RestController
public class ReviewServiceController {

	
	@Autowired
	private ReviewServiceImpl impl;
	@Autowired
	Environment environment;
	
	@PostMapping("/reviews")
	public ResponseEntity<String> addReview(@RequestBody ReviewServiceDTO dto) throws ReviewServiceException{
		Integer reviewId=impl.addReviewService(dto);
		String message=environment.getProperty("Review added successfully")+reviewId;
		return new ResponseEntity<String>(message,HttpStatus.CREATED);
	}
	@GetMapping("/reviews/{id}")
	public ResponseEntity<String> getReviewById(Integer id) throws ReviewServiceException{
		ReviewServiceDTO reviewId=impl.getReviewById(id);
		String message=environment.getProperty("Getting ready Review");
		return new ResponseEntity<String>(message,HttpStatus.OK);
	}
	@GetMapping("/reviews")
	public ResponseEntity<List<ReviewServiceDTO>> getAllReviews() throws ReviewServiceException{
	List<ReviewServiceDTO>	 dto=impl.getAllReviews();
	//String messge=environment.getProperty("Getting all the reviws");
	return new ResponseEntity<>(dto,HttpStatus.OK);
	}
	

}
