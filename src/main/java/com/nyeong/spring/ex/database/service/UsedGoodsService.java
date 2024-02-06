package com.nyeong.spring.ex.database.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyeong.spring.ex.database.domain.UsedGoods;
import com.nyeong.spring.ex.database.repository.UsedGoodsRepository;

// 로직(buisness) 수행 담당
// 기능 담당
// service -> repository
@Service
public class UsedGoodsService {
	
	// 객체생성을 스프링이 해줌
	// 멤버변수먼저 생성
	@Autowired
	private UsedGoodsRepository usedGoodsRepository;
	// 중고물품 게시글 리스트
	public List<UsedGoods> getUsedGoodsList() {
		
		List<UsedGoods> usedGoodsList = usedGoodsRepository.selectUsedGoodsList();
		return usedGoodsList;
	}
	
}
