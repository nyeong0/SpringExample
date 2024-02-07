package com.nyeong.spring.ex.mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyeong.spring.ex.mybatis.domain.Review;
import com.nyeong.spring.ex.mybatis.repository.ReviewRepository;

@Service
public class ReviewService {
	
	@Autowired
	private ReviewRepository reviewRepository;
	
	// 전달된 id(파라미터)를 가진 리뷰 정보를 돌려주는 기능
	
	public Review getReview(int id) {
		Review review= reviewRepository.selectReview(id);
		return review;
	}
	
	public int addReview(int storeId, String menu, String userName, double point, String review) {
		int count = reviewRepository.insertReview(storeId, menu, userName, point, review);
		return count;
	}
	
	public int addReviewByObject(Review review) {
		int count = reviewRepository.insertReviewByObject(review);
		return count;
	}
}
