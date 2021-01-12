package com.m3.tradingGame.service;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceLayerImpl implements UserServiceLayer {

    private ItemDao itemDao;
    private UserDao userDao;

    @Autowired
    public UserServiceLayerImpl(ItemDao itemDao, UserDao userDao) {
        this.itemDao = itemDao;
        this.userDao = userDao;
    }

	@Override
	public List<User> getAllUsers() {
            List<User> users = userDao.getAllUsers();
            for(User user : users) {
                setUnrealized(user);
            }
            return users;
        }
        
        private void setUnrealized(User user) {
            BigDecimal unrealized = user.getRealized();
            Map<Item, Integer> map = user.getItems();
            for (Map.Entry<Item, Integer> entry: map.entrySet()) {
                BigDecimal change = entry.getKey().getCurrentPrice();
                change = change.multiply(new BigDecimal(entry.getValue()));
                unrealized = unrealized.add(change);
            }
            user.setUnrealized(unrealized);
        }

	@Override
	public User getUserById(int id) {
            User user = userDao.getUserById(id);
            setUnrealized(user);
            return user;            
        }

	@Override
	public User addUser(User u) {
                u.setPassword(hashString(u.getPassword()));
                setUnrealized(u);
                return userDao.addUser(u);
        }
        
        private static String hashString(String password) {
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-512");
                
                byte[] messageDigest = md.digest(password.getBytes());
                
                BigInteger bi = new BigInteger(1, messageDigest);
                
                String hashPassword = bi.toString(16);
                
                while (hashPassword.length() < 32) {
                    hashPassword = "0" + hashPassword;
                }
                
                return hashPassword;
                
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }

	@Override
	public boolean updateUser(int id, User u) {
            try {
                u.setId(id);
                userDao.updateUser(u);
                return true;
            } catch(Exception e) {
                return false;
            }
        }

	@Override
	public boolean deleteUser(int id) {
            try {
                userDao.deleteUserById(id);
                return true;
            } catch(Exception e) {
                return false;
            }
        }

    @Override
    public List<User> getUsersByDifficulty(String difficulty) {
        List<User> users = userDao.getUsersByDifficulty(difficulty);
            for(User user : users) {
                setUnrealized(user);
            }
            return users;
    }
}
