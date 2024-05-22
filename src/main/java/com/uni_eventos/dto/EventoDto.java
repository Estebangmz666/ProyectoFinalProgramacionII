package com.uni_eventos.dto;

import java.time.LocalDateTime;

import com.uni_eventos.models.evento.Ciudad;
import com.uni_eventos.models.evento.TipoEvento;

public record EventoDto(
                int id,
                String nombre,
                Ciudad ciudad,
                TipoEvento tipoEvento,
                LocalDateTime fecha,
                int costoEntrada,
                int entradasDisponibles,
                String imagenPath) {
}