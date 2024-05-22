package com.uni_eventos.models.cupon;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Cupon {
    private static int contadorObjetos;
    private int id;
    private int descuento;
    private boolean disponible;

    public Cupon() {

    }

    // Constructor
    public Cupon(int id, int descuento, boolean disponible) {
        if (id == 0) {
            int idNuevo = ++Cupon.contadorObjetos;
            Cupon.contadorObjetos = idNuevo;
            this.id = idNuevo;
        } else {
            this.id = id;
        }
        this.descuento = descuento;
        this.disponible = disponible;
    }

    public static void setContador(int num) {
        contadorObjetos = num;
    }

    // Método para calcular el total con descuento
    public int calcularDescuento(int precio) {
        int total = precio - (precio * descuento / 100);
        return total;
    }

    public static CuponBuilder builder() {
        return new CuponBuilder();
    }

    public static class CuponBuilder {
        private int id;
        private int descuento;
        private boolean disponible;

        public CuponBuilder() {
        }

        public CuponBuilder id(int id) {
            this.id = id;
            return this;
        }

        public CuponBuilder descuento(int descuento) {
            this.descuento = descuento;
            return this;
        }

        public CuponBuilder disponible(boolean disponible) {
            this.disponible = disponible;
            return this;
        }

        public Cupon build() {
            return new Cupon(id, descuento, disponible);
        }
    }

}