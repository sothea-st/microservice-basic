package com.example.demo.domain;

import com.example.demo.dto.UserDTO;

public class Order {
    private Long id;
    private String item;
    private UserDTO userDTO;

    public Order(Long id, String item, UserDTO userDTO) {
        this.id = id;
        this.item = item;
        this.userDTO = userDTO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public UserDTO getUser() {
        return userDTO;
    }

    public void setUser(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
}
