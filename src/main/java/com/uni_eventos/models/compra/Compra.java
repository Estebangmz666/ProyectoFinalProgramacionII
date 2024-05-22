package com.uni_eventos.models.compra;

import java.util.UUID;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Compra {
    private static int contadorObjetos = 0;
    private int id;
    private int usuarioId;
    private int eventoId;
    private int cantidad;
    private int cuponId;
    private UUID codigoFactura;

    // Constructor vacío
    public Compra() {
    }

    // Constructor sin id
    public Compra(int id, int usuarioId, int eventoId, int cantidad, int cuponId, UUID factura) {
        if (id == 0) {
            int idNuevo = ++Compra.contadorObjetos;
            Compra.contadorObjetos = idNuevo;
            this.id = idNuevo;
        } else {
            this.id = id;
        }
        this.usuarioId = usuarioId;
        this.eventoId = eventoId;
        this.cantidad = cantidad;
        this.cuponId = cuponId;
        this.codigoFactura = factura;
    }

    public static void setContador(int num) {
        Compra.contadorObjetos = num;
    }

    public static CompraBuilder builder() {
        return new CompraBuilder();
    }

    public static class CompraBuilder {
        private int usuarioId;
        private int eventoId;
        private int cantidad;
        private int cuponId;
        private UUID codigoFactura;

        public CompraBuilder() {
        }

        public CompraBuilder usuarioId(int usuarioId) {
            this.usuarioId = usuarioId;
            return this;
        }

        public CompraBuilder eventoId(int eventoId) {
            this.eventoId = eventoId;
            return this;
        }

        public CompraBuilder cantidad(int cantidad) {
            this.cantidad = cantidad;
            return this;
        }

        public CompraBuilder cuponId(int cuponId) {
            this.cuponId = cuponId;
            return this;
        }

        public CompraBuilder codigoFactura(UUID codigoFactura) {
            this.codigoFactura = codigoFactura;
            return this;
        }

        public Compra build() {
            return new Compra(usuarioId, usuarioId, eventoId, cantidad, cuponId, codigoFactura);
        }
    }

}