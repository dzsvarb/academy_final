package com.academy.academy_final.model.repository;

import com.academy.academy_final.model.entity.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ServiceRepository extends JpaRepository<Service, Integer> {
 Service getServiceByServiceNumber(Integer servicesNumber);
}
