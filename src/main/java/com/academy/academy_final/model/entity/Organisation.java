package com.academy.academy_final.model.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Organisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer organisationId;
    @Column
    private String organisationName;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_address", referencedColumnName = "address_id")
    private Address organisationAddress;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "organisation_account", referencedColumnName = "account_number")
    private Account organisationAccount;

     @OneToMany (mappedBy = "organisation")
    private List<Service> services;

}
