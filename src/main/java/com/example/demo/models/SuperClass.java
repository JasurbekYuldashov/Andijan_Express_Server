package com.example.demo.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public abstract class SuperClass {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

}
