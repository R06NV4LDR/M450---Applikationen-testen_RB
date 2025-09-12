package ch.roones.uebungen._04fourthday.controller;

import ch.roones.uebungen._04fourthday.repository.Address;
import ch.roones.uebungen._04fourthday.service.AddressService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AddressController.class)
class AddressControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    AddressService addressService;

    Address a1, a2;
    Date now;

    @BeforeEach
    void setUp() {
        now = new Date(0); // feste Zeit: 1970-01-01T00:00:00Z
        a1 = new Address(1, "Max", "Mustermann", "0791234567", now);
        a2 = new Address(2, "Anna", "Musterfrau", "0789876543", now);
    }

    @Test
    @DisplayName("POST /address creates and returns 201 with body")
    void createAddress_returns201() throws Exception {
        Mockito.when(addressService.save(any(Address.class))).thenReturn(a1);

        mockMvc.perform(post("/address")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(a1)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("Max")))
                .andExpect(jsonPath("$.lastname", is("Mustermann")))
                .andExpect(jsonPath("$.phonenumber", is("0791234567")));
    }

    @Test
    @DisplayName("GET /address returns 200 and list")
    void getAddresses_returnsList() throws Exception {
        List<Address> list = Arrays.asList(a1, a2);
        Mockito.when(addressService.getAll()).thenReturn(list);

        mockMvc.perform(get("/address"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(1)))
                .andExpect(jsonPath("$[0].firstname", is("Max")))
                .andExpect(jsonPath("$[1].id", is(2)))
                .andExpect(jsonPath("$[1].firstname", is("Anna")));
    }

    @Test
    @DisplayName("GET /address/{id} returns 200 when found")
    void getAddress_found() throws Exception {
        Mockito.when(addressService.getAddress(eq(1))).thenReturn(Optional.of(a1));

        mockMvc.perform(get("/address/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.firstname", is("Max")));
    }

    @Test
    @DisplayName("GET /address/{id} returns 404 when not found")
    void getAddress_notFound() throws Exception {
        Mockito.when(addressService.getAddress(eq(99))).thenReturn(Optional.empty());

        mockMvc.perform(get("/address/99"))
                .andExpect(status().isNotFound());
    }
}
