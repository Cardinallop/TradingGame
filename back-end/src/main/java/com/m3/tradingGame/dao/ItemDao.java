package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.Item;
import com.m3.tradingGame.entities.User;

import java.util.List;

public interface ItemDao {
    Item getItemById(int id);
    List<Item> getAllItems();
    Item addItem(Item item);
    void updateItem(Item item);
    void deleteItemById(int id);

    List<Item> getAllItemsByUserId(User user);
}
