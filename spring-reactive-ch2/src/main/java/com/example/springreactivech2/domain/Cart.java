package com.example.springreactivech2.domain;

import org.springframework.data.annotation.Id;

public class Cart {

    @Id
    private String id;
    private List<CartItem> cartItems;

    private Cart() {}

    public Cart(String id, List<CartItem> cartItems) {
        this.id = id;
        this.cartItems = cartItems;
    }


}
