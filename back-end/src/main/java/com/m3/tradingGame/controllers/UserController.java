package com.m3.tradingGame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
import com.m3.tradingGame.entities.User;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	UserDao userDao;
	
	@Autowired
	ItemDao itemDao;
	
	
	@GetMapping
	public String getAllUsers() {
		
		return "users";
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User u) {
        return userDao.add(u);
    }
	
	@GetMapping("/{id}")
	public String getUserInfo(Integer id, Model model) {
		
		return "userDetail";
	}
	
	@GetMapping("/{id}")
	public String deleteUser() {
		
		return "deleted user";
	}
	
	@GetMapping("/{id}")
	public String editUser() {
		
		return "edited user";
	}
		
}
