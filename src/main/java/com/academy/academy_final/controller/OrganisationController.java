package com.academy.academy_final.controller;

import com.academy.academy_final.model.entity.Organisation;
import com.academy.academy_final.model.repository.OrganisationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrganisationController {

    private final OrganisationRepository organisationRepository;

    @GetMapping(value = "/organisations")
    public String org() {
        List<Organisation> orgs = organisationRepository.findAll();

        return "orgs";
    }
}
