package com.academy.academy_final.service.impl;

import com.academy.academy_final.model.entity.Service;
import com.academy.academy_final.model.repository.ServiceRepository;
import com.academy.academy_final.service.ServiceService;
import lombok.RequiredArgsConstructor;

import java.util.List;


@org.springframework.stereotype.Service
@RequiredArgsConstructor
public class ServiceServiceImpl implements ServiceService {
    private final ServiceRepository serviceRepository;


    @Override
    public List<Service> getAllService() {
        return serviceRepository.findAll();
    }

    @Override
    public Service getServiceByServiceNumber(Integer serviceNumber) {
        return serviceRepository.getServiceByServiceNumber(serviceNumber);
    }
}
