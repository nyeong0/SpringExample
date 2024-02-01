package com.nyeong.spring.ex.lifecycle;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // @Controller + @ResponseBody
@RequestMapping("/lifecycle/ex01")
public class Ex01RestController {

	// 직접 만든 클래스 객체 리턴
	@RequestMapping("/3")
	public Person objectResponse() {
		Person me = new Person("강수녕", 5);
		
		return me;
	}
	
	@RequestMapping("/4")
	public ResponseEntity<Person> entityResponse() {
		Person me = new Person("강수녕", 15);
		// HTTP Status Code
		// 정상 코드 : 200 OK
		// 에러 코드 : 404 Not Found : 페이지가 없음 ( 99.99% 주소 잘못된 것)
		// 에러 코드 : 405 Method Not Allow : 메소드가 일치하지 않음 ( Get , Post )
		// 에러 코드 : 400 Bad Request : 잘못된 요청 ( 파라미터 불일치 )
		// 에러 코드 : 500 Internal Server Error : 서버 에러 ( 클래스 자바 코드 확인 )
		
		ResponseEntity<Person> entity = new ResponseEntity(me, HttpStatus.INTERNAL_SERVER_ERROR);
		
		return entity;
				
	}
	
	
}
