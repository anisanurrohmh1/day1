package com.mega.demo.dto;

public record ProductResponse(
        String id,
        String name,
        Double price,
        BranchResponse branch
) {}