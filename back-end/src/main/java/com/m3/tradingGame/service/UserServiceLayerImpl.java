package com.m3.tradingGame.service;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
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
}
