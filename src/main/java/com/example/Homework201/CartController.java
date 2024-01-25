package com.example.Homework201;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/store/order")
public class CartController {
    private final Map<String, Cart> carts = new ConcurrentHashMap<>();

    @GetMapping("/get")
    public List<Integer> getItems(@RequestHeader("X-Session-Id") String sessionId) {
        Cart cart = carts.getOrDefault(sessionId, new Cart());
        return cart.getItems();
    }

    @PostMapping("/add")
    public void addItem(@RequestHeader("X-Session-Id") String sessionId, @RequestParam("itemId") List<Integer> itemIds) {
        Cart cart = carts.getOrDefault(sessionId, new Cart());
        for (int itemId : itemIds) {
            cart.addItem(itemId);
        }
        carts.put(sessionId, cart);
    }
}
