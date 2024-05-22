package com.uni_eventos.models.compra;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
public class Factura {
    private UUID codigo;
    private LocalDate fecha;
    private int subTotal;
    private int total;

    // Constructor vacío
    public Factura() {
        // Constructor vacío necesario para Lombok
    }

    // Constructor sin codigo
    public Factura(UUID codigo, LocalDate fecha, int subTotal, int total) {
        if (codigo != null) {
            this.codigo = codigo;
            this.fecha = fecha;
            this.subTotal = subTotal;
            this.total = total;
        } else {
            this.codigo = UUID.randomUUID(); // Generar un UUID único para el código
            this.fecha = fecha;
        }
    }

    public void calcularTotal(int descuento) {
        this.setTotal(this.subTotal - descuento);
    }

    public void calcularSubTotal(int costo, int cantidad) {
        this.setSubTotal(cantidad * costo);
    }

    public static FacturaBuilder builder() {
        return new FacturaBuilder();
    }

    public static class FacturaBuilder {
        private LocalDate fecha = null;
        private UUID codigo = null;
        private int subTotal = 0;
        private int total = 0;

        public FacturaBuilder fecha(LocalDate fecha) {
            this.fecha = fecha;
            return this;
        }

        public FacturaBuilder codigo(UUID codigo) {
            this.codigo = codigo;
            return this;
        }

        public FacturaBuilder subTotal(int subTotal) {
            this.subTotal = subTotal;
            return this;
        }

        public FacturaBuilder total(int total) {
            this.total = total;
            return this;
        }

        public Factura build() {
            return new Factura(codigo, fecha, subTotal, total);
        }
    }
}