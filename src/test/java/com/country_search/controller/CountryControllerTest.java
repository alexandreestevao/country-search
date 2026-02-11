package com.country_search.controller;

import com.country_search.service.CountryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(CountryController.class)
class CountryControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CountryService countryService;

    @Test
    void shouldReturnCapital() throws Exception {
        when(countryService.getCapitalByCountry("Brazil"))
                .thenReturn("Brasília");

        mockMvc.perform(get("/api/countries/Brazil/capital"))
                .andExpect(status().isOk())
                .andExpect(content().string("Brasília"));
    }
}

