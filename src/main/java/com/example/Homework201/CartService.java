package com.example.Homework201;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CartService {
    private final Map<String, Cart> carts;

    public CartService() {
        this.carts = new ConcurrentHashMap<>();
    }

    public void addItemToCart(String sessionId, int itemId) {
        Cart cart = carts.getOrDefault(sessionId, new Cart());
        cart.addItem(itemId);
        carts.put(sessionId, cart);
    }

    public List<Integer> getCartItems(String sessionId) {
        return carts.getOrDefault(sessionId, new Cart()).getItems();
    }
}
