package com.mega.demo.controller;

import com.mega.demo.dto.NasabahRequest;
import com.mega.demo.dto.NasabahResponse;
import com.mega.demo.model.Nasabah;
import com.mega.demo.service.NasabahService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nasabah")
public class NasabahController {

    private final NasabahService service;

    public NasabahController(NasabahService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<NasabahResponse> create(
            @RequestBody @Valid NasabahRequest request
    ) {
        return ResponseEntity.ok(service.create(request));
    }

    @GetMapping
    public List<NasabahResponse> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<NasabahResponse> findById(@PathVariable String id) {
        NasabahResponse resp = service.findById(id);
        return resp == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(resp);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NasabahResponse> update(
            @PathVariable String id,
            @RequestBody @Valid NasabahRequest request
    ) {
        NasabahResponse resp = service.update(id, request);
        return resp == null
                ? ResponseEntity.notFound().build()
                : ResponseEntity.ok(resp);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        return service.delete(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }
}