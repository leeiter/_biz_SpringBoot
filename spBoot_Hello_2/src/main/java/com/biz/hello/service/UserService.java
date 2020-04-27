package com.biz.hello.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.biz.hello.domain.UserVO;

@Service
public class UserService {

	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<>();
		
		userList.add(UserVO.builder()
				.username("홍길동")
				.password("1234")
				.email("hong@gmail.com")
				.phone("010-1111-1234")
				.address("서울특별시")
				.build());
		
		userList.add(UserVO.builder()
				.username("이몽룡")
				.password("1234")
				.email("lee@gmail.com")
				.phone("010-2222-1234")
				.address("남원시")
				.build());
		
		userList.add(UserVO.builder()
				.username("성춘향")
				.password("1234")
				.email("sung@gmail.com")
				.phone("010-3333-1234")
				.address("익산시")
				.build());
		
		return userList;
	}
	
 }
