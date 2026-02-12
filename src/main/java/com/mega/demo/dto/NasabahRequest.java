package com.mega.demo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;


@Builder
public record NasabahRequest(
        @NotBlank String nama,
        @Email @NotBlank String email,
        @NotBlank String phone,
        @NotBlank String noKtp
) {}