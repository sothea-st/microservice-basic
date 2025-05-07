package com.example.demo.controller;

import com.example.demo.config.UserClient;
import com.example.demo.domain.Order;
import com.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private UserClient userClient;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        User user = userClient.getUser(1L);
        return new Order(id, "MacBook", user);
    }
}
