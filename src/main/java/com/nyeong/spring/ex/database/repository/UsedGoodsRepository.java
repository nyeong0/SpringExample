package com.nyeong.spring.ex.database.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.nyeong.spring.ex.database.domain.UsedGoods;

// Mybatis framework
// 데이터베이스 관련 기능 담당
// 메소드 정의만 할 것
// repository ->  UsedGoods Class 객체 생성 -> mapper.xml
@Mapper
public interface UsedGoodsRepository {
	
	// 자바 함수 호출이 아니라
	// mybatis  사용법에 따라 mapper클래스 안에 xml파일 생성한 것을 따라감
	public List<UsedGoods> selectUsedGoodsList();
		
}
