package com.nyeong.spring.ex.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.nyeong.spring.ex.jsp.domain.User;
import com.nyeong.spring.ex.jsp.service.UserService;

@Controller
@RequestMapping("/jsp/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	// 이름, 생년월일, 이메일을 전달 받고 저장하는 페이지
	// post, get 메소드 설정
	/* @RequestMapping(path="/jsp/user/create", method=RequestMethod.GET) */
	@GetMapping("/create")
//	@ResponseBody
	public String createUser(
			@RequestParam("name") String name
			,@RequestParam("birthday") String birthday
			,@RequestParam("email") String email
			, Model model){
		
//		int count = userService.addUser(name, birthday, email);
		
		User user = new User();
		user.setName(name);
		user.setYyyymmdd(birthday);
		user.setEmail(email);
		
		int count = userService.addUserByObject(user);
		model.addAttribute("result", user);
		
		return "jsp/userInfo";
	}
	
	
	// jsp경로 리턴하는 메소드
	@GetMapping("/input")
	public String inputUser() {
		/* return "/WEB-INF/jsp/jsp/userInput.jsp";  application.properties에서 미리 설정한 공통부분이 포함되어 있으므로 생략.*/
		return "jsp/userInput";
	}
	
	
	@GetMapping("/info")
	public String userInfo(Model model) {
		// 가장 최근에 추가된 사용자 정보
		User user = userService.getLastUser();
			
		// Model
		model.addAttribute("result", user);
		model.addAttribute("title", "사용자 정보");
		
		return "jsp/userInfo";
	}
	
	
}
