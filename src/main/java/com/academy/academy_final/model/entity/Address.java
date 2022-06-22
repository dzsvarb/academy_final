package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "address_id")
    private Integer addressId;
    @Column
    private String city;
    @Column
    private String street;
    @Column
    private String house;
    @Column
    private String room;

   /* @OneToMany (mappedBy = "userAddress")
    private List<User> users;*/
}

