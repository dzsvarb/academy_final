package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public final class StatusRequest {
    @Id
    @Column(name = "status_request_id")
    private Integer statusRequestId;
    @Column
    private String statusRequestName;
}
