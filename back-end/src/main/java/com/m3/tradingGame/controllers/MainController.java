package com.m3.tradingGame.controllers;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;
import com.m3.tradingGame.service.ItemServiceLayer;
import com.m3.tradingGame.service.UserServiceLayer;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tradingGame")
public class MainController {

    private final ItemServiceLayer itemService;
    private final UserServiceLayer userService;

    @Autowired
    public MainController(ItemServiceLayer itemService, UserServiceLayer userService) {
        this.itemService = itemService;
        this.userService = userService;
    }

    ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);

    @GetMapping
    public ResponseEntity<List<Item>> getAllItems() {
        List items = itemService.getAllItems();

        if (items.isEmpty()) {
            response = new ResponseEntity("There are no items to display", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(items, HttpStatus.FOUND);
        }
        return response;
    }
    
    @GetMapping("/admin")
	public ResponseEntity<List<User>> getAllUsers() {
		
    	List<User> users = userService.getAllUsers();
    	
    	if (users.isEmpty()) {
            response = new ResponseEntity("There are no items to display", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(users, HttpStatus.FOUND);
        }
        return response;
	}
    
    @GetMapping("/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable int id){
    	Item result = itemService.getItemById(id);
        if (result == null) {
            response = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        response = new ResponseEntity(result, HttpStatus.OK);
        return response;
    }
    
    @GetMapping("/admin/{id}")
    public ResponseEntity<Item> getUserById(@PathVariable int id){
    	User result = userService.getUserById(id);
        if (result == null) {
            response = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        response = new ResponseEntity(result, HttpStatus.OK);
        return response;
    }
    
	
}