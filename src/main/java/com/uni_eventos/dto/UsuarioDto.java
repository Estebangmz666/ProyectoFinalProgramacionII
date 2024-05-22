package com.uni_eventos.dto;

import java.util.List;

public record UsuarioDto(
                int id,
                String nombre,
                String cedula,
                String telefono,
                String email,
                String contraseña,
                boolean esAdmin,
                List<Integer> comprasId) {
}