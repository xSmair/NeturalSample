package io.github.xsmair.neturalsample.model;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    private String password;

    private String phone;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String company;

    private String title;

    @ManyToOne
    private Department department;

    @ManyToOne
    private User manager;

    @ManyToOne
    private Job job;
}