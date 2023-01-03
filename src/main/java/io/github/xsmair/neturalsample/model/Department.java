package io.github.xsmair.neturalsample.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String description;

    private String location;

    private String phone;

    private String fax;

    private String email;

    private String street;

    private String city;

    private String state;

    private String zip;

    private String country;

    private String company;

    @ManyToOne
    private User Manager;

    @OneToMany
    private List<User> users;
}
