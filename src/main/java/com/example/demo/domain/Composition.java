package com.example.demo.domain;


import javax.persistence.*;

@Entity
@Table(name= "Composition")
public class Composition {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
