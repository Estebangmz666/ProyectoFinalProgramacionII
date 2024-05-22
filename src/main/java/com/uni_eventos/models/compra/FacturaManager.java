package com.uni_eventos.models.compra;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FacturaManager {
    private static final String pathInfo = "src/main/resources/com/uni_eventos/db/facturas.json";
    private static List<Factura> facturas;

    public static void cargarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            facturas = objectMapper.readValue(new File(pathInfo), new TypeReference<List<Factura>>() {
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarDatos() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(pathInfo), facturas);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Factura> getFacturas() {
        return facturas;
    }

    public static void setFacturas(List<Factura> facturas) {
        FacturaManager.facturas = facturas;
        guardarDatos(); // Guardar datos inmediatamente después de modificar
    }
}
