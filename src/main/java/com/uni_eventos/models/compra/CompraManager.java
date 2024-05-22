package com.uni_eventos.models.compra;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompraManager {
    private static final String pathInfo = "src/main/resources/com/uni_eventos/db/compras.json";
    private static List<Compra> compras;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            compras = objectMapper.readValue(new File(pathInfo), new TypeReference<List<Compra>>() {
            });
            // Seguir con el conteo del id
            if (compras.size() > 0) {
                Compra com = compras.get(compras.size() - 1);
                Compra.setContador(com.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathInfo), compras);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Compra> getCompras() {
        return compras;
    }

    public static void setCompras(List<Compra> compras) {
        CompraManager.compras = compras;
        guardarDatos(); // Guardar datos inmediatamente después de modificar
    }
}
