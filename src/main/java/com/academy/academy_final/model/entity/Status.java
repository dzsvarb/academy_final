package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public final class Status {
    @Id
    @Column (name = "status_id")
    private Integer statusId;
    @Column
    private String statusName;
}
