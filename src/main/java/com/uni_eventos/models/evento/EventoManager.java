package com.uni_eventos.models.evento;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventoManager {
    private static final String pathInfo = "src/main/resources/com/uni_eventos/db/eventos.json";
    private static List<Evento> eventos;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            eventos = objectMapper.readValue(new File(pathInfo), new TypeReference<List<Evento>>() {
            });
            // Seguir con el conteo del id
            if (eventos.size() > 0) {
                Evento even = eventos.get(eventos.size() - 1);
                Evento.setContador(even.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathInfo), eventos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Evento> getEventos() {
        return eventos;
    }

    public static void setEventos(List<Evento> eventos) {
        EventoManager.eventos = eventos;
        guardarDatos(); // Guardar datos inmediatamente después de modificar
    }
}
