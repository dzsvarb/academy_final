package com.academy.academy_final.service;


import com.academy.academy_final.model.entity.Service;

import java.util.List;

public interface ServiceService {

    List<Service> getAllService ();
    Service getServiceByServiceNumber (Integer serviceNumber);
}
