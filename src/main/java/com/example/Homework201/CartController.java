package com.example.Homework201;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/store/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/get")
    public List<Integer> getCartItems(HttpServletRequest request) {
        String sessionId = request.getSession().getId();
        return cartService.getCartItems(sessionId);
    }

    @GetMapping("/add")
    public void addItemToCart(HttpServletRequest request, @RequestParam("itemId") int itemId) {
        String sessionId = request.getSession().getId();
        cartService.addItemToCart(sessionId, itemId);
    }
}