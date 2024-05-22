package com.uni_eventos.models.usuario;

import java.util.List;
import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UsuarioManager {
    private static final String pathInfo = "src/main/resources/com/uni_eventos/db/users.json";
    private static List<Usuario> usuarios;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            usuarios = objectMapper.readValue(new File(pathInfo), new TypeReference<List<Usuario>>() {
            });
            // Seguir con el conteo del id
            if (usuarios.size() > 0) {
                Usuario us = usuarios.get(usuarios.size() - 1);
                Usuario.setContador(us.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathInfo), usuarios);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static void setUsuarios(List<Usuario> usuarios) {
        UsuarioManager.usuarios = usuarios;
        guardarDatos(); // Guardar datos inmediatamente después de modificar
    }
}
