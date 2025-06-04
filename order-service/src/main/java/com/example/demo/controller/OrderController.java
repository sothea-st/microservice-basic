package com.example.demo.controller;

import com.example.demo.dto.UserDTO;
import com.example.demo.feign_client.UserFeignClient;
import com.example.demo.domain.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        //UserDTO userDTO = userFeignClient.getUser(1L);
//        System.out.println("fffffffffff = " + userDTO);
        return new Order(id, "MacBook", null);
    }
}
