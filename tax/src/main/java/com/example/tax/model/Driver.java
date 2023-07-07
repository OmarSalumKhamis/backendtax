package com.example.tax.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Driver {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int DrId;
    private String name;
    private String phone;
    private String gender;
    private String email;
    private String address;

}
