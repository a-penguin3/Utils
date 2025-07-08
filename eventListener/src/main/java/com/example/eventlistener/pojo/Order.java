package com.example.eventlistener.pojo;

import lombok.Data;

@Data
public class Order {

    private String name;

    public Order(String name){
        this.name = name;
    }
}
