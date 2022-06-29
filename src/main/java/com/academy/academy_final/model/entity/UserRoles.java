package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class UserRoles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "roles")
    private String role;


}
