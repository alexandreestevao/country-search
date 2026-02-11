package com.country_search.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.client.RestTemplate;

@ExtendWith(MockitoExtension.class)
class CountryServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private CountryService countryService;

    @Test
    void shouldReturnCountryList() {
        // mock do retorno da API
        // validar lista retornada
    }
}