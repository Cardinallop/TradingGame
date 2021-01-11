package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ItemDaoDB implements ItemDao{

    private final JdbcTemplate jdbc;

    @Autowired
    public ItemDaoDB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Item getItemById(int id) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItemById(int id) {

    }
}
