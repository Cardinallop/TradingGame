package com.m3.tradingGame.service;

import java.util.List;

import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;

public interface UserServiceLayer {
	public List<User> getAllUsers();
	public User getUserById(int id);
	public User addUser(User u);
	public boolean updateUser(int id, User u);
	public boolean deleteUser(int id);
}
