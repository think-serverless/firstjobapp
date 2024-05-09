package com.practice.firstjobapp.review;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {
	
	private ReviewService reviewService;

	public ReviewController(ReviewService reviewService) {
		super();
		this.reviewService = reviewService;
	}
	
	
	@GetMapping("/reviews")
	public ResponseEntity<List<Review>> getAllReviews(@PathVariable Long companyId){
		return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
	}

	@PostMapping("/reviews")
	public ResponseEntity<String> createReviews(@PathVariable Long companyId, @RequestBody Review review){
		boolean iscreated = reviewService.createReview(companyId, review);
		
		if(iscreated) {
			return new ResponseEntity<>("Review Added Sccessfully", HttpStatus.ACCEPTED);
		}
		
		return new ResponseEntity<>("Review Not Found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/reviews/{reviewId}")
	public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId){
	
		Review review = reviewService.getAllReviews(companyId, reviewId);
		if(review != null) {
			return new ResponseEntity<>(review, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping("/reviews/{reviewId}")
	public ResponseEntity<String> updateReview(@PathVariable Long companyId, @PathVariable Long reviewId, @RequestBody Review updateReview){
		boolean isUpdated = reviewService.updateReview(companyId, reviewId,updateReview);
		if(isUpdated) {
			return new ResponseEntity<String>("Updated Successfiully", HttpStatus.OK);
		}
		return new ResponseEntity<String>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/reviews/{reviewId}")
	public ResponseEntity<String> deleteReview(@PathVariable Long companyId, @PathVariable Long reviewId){
		
		boolean isDeleted = reviewService.deleteReview(companyId, reviewId);
		if(isDeleted) {
			return new ResponseEntity<String>("Review Deleted Successfully", HttpStatus.OK);
		}
		return new ResponseEntity<String>("Review Not Found", HttpStatus.NOT_FOUND);
	}
}
