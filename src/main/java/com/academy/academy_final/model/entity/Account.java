package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "account_number")
    private Integer accountNumber;

    @Column
    private Float accountBalance;

    @OneToMany (mappedBy = "senderAccount")
    private List<Transaction> senderTransactions;

    @OneToMany (mappedBy = "recipientAccount")
    private List<Transaction> recipientTransactions;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn (name = "account_status")
    private Status accountStatus;








}
