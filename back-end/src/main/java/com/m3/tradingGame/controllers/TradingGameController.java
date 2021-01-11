package com.m3.tradingGame.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;


//@RestController
//@RequestMapping("/api/tradingGame")
public class TradingGameController {
	/*
	private final UserDao userDao;
	private final ItemDao itemDao;
	
	ResponseEntity response; // = ResponseEntity;
	
	public TradingGameController(UserDao userDao, ItemDao itemDao) {
		this.userDao = userDao;
		this.itemDao = itemDao;
	}
	
	@GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List items = itemDao.getAllItems();

        if (items.isEmpty()) {
            response = new ResponseEntity("There are no items to display", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(items, HttpStatus.CREATED);
        }
    }
	
	@GetMapping("/admin")
	public List<User> getAllUsers() {
		
		return userDao.getALL();
	}
	
	@PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User create(@RequestBody User u) {
        return userDao.add(u);
    }
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable int id) {
		User result = userDao.findById(id);
        if (result == null) {
            return new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public String deleteUser() {
		
		return "deleted user";
	}
	
	@GetMapping("/{id}")
	public String editUser() {
		
		return "edited user";
	}
	*/
		
}
