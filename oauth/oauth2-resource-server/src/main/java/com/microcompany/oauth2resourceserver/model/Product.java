package com.microcompany.oauth2resourceserver.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter
public class Product {
    private int id;
    private String name;
    private int quantity;
}