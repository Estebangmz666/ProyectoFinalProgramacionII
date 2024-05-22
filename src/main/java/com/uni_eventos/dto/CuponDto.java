package com.uni_eventos.dto;

public record CuponDto(
        int id,
        int descuento,
        boolean disponible) {
}