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
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
import org.springframework.web.bind.annotation.*;
>>>>>>> 62bf54d2bde7a013322388958b56923e723bd413

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

    //GET endpoints

    @GetMapping("/item")
    public ResponseEntity<List<Item>> findAllItems() {
        List items = itemService.findAllItems();

        if (items.isEmpty()) {
            response = new ResponseEntity("There are no items to display", null, HttpStatus.NOT_FOUND);
        } else {
<<<<<<< HEAD
            response = new ResponseEntity(items, HttpStatus.FOUND);
=======
            response = new ResponseEntity(items, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Item> findItemById(@PathVariable int id) {
        Item item = itemService.findItemById(id);

        if(item == null) {
            response = new ResponseEntity("No such Item exists", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(item, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/user")
    public ResponseEntity<List<User>> findAllUsers() {
        List users = userService.findAllUsers();

        if(users.isEmpty()) {
            response = new ResponseEntity("There are no users to display", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(users, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Item> findUserById(@PathVariable int id) {
        User user = userService.findUserById(id);

        if(user == null) {
            response = new ResponseEntity("No such user exists", null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(user, HttpStatus.OK);
        }
        return response;
    }

    @GetMapping("/userItems")
    public ResponseEntity<Item> findAllItemsByUserId(@RequestBody User user) {
        List items = itemService.findAllItemsByUserId(user);

        if (items.isEmpty()) {
            response = new ResponseEntity("No items for userId: " + user.getId(), null, HttpStatus.NOT_FOUND);
        } else {
            response = new ResponseEntity(items, HttpStatus.OK);
>>>>>>> 62bf54d2bde7a013322388958b56923e723bd413
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