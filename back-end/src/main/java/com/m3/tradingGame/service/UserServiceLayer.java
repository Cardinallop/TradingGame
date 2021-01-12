package com.m3.tradingGame.service;

import java.util.List;

import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;

public interface UserServiceLayer {
	List<User> getAllUsers();
	User getUserById(int id);
	User addUser(User u);
	boolean updateUser(int id, User u);
	boolean deleteUser(int id);
        
    List<User> getUsersByDifficulty(String difficulty);
}
