package com.practice.firstjobapp.review;

import java.util.List;

import org.springframework.stereotype.Service;

import com.practice.firstjobapp.company.Company;
import com.practice.firstjobapp.company.CompanyService;

@Service
public class ReviewServiceImpl implements ReviewService {
	
	private ReviewRepository reviewRepository;
	private CompanyService companyService;

	public ReviewServiceImpl(ReviewRepository reviewRepository, CompanyService companyService) {
		super();
		this.reviewRepository = reviewRepository;
		this.companyService = companyService;
	}

	@Override
	public List<Review> getAllReviews(Long companyId) {
		// TODO Auto-generated method stub
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews;
		
	}

	@Override
	public boolean createReview(Long companyId, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			reviewRepository.save(review);
			return true;
		}
		
		return false;
		
	}

	@Override
	public Review getAllReviews(Long companyId, Long reviewId) {
		// TODO Auto-generated method stub
		
		List<Review> reviews = reviewRepository.findByCompanyId(companyId);
		return reviews.stream().filter(review -> review.getId() == reviewId).findFirst().orElse(null);
	}

	@Override
	public boolean updateReview(Long companyId, Long reviewId, Review review) {
		// TODO Auto-generated method stub
		Company company = companyService.getCompanyById(companyId);
		if(company != null) {
			review.setCompany(company);
			review.setId(reviewId);
			reviewRepository.save(review);
			return true;
		}
		
		
		return false;
		
	}

	@Override
	public boolean deleteReview(Long companyId, Long reviewId) {
		if(companyService.getCompanyById(companyId) != null && reviewRepository.existsById(reviewId)) {
				Review review = reviewRepository.findById(reviewId).orElse(null);
				Company company = review.getCompany();
				company.getReviews().remove(review);
				review.setCompany(null);
				companyService.updateComapny(companyId, company);
				reviewRepository.deleteById(reviewId);
				return true;
		}
			
		return false;
		// TODO Auto-generated method stub
	}
	
	

}
