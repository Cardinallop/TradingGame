package com.m3.tradingGame.service;

import com.m3.tradingGame.dao.ItemDao;
import com.m3.tradingGame.dao.UserDao;
import com.m3.tradingGame.entities.Item;

import java.util.List;

import com.m3.tradingGame.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
		//more code here to update the current price and accelerator field
		return itemDao.getAllItems();
	}

	@Override
	public Item getItemById(int id) {
		//more code here to update the current price and accelerator field
		return itemDao.getItemById(id);
	}

	@Override
	public Item addItem(Item item) {
		return null;
	}

	private void setCurrentPrice(Item item) {
    	int compareVal = item.getInitialPrice().compareTo(item.getCurrentPrice());
    	int itemUserCount;

    	// equal
		if (compareVal == 0) {
			item.setAccelerator(0);
		// initial greater
		} else if (compareVal == 1 ) {
		// current greater
		} else if (compareVal == -1) {

		}
	}

	@Override
	public boolean updateItem(Item item) {
		try {
			//more code here to update the current price and accelerator field
			itemDao.updateItem(item);
			return true;
		} catch (DataAccessException ex) {
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public boolean deleteItem(int id) {
		try {
			itemDao.deleteItemById(id);
			return true;
		} catch (DataAccessException ex) {
			System.out.println(ex);
			return false;
		}
	}

	@Override
	public List<Item> getAllItemsByUserId(User user) {
		return null;
	}

}
