package com.example.exceptionhandling.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "customer")
@Data
public class Customer {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

     private String  name;
     private String  surname;


}
