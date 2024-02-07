package com.nyeong.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyeong.spring.ex.mybatis.domain.Review;
import com.nyeong.spring.ex.mybatis.service.ReviewService;

@Controller
@RequestMapping("/mybatis/review")
public class ReviewController {
	
	// autowired를 통해 객체를 주입
	@Autowired
	private ReviewService reviewService;
	
	// 전달된 id를 가진 리뷰 정보를 json으로 reponse에 담는다.
	// request parameter
	// /mybatis/review?id=3
	@ResponseBody
	@RequestMapping("/")
	public Review review(@RequestParam("id") int id) { // -> String id = request.getParameter("id");
		Review review = reviewService.getReview(id);
		return review;
		
	}
	
	// 리뷰 한 행을 추가하는 기능
	@RequestMapping("/insert")
	@ResponseBody
	public String createReview() {
		
		// 4, 치즈피자, 강수녕, 4.5, 치즈피자 존맛!
		//int count = reviewService.addReview(4, "치즈피자", "강수녕", 4.5, "치즈피자 존맛!");
		
		// 2, 뿌링클, 강수녕, 5.0, 역시 뿌링클은 진리즤
		Review review = new Review();
		review.setStoreId(2);
		review.setMenu("뿌링클");
		review.setUserName("강수녕");
		review.setPoint(5.0);
		review.setReview("역시 뿌링클은 진리즤");
		
		
		int count = reviewService.addReviewByObject(review);
		return "수행결과 : " + count;
	}
}
