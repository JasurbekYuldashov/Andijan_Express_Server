package com.example.demo.models;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer categoryId;
    private Integer categoryTypeId;
    private String name;
    private String description;
    private Float cost;
    @Column(name = "is_deleted")
    private Boolean deleted=false;
    private Integer fileId;
}
