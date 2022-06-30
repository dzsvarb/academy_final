package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name="card_number")

    private Integer cardNumber;

    @Column (name="card_pay_sys")

    private String cardPaySystem;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_account", referencedColumnName = "account_number")
    private Account cardAccount;




}
