package com.mega.demo.dto;

public record ProductRequest(
        String name,
        Double price,
        String branchId
) {}
