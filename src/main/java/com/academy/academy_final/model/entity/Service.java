package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Service {
    @Id
    @Column(name = "service_number")
    private Integer serviceNumber;
    @Column
    private String serviceDescription;
    @Column
    private Float servicePrice;

   @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn (name = "service_organisation")
   private Organisation organisation;
}
