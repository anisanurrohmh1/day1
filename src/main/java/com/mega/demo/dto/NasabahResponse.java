package com.mega.demo.dto;

import lombok.Builder;


@Builder
public record NasabahResponse(
        String id,
        String nama,
        String email,
        String phone,
        String noKtp
) {}