package com.uni_eventos.models.cupon;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CuponManager {
    private static final String pathInfo = "src/main/resources/com/uni_eventos/db/cupones.json";
    private static List<Cupon> cupones;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            cupones = objectMapper.readValue(new File(pathInfo), new TypeReference<List<Cupon>>() {
            });
            // Seguir con el conteo del id
            if (cupones.size() > 0) {
                Cupon cupon = cupones.get(cupones.size() - 1);
                Cupon.setContador(cupon.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathInfo), cupones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Cupon> getCupones() {
        return cupones;
    }

    public static void setCupones(List<Cupon> cupones) {
        CuponManager.cupones = cupones;
        guardarDatos(); // Guardar datos inmediatamente después de modificar
    }
}
