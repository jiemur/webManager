package com.wzn.pojo;

import lombok.Data;

import java.util.Set;

@Data
public class Brand {
    private int id;
    private String name;
    private String des;
    private Set<Product> sets;
}
