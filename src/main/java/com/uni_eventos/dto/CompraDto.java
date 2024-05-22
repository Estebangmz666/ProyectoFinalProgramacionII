package com.uni_eventos.dto;

import java.util.UUID;

public record CompraDto(
        int id,
        int usuarioId,
        int eventoId,
        int cantidad,
        int cuponId,
        UUID codigoFactura
        ) {
}