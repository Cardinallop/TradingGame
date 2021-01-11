/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author brockpace
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoDBTest {
    
    @Autowired
    ItemDao itemDao;
    
    @Autowired
    UserDao userDao;
    
    public UserDaoDBTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        List<Item> items = itemDao.getAllItems();
        for(Item item : items) {
            itemDao.deleteItemById(item.getId());
        }
        List<User> users = userDao.getAllUser();
        for(User user : users) {
            userDao.deleteUserById(user.getId());
        }
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserById method, of class UserDaoDB.
     */
    @Test
    public void testGetUserById() {
    }

    /**
     * Test of getAllUser method, of class UserDaoDB.
     */
    @Test
    public void testGetAllUser() {
    }

    /**
     * Test of addUser method, of class UserDaoDB.
     */
    @Test
    public void testAddUser() {
    }

    /**
     * Test of updateUser method, of class UserDaoDB.
     */
    @Test
    public void testUpdateUser() {
    }

    /**
     * Test of deleteUserById method, of class UserDaoDB.
     */
    @Test
    public void testDeleteUserById() {
    }
    
}
