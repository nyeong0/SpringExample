package com.nyeong.spring.ex.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyeong.spring.ex.mybatis.domain.Review;
import com.nyeong.spring.ex.mybatis.service.ReviewService;

@Controller
public class ReviewController {
	
	// autowired를 통해 객체를 주입
	@Autowired
	private ReviewService reviewService;
	
	// 전달된 id를 가진 리뷰 정보를 json으로 reponse에 담는다.
	// request parameter
	// /mybatis/review?id=3
	@ResponseBody
	@RequestMapping("/mybatis/review")
	public Review review(@RequestParam("id") int id) { // -> String id = request.getParameter("id");
		Review review = reviewService.getReview(id);
		return review;
		
	}

}
