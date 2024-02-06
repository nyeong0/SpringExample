package com.nyeong.spring.ex.database;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyeong.spring.ex.database.domain.UsedGoods;
import com.nyeong.spring.ex.database.service.UsedGoodsService;

// 컨트롤러는 request, response 처리 담당
// controller -> service
@Controller
public class UsedGoodsController {
	
	// 객체생성 ( 스프링이 도와준 문법임 )
	@Autowired
	private UsedGoodsService usedGoodsService;
	
	@ResponseBody
	@RequestMapping("/db/usedgoods/list")
	public List<UsedGoods> usedGoodsList() {
		
		// 중고 물품 게시글 리스트 얻어오기
		List<UsedGoods> usedGoodsList = usedGoodsService.getUsedGoodsList();
		// 중고 물품 게시글 리스트 response에 담기
		return usedGoodsList;
		
		
	}
	
}
