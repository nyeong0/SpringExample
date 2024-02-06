package com.nyeong.spring.ex.mybatis.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.nyeong.spring.ex.mybatis.domain.Review;

@Mapper
public interface ReviewRepository {
	
	// '파라미터id'인 행 조회 리턴
	public Review selectReview(@Param("id") int id);
}
