/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.dao;

import org.junit.jupiter.api.Test;
import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import static org.junit.Assert.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        List<Item> items = itemDao.getAllItems();
        for(Item item : items) {
            itemDao.deleteItemById(item.getId());            
        }
        
        List<User> users = userDao.getAllUsers();
        for(User user : users) {
            userDao.deleteUserById(user.getId());
        }
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getUserById method, of class UserDaoDB.
     */
    @Test
    public void testAddAndGetUser() {
        Item item = new Item();
        item.setName("Test Name");
        item.setInitialPrice(new BigDecimal(5.00));
        item.setCurrentPrice(new BigDecimal(10.00));
        item = itemDao.addItem(item);
        
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 3);
        
        User user = new User();
        user.setUsername("brockcheese");
        user.setFirstName("Brock");
        user.setLastName("Pace");
        user.setPassword("goo");
        user.setRealized(new BigDecimal(35.69));
        user.setDifficulty("hard");
        user.setItems(items);
        user = userDao.addUser(user);
        
        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
    }

    /**
     * Test of getAllUser method, of class UserDaoDB.
     */
    @Test
    public void testGetAllUser() {
        Item item = new Item();
        item.setName("Test Name");
        item.setInitialPrice(new BigDecimal(5.00));
        item.setCurrentPrice(new BigDecimal(10.00));
        item = itemDao.addItem(item);
        
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 3);
        
        User user = new User();
        user.setUsername("brockcheese");
        user.setFirstName("Brock");
        user.setLastName("Pace");
        user.setPassword("goo");
        user.setRealized(new BigDecimal(35.69));
        user.setDifficulty("hard");
        user.setItems(items);
        user = userDao.addUser(user);
        
        User user2 = new User();
        user2.setUsername("frazzoli");
        user2.setFirstName("Frazzle");
        user2.setLastName("Gargleblack");
        user2.setPassword("HereHere");
        user2.setRealized(new BigDecimal(85.64));
        user2.setDifficulty("easy");
        user2.setItems(items);
        user2 = userDao.addUser(user2);
        
        List<User> users = userDao.getAllUsers();
        assertEquals(2, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user2));
    }

    /**
     * Test of updateUser method, of class UserDaoDB.
     */
    @Test
    public void testUpdateUser() {
        Item item = new Item();
        item.setName("Test Name");
        item.setInitialPrice(new BigDecimal(5.00));
        item.setCurrentPrice(new BigDecimal(10.00));
        item = itemDao.addItem(item);
        
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 3);
        
        User user = new User();
        user.setUsername("brockcheese");
        user.setFirstName("Brock");
        user.setLastName("Pace");
        user.setPassword("goo");
        user.setRealized(new BigDecimal(35.69));
        user.setDifficulty("hard");
        user.setItems(items);
        user = userDao.addUser(user);
        
        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
        
        user.setUsername("shtingo");
        user.setFirstName("blad");
        Item item2 = new Item();
        item2.setName("Test Name 2");
        item2.setInitialPrice(new BigDecimal(45.67));
        item2.setCurrentPrice(new BigDecimal(2.00));
        item2 = itemDao.addItem(item2);
        items.put(item2, 1);
        
        user.setItems(items);
        
        userDao.updateUser(user);
        
        assertNotEquals(user, fromDao);
        
        fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
    }

    /**
     * Test of deleteUserById method, of class UserDaoDB.
     */
    @Test
    public void testDeleteUserById() {
        Item item = new Item();
        item.setName("Test Name");
        item.setInitialPrice(new BigDecimal(5.00));
        item.setCurrentPrice(new BigDecimal(10.00));
        item = itemDao.addItem(item);
        
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 3);
        
        User user = new User();
        user.setUsername("brockcheese");
        user.setFirstName("Brock");
        user.setLastName("Pace");
        user.setPassword("goo");
        user.setRealized(new BigDecimal(35.69));
        user.setDifficulty("hard");
        user.setItems(items);
        user = userDao.addUser(user);
        
        User fromDao = userDao.getUserById(user.getId());
        assertEquals(user, fromDao);
        
        userDao.deleteUserById(user.getId());
        
        fromDao = userDao.getUserById(user.getId());
        assertNull(fromDao);
    }
    
    @Test
    public void getUsersByDifficulty() {
        Item item = new Item();
        item.setName("Test Name");
        item.setInitialPrice(new BigDecimal(5.00));
        item.setCurrentPrice(new BigDecimal(10.00));
        item = itemDao.addItem(item);
        
        HashMap<Item, Integer> items = new HashMap<>();
        items.put(item, 3);
        
        User user = new User();
        user.setUsername("brockcheese");
        user.setFirstName("Brock");
        user.setLastName("Pace");
        user.setPassword("goo");
        user.setRealized(new BigDecimal(35.69));
        user.setDifficulty("hard");
        user.setItems(items);
        user = userDao.addUser(user);
        
        User user2 = new User();
        user2.setUsername("Test Hard User Name 2");
        user2.setFirstName("Brock");
        user2.setLastName("Pace");
        user2.setPassword("goo");
        user2.setRealized(new BigDecimal(69.35));
        user2.setDifficulty("hard");
        user2.setItems(items);
        user2 = userDao.addUser(user2);
        
        User user3 = new User();
        user3.setUsername("Test Hard User Name 3");
        user3.setFirstName("Brock");
        user3.setLastName("Pace");
        user3.setPassword("goo");
        user3.setRealized(new BigDecimal(20.59));
        user3.setDifficulty("hard");
        user3.setItems(items);
        user3 = userDao.addUser(user3);
        
        User user4 = new User();
        user4.setUsername("Test Hard User Name 4");
        user4.setFirstName("Brock");
        user4.setLastName("Pace");
        user4.setPassword("goo");
        user4.setRealized(new BigDecimal(2.08));
        user4.setDifficulty("hard");
        user4.setItems(items);
        user4 = userDao.addUser(user4);
        
        User user5 = new User();
        user5.setUsername("Test Hard User Name 5");
        user5.setFirstName("Brock");
        user5.setLastName("Pace");
        user5.setPassword("goo");
        user5.setRealized(new BigDecimal(10.94));
        user5.setDifficulty("hard");
        user5.setItems(items);
        user5 = userDao.addUser(user5);
        
        User user6 = new User();
        user6.setUsername("Test Hard User Name 6");
        user6.setFirstName("Brock");
        user6.setLastName("Pace");
        user6.setPassword("goo");
        user6.setRealized(new BigDecimal(40.07));
        user6.setDifficulty("hard");
        user6.setItems(items);
        user6 = userDao.addUser(user6);
        
        User user7 = new User();
        user7.setUsername("Test Easy Username");
        user7.setFirstName("Brock");
        user7.setLastName("Pace");
        user7.setPassword("goo");
        user7.setRealized(new BigDecimal(99.99));
        user7.setDifficulty("easy");
        user7.setItems(items);
        user7 = userDao.addUser(user7);
        
        User user8 = new User();
        user8.setUsername("Test Medium Username");
        user8.setFirstName("Brock");
        user8.setLastName("Pace");
        user8.setPassword("goo");
        user8.setRealized(new BigDecimal(100.97));
        user8.setDifficulty("medium");
        user8.setItems(items);
        user8 = userDao.addUser(user8);
        
        List<User> users = userDao.getUsersByDifficulty("hard");
        
        assertEquals(5, users.size());
        assertTrue(users.contains(user));
        assertTrue(users.contains(user2));
        assertTrue(users.contains(user3));
        assertFalse(users.contains(user4));
        assertTrue(users.contains(user5));
        assertTrue(users.contains(user6));
        assertFalse(users.contains(user7));
        assertFalse(users.contains(user8));
    }
    
}
