/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.User;
import java.util.List;

/**
 *
 * @author brockpace
 */
public interface UserDao {
    User getUserById(int id);
    List<User> getAllUsers();
    User addUser(User user);
    void updateUser(User user);
    void deleteUserById(int id);
    
    List<User> getUsersByDifficulty(String difficulty);
}
