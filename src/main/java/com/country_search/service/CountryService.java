package com.country_search.service;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final RestTemplate restTemplate;

    private final String ALL_COUNTRIES_URL =
            "https://restcountries.com/v3.1/all?fields=name";

    private final String CAPITAL_BY_NAME_URL =
            "https://restcountries.com/v3.1/name/%s?fields=capital";

    public List<String> getAllCountryNames() {

        try {
            ResponseEntity<List<Map<String, Object>>> response =
                    restTemplate.exchange(
                            ALL_COUNTRIES_URL,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<>() {}
                    );

            return response.getBody().stream()
                    .map(country -> {
                        Map<String, Object> name = (Map<String, Object>) country.get("name");
                        return (String) name.get("common");
                    })
                    .sorted()
                    .toList();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar países", e);
        }
    }

    public String getCapitalByCountry(String countryName) {

        try {
            String encodedName = URLEncoder.encode(countryName, StandardCharsets.UTF_8);
            String url = String.format(CAPITAL_BY_NAME_URL, encodedName);

            ResponseEntity<List<Map<String, Object>>> response =
                    restTemplate.exchange(
                            url,
                            HttpMethod.GET,
                            null,
                            new ParameterizedTypeReference<>() {}
                    );

            return response.getBody().stream()
                    .findFirst()
                    .map(country -> {
                        List<String> capitals = (List<String>) country.get("capital");
                        return capitals != null && !capitals.isEmpty()
                                ? capitals.get(0)
                                : "Capital not found";
                    })
                    .orElse("Country not found");

        } catch (Exception e) {
            throw new RuntimeException("Erro ao buscar capital", e);
        }
    }
}
