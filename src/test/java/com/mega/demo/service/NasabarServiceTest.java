package com.mega.demo.service;


import com.mega.demo.dto.NasabahRequest;
import com.mega.demo.dto.NasabahResponse;
import com.mega.demo.entity.Nasabah;
import com.mega.demo.repository.NasabahRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class NasabarServiceTest {

    @Mock
    private NasabahRepo repository;

    @InjectMocks
    private  NasabahService nasabahService;

    @Test
    void shouldCreatenasabah(){

        NasabahRequest nasabahRequest = NasabahRequest.builder()
                .email("anisa@mail.com")
                .noKtp("123123123123123")
                .phone("021727172")
                .nama("anisa").build();


        Nasabah nasabah = new Nasabah("anisa","anisa@mail.com", "021727172", "123123123123123");

        nasabah.setId("123");
        when(repository.save(any(Nasabah.class))).thenReturn(nasabah);

        NasabahResponse result = nasabahService.create(nasabahRequest);
        assertNotNull(result);
        assertEquals(nasabah.getNama(), result.nama());

    }


}
