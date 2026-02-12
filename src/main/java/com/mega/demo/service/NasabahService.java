package com.mega.demo.service;

import com.mega.demo.dto.NasabahRequest;
import com.mega.demo.dto.NasabahResponse;
import com.mega.demo.entity.Nasabah;
import com.mega.demo.repository.NasabahRepo;
import org.springframework.stereotype.Service;

import java.util.*;


import java.util.List;

@Service
public class NasabahService {

    private final NasabahRepo repository;

    public NasabahService(NasabahRepo repository) {
        this.repository = repository;
    }

    public NasabahResponse create(NasabahRequest request) {
        Nasabah nasabah =
//                Nasabah.builder()
//                .nama(request.nama())
//                .email(request.email())
//                .phone(request.phone())
//                .noKtp(request.noKtp()).build();
                new Nasabah(
                request.nama(),
                request.email(),
                request.phone(),
                request.noKtp()
        );
        Nasabah result = repository.save(nasabah);
        return toResponse(result);
    }

    public List<NasabahResponse> findAll() {
        return repository.findAll()
                .stream()
                .map(this::toResponse)
                .toList();
    }

    public NasabahResponse findById(String id) {
        return repository.findById(id)
                .map(this::toResponse)
                .orElse(null);
    }

    public NasabahResponse update(String id, NasabahRequest request) {
        Nasabah nasabah = repository.findById(id).orElse(null);
        if (nasabah == null) return null;

        nasabah.setNama(request.nama());
        nasabah.setEmail(request.email());
        nasabah.setPhone(request.phone());
        nasabah.setNoKtp(request.noKtp());

        return toResponse(repository.save(nasabah));
    }

    public boolean delete(String id) {
        if (!repository.existsById(id)) return false;
        repository.deleteById(id);
        return true;
    }

    private NasabahResponse toResponse(Nasabah n) {
        return new NasabahResponse(
                n.getId(),
                n.getNama(),
                n.getEmail(),
                n.getPhone(),
                n.getNoKtp()
        );
    }
}