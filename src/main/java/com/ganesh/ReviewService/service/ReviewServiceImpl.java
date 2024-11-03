package com.ganesh.ReviewService.service;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ganesh.ReviewService.dto.ReviewServiceDTO;
import com.ganesh.ReviewService.entity.ReviewService;
import com.ganesh.ReviewService.exception.ReviewServiceException;
import com.ganesh.ReviewService.repository.ReviewServiceRepository;

@Service
public class ReviewServiceImpl {

	@Autowired
	ReviewServiceRepository repository;
	@Autowired
	private ModelMapper mapper;
	
	public Integer addReviewService(ReviewServiceDTO reviewService) throws ReviewServiceException{

	ReviewService review=new ReviewService();
	review.setReview_id(reviewService.getReview_id());
	review.setRating(reviewService.getRating());
	review.setFeedback(reviewService.getFeedback());
	ReviewService reviewService2=repository.save(review);
	return reviewService2.getReview_id();
	}
	public ReviewServiceDTO getReviewById(Integer id) throws ReviewServiceException{
		ReviewService reviewService=repository.findById(id).get();
		ReviewServiceDTO dto=mapper.map(reviewService, ReviewServiceDTO.class);
		return dto;
		
	}
	public List<ReviewServiceDTO>  getAllReviews() throws ReviewServiceException{
		Iterable<ReviewService> review=repository.findAll();
		List<ReviewServiceDTO> dtos=new ArrayList<ReviewServiceDTO>();
		review.forEach( t -> {
			ReviewServiceDTO dto=new ReviewServiceDTO();
			dto.setReview_id(t.getReview_id());
			dto.setRating(t.getRating());
			dto.setFeedback(t.getFeedback());
			dtos.add(dto);
		});
		return dtos;
	}
	
	
}
