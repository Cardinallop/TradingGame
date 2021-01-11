package com.m3.tradingGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ItemDao itemDao;
	
	
	@GetMapping("users")
	public String getAllUsers() {
		
		return "users";
	}
	
	@GetMapping("userDetail")
	public String getUserInfo(Integer id, Model model) {
		
		return "userDetail";
	}
	
	@PostMapping("addUser")
	public String addUser(){
		
		return "redirect:/users";
	}
	
	@GetMapping("deleteUser")
	public String deleteUser() {
		
		return "redirect:/users";
	}
	
	@GetMapping("editUser")
	public String editUser() {
		
		return "editUser";
	}
	
	@PostMapping("editStudent")
	public String performEditUser() {
		
		return "redirect:/users";
	}
	
	
}
