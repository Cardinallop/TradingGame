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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
    public ResponseEntity<User> getUserById(@PathVariable int id){
    	User result = userService.getUserById(id);
        if (result == null) {
            response = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        }
        response = new ResponseEntity(result, HttpStatus.OK);
        return response;
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Item> createItem(@RequestBody Item i) {
        Item result = itemService.addItem(i);
        if(result == null)
        	return response = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return response = new ResponseEntity(result, HttpStatus.CREATED);
        
    }
    
    @PostMapping("/user")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> createUser(@RequestBody User u) {
    	User result = userService.addUser(u);
        if(result == null)
        	return response = new ResponseEntity(null, HttpStatus.NOT_FOUND);
        return response = new ResponseEntity(result, HttpStatus.CREATED);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity updateItem(@PathVariable int id, @RequestBody Item i) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if (id != i.getId()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (itemService.updateItem(id, i)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity updateUser(@PathVariable int id, @RequestBody User u) {
        ResponseEntity response = new ResponseEntity(HttpStatus.NOT_FOUND);
        if (id != u.getId()) {
            response = new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY);
        } else if (userService.updateUser(id, u)) {
            response = new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return response;
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deleteItem(@PathVariable int id) {
        if (itemService.deleteItem(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity deleteUser(@PathVariable int id) {
        if (userService.deleteUser(id)) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }
    
    
	
}