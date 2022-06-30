package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;


@Data
@Entity
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer transactionId;

    @Column
    private String transactionType;

    @Column
    private Float transactionValue;

    @Column
    private LocalDateTime transactionTime;
    @ManyToOne
    @JoinColumn(name="sender_account")
    private Account senderAccount;

    @ManyToOne
    @JoinColumn (name="recipient_account")
    private Account recipientAccount;






}
