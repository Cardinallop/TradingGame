/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.dao;

import com.m3.tradingGame.dao.ItemDaoDB.ItemMapper;
import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author brockpace
 */
@Repository
public class UserDaoDB implements UserDao {
    
    @Autowired
    JdbcTemplate jdbc;

    @Override
    public User getUserById(int id) {
        try {
            final String SELECT_USER_BY_ID = "SELECT * FROM user u "
                    + "INNER JOIN difficulty d ON u.difficultyId = d.id WHERE u.id = ?";
            User user = jdbc.queryForObject(SELECT_USER_BY_ID, new UserMapper(), id);
            user.setItems(getItemsForUser(id));
            return user;
        } catch(DataAccessException ex) {
            return null;
        }
    }
    
    @Transactional
    private HashMap<Item, Integer> getItemsForUser(int id) {
        final String SELECT_ITEMS_FOR_USER = "SELECT i.* FROM item i "
                + "INNER JOIN itemUser iu ON i.id = iu.itemId WHERE iu.userId = ?";
        List<Item> items = jdbc.query(SELECT_ITEMS_FOR_USER, new ItemMapper(), id);
        HashMap<Item, Integer> hmap = new HashMap<Item, Integer>();
        for(Item item : items) {
            final String SELECT_QUANTITY_OF_ITEM = "SELECT iu.* FROM itemUser iu "
                    + "WHERE iu.userId = ? AND iu.itemId = ?";
            Integer q = jdbc.queryForObject(SELECT_QUANTITY_OF_ITEM, Integer.class, id, item.getId());
            hmap.put(item, q);
        }
        return hmap;
    }

    @Override
    public List<User> getAllUsers() {
        final String SELECT_ALL_USERS = "SELECT * FROM user u INNER JOIN difficulty d ON u.difficultyId = d.id";
        List<User> users = jdbc.query(SELECT_ALL_USERS, new UserMapper());
        associateItems(users);
        return users;
    }
    
    private void associateItems(List<User> users) {
        for (User user : users) {
            user.setItems(getItemsForUser(user.getId()));
        }
    }

    @Override
    @Transactional
    public User addUser(User user) {
        int difficulty = getDifficultyId(user);
        final String INSERT_USER = "INSERT INTO user(username, firstName, lastName, password, money, difficultyId) "
                + "VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getUsername(), 
                user.getFirstName(), 
                user.getLastName(), 
                user.getPassword(), 
                user.getMoney(),
                difficulty);
        
        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        user.setId(newId);
        insertItemUser(user);
        return user;
    }
    
    private Integer getDifficultyId(User user) {
        final String GET_DIFFICULTY_ID = "SELECT id FROM difficulty d WHERE d.name = ?";
        return jdbc.queryForObject(GET_DIFFICULTY_ID, Integer.class, user.getDifficulty());
    }
    
    private void insertItemUser(User user) {
        final String INSERT_ITEM_USER = "INSERT INTO "
                + "itemUser(quantity, itemId, userId) VALUES (?,?,?)";
        user.getItems().forEach((k,v) -> {
            jdbc.update(INSERT_ITEM_USER,
                    v,
                    k.getId(),
                    user.getId());
        });
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        int difficulty = getDifficultyId(user);
        final String UPDATE_USER = "UPDATE user SET username = ?, firstName = ?, "
                + "lastName = ?, password = ?, money = ?, difficultyId = ? WHERE id = ?";
        jdbc.update(UPDATE_USER,
                user.getUsername(),
                user.getFirstName(),
                user.getLastName(),
                user.getPassword(),
                user.getMoney(),
                difficulty,
                user.getId());
        
        final String DELETE_ITEM_USER = "DELETE FROM itemUser WHERE userId = ?";
        jdbc.update(DELETE_ITEM_USER, user.getId());
        insertItemUser(user);
    }

    @Override
    @Transactional
    public void deleteUserById(int id) {
        final String DELETE_ITEM_USER = "DELETE FROM itemUser WHERE userId = ?";
        jdbc.update(DELETE_ITEM_USER, id);
        
        final String DELETE_USER = "DELETE FROM user WHERE id = ?";
        jdbc.update(DELETE_USER, id);
    }
    
    public static final class UserMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int index) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("u.id"));
            user.setUsername(rs.getString("u.username"));
            user.setFirstName(rs.getString("u.firstName"));
            user.setLastName(rs.getString("u.lastName"));
            user.setPassword(rs.getString("u.password"));
            user.setMoney(rs.getBigDecimal("u.money"));
            user.setDifficulty(rs.getString("d.name"));
            
            return user;
        }
        
    }
    
}
