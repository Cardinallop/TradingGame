package com.m3.tradingGame.service;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
import com.m3.tradingGame.entities.Item;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceLayerImpl implements ItemServiceLayer {

    private ItemDao itemDao;
    private UserDao userDao;

    @Autowired
    public ItemServiceLayerImpl(ItemDao itemDao, UserDao userDao) {
        this.itemDao = itemDao;
        this.userDao = userDao;
    }

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Item addItem(Item i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateItem(int id, Item i) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteItem(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
