package com.country_search.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.country_search.service.CountryService;

import java.util.List;

@RestController
@RequestMapping("/api/countries")
@RequiredArgsConstructor
@CrossOrigin
public class CountryController {

    private final CountryService countryService;

    @GetMapping
    public List<String> getAllCountries() {
        return countryService.getAllCountryNames();
    }

    @GetMapping("/{name}/capital")
    public String getCapital(@PathVariable String name) {
        return countryService.getCapitalByCountry(name);
    }
}
