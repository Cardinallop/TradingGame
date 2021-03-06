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

    private final ItemDao itemDao;
    private final UserDao userDao;

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
                user.setPassword("******");
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
            user.setPassword("******");
            return user;            
        }

	@Override
	public User addUser(User u) throws
                UserDataValidationException{
                validateUserData(u);
                u.setPassword(hashString(u.getPassword()));
                setUnrealized(u);
                u = userDao.addUser(u);
                u.setPassword("******");
                return u;
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
                if (!(hashString(u.getPassword()).equals(userDao.getUserById(id).getPassword())))
                    return false;
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
                user.setPassword("******");
            }
            return users;
    }
    
    private void validateUserData(User user) throws
            UserDataValidationException {
        if (user.getUsername() == null
                || user.getUsername().trim().length() == 0
                || user.getFirstName() == null
                || user.getFirstName().trim().length() == 0
                || user.getLastName() == null
                || user.getLastName().trim().length() == 0
                || user.getPassword() == null
                || user.getPassword().trim().length() == 0
                || user.getRealized() == null) {
            throw new UserDataValidationException(
                    "ERROR: All fields [username, firstName, lastName, password, money] are required.");
        }
    }
}
