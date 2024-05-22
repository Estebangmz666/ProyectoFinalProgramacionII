package com.uni_eventos.dto;

import java.time.LocalDate;
import java.util.UUID;

public record FacturaDto(
        UUID codigo,
        LocalDate fecha,
        int subTotal,
        int total) {
}