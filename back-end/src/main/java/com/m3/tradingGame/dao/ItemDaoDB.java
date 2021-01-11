package com.m3.tradingGame.dao;

import com.m3.tradingGame.entities.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ItemDaoDB implements ItemDao{

    private final JdbcTemplate jdbc;

    @Autowired
    public ItemDaoDB(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Item getItemById(int id) {
        try {
            final String SELECT_ITEM_BY_ID = "SELECT * FROM item WHERE id =  ?";
            return jdbc.queryForObject(SELECT_ITEM_BY_ID, new ItemMapper(), id);
        } catch (DataAccessException ex) {
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {
        final String SELECT_ALL_ITEMS = "SELECT * FROM item";
        return jdbc.query(SELECT_ALL_ITEMS, new ItemMapper());
    }

    @Override
    @Transactional
    public Item addItem(Item item) {
        final String INSERT_ITEM = "INSERT INTO item (name, initialPrice, currentPrice) VALUES (?,?,?)";
        jdbc.update(INSERT_ITEM,
                item.getName(),
                item.getInitialPrice(),
                item.getCurrentPrice());

        int newId = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        item.setId(newId);
        return item;
    }

    @Override
    public void updateItem(Item item) {
        final String UPDATE_ITEM = "UPDATE item SET name = ?, " +
                "initialPrice = ?, currentPrice = ? WHERE id = ?";
        jdbc.update(UPDATE_ITEM,
                item.getName(),
                item.getInitialPrice(),
                item.getCurrentPrice(),
                item.getId());
    }

    @Override
    public void deleteItemById(int id) {
        final String DELETE_ITEM_USER = "DELETE FROM itemUser WHERE itemId = ?";
        jdbc.update(DELETE_ITEM_USER, id);

        final String DELETE_ITEM = "DELETE FROM item WHERE id = ?";
        jdbc.update(DELETE_ITEM,id);
    }

    public static final class ItemMapper implements RowMapper<Item> {
        @Override
        public Item mapRow(ResultSet rs, int index) throws SQLException {
            Item item = new Item();
            item.setId(rs.getInt("id"));
            item.setName(rs.getString("name"));
            item.setInitialPrice(rs.getBigDecimal("initialPrice"));
            item.setCurrentPrice(rs.getBigDecimal("currentPrice"));
            return item;
        }
    }
}
