package com.nyeong.spring.ex.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nyeong.spring.ex.jsp.domain.User;
import com.nyeong.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public int addUser(String name, String birthday, String email) {
		int count = userRepository.insertUser(name, birthday, email);
		return count;
	}
	
	public int addUserByObject(User user) {
		int count = userRepository.insertUserByObject(user);
		return count;
	}
	
	// 가장 최근에 등록된 사용자 정보 얻기
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		return user;
	}
	

}
