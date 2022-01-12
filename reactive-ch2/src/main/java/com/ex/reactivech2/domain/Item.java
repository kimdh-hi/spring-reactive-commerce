package com.ex.reactivech2.domain;

import org.springframework.data.annotation.Id;

import java.util.Objects;

public class Item {

    @Id
    private String id; // ObjectId (_id)
    private String name;
    private double price;

    private Item() {}

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Double.compare(item.price, price) == 0 && id.equals(item.id) && name.equals(item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price);
    }
}
