package com.m3.tradingGame.service;

import java.util.List;

import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;

public interface ItemServiceLayer {
	List<Item> getAllItems();
	Item getItemById(int id);
	Item addItem(Item item);
	boolean updateItem(Item item);
	boolean deleteItem(int id);

	List<Item> getAllItemsByUserId(User user);

}
