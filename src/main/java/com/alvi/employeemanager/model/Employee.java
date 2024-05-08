package com.alvi.employeemanager.model;


import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,updatable = false)
    private  Integer id;
    private String name;
    private  String email;
    private  String jobTitle;
    private  String imageUrl;
    private  String phone;

    @Column(nullable = false,updatable = false)
    private  String employeeCode;


}
