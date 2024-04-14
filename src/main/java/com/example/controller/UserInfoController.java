package com.example.controller;

import com.example.entity.UserInfo;
import com.example.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserInfoController {

	@Autowired
	private UserInfoService userInfoService;

	@GetMapping("/")
	public String welcome() {
		return "Welcome this endpoint is not secure";
	}

	@PostMapping("/")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return userInfoService.addUser(userInfo);
	}
}
