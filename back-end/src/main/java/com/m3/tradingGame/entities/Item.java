package com.m3.tradingGame.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class Item {
    private int id;
    private String name;
    private BigDecimal initialPrice;
    private BigDecimal currentPrice;
    private double accelerator;

    public Item() {}

    public Item(int id, String name, BigDecimal initialPrice, BigDecimal currentPrice, double accelerator) {
        this.id = id;
        this.name = name;
        this.initialPrice = initialPrice;
        this.currentPrice = currentPrice;
        this.accelerator = accelerator;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getInitialPrice() {
        return initialPrice;
    }
    public void setInitialPrice(BigDecimal initialPrice) {
        initialPrice = initialPrice.setScale(2, RoundingMode.HALF_UP);
        this.initialPrice = initialPrice;
    }

    public BigDecimal getCurrentPrice() {
        return currentPrice;
    }
    public void setCurrentPrice(BigDecimal currentPrice) {
        currentPrice = currentPrice.setScale(2, RoundingMode.HALF_UP);
        this.currentPrice = currentPrice;
    }

    public double getAccelerator() {
        return accelerator;
    }
    public void setAccelerator(double accelerator) {
        this.accelerator = accelerator;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                Double.compare(item.getAccelerator(), getAccelerator()) == 0 &&
                getName().equals(item.getName()) &&
                getInitialPrice().equals(item.getInitialPrice()) &&
                getCurrentPrice().equals(item.getCurrentPrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getInitialPrice(), getCurrentPrice(), getAccelerator());
    }
}
