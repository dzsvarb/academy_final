package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
