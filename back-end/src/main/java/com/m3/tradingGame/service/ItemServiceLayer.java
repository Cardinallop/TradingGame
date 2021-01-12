package com.m3.tradingGame.service;

import java.util.List;

import com.m3.tradingGame.entities.Item;

public interface ItemServiceLayer {
	public List<Item> getAllItems();
	public Item getItemById(int id);
	public Item addItem(Item i);
	public boolean updateItem(int id, Item i);
	public boolean deleteItem(int id);
}
