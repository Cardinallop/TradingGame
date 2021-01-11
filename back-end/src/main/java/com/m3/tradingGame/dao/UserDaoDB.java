/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
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
            Integer q = jdbc.queryForObject(SELECT_QUANTITY_OF_ITEM, new ItemUserMapper(), id, item.getId());
            hmap.put(item, q);
        }
        return hmap;
    }

    @Override
    public List<User> getAllUser() {
        final String SELECT_ALL_USERS = "SELECT * FROM user";
        List<User> users = jdbc.query(SELECT_ALL_USERS, new UserMapper());
        associateDifficultyAndItems(users);
        return users;
    }
    
    private void associateDifficultyAndItems(List<User> users) {
        for (User user : users) {
            user.setDifficulty(getDifficultyForUser(user.getId()));
            user.setItems(getItemsForUser(user.getId()));
        }
    }

    @Override
    @Transactional
    public User addUser(User user) {
        final String GET_DIFFICULTY_ID = "SELECT id FROM difficulty d WHERE d.name = ?";
        int difficulty = jdbc.queryForObject(GET_DIFFICULTY_ID, user.getDifficulty());
        final String INSERT_USER = "INSERT INTO user(username, firstName, lastName, password, money, difficultyId) "
                + "VALUES(?,?,?,?,?,?)";
        jdbc.update(INSERT_USER,
                user.getUsername(), 
                user.getFirstName(), 
                user.getLastName(), 
                user.getPassword(), 
                user.getMoney());
    }

    @Override
    public void updateUser(User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    public static final class ItemUserMapper implements RowMapper<Integer> {

        @Override
        public Integer mapRow(ResultSet rs, int index) throws SQLException {
            return rs.getInt("quantity");
        }
        
    }
    
}
