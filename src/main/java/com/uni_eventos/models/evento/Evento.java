package com.uni_eventos.models.evento;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Evento {
    private static int contadorObjetos = 0;
    private int id;
    private String nombre;
    private Ciudad ciudad;
    private TipoEvento tipoEvento;
    private LocalDateTime fecha;
    private int costoEntrada;
    private int entradasDisponibles;
    private String imagenPath;

    public Evento() {

    }

    public Evento(int id, String nombre, Ciudad ciudad, TipoEvento tipoEvento, LocalDateTime fecha, int costoEntrada,
            int entradasDisponibles, String imagenPath) {
        if (id != 0) {
            this.id = id;
        } else {
            int idNuevo = ++Evento.contadorObjetos;
            Evento.contadorObjetos = idNuevo;
            this.id = idNuevo;
        }
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.costoEntrada = costoEntrada;
        this.entradasDisponibles = entradasDisponibles;
        this.imagenPath = imagenPath;
    }

    public static void setContador(int num) {
        Evento.contadorObjetos = num;
    }

    public void setEntradasDisponibles(int entradasVendidas) {
        this.entradasDisponibles = this.entradasDisponibles - entradasVendidas;
    }

    public static EventoBuilder builder() {
        return new EventoBuilder();
    }

    public static class EventoBuilder {
        private int id;
        private String nombre;
        private Ciudad ciudad;
        private TipoEvento tipoEvento;
        private LocalDateTime fecha;
        private int costoEntrada;
        private int entradasDisponibles;
        private String imagenPath;

        public EventoBuilder() {
        }

        public EventoBuilder id(int id) {
            this.id = id;
            return this;
        }

        public EventoBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public EventoBuilder ciudad(Ciudad ciudad) {
            this.ciudad = ciudad;
            return this;
        }

        public EventoBuilder tipoEvento(TipoEvento tipoEvento) {
            this.tipoEvento = tipoEvento;
            return this;
        }

        public EventoBuilder fecha(LocalDateTime fecha) {
            this.fecha = fecha;
            return this;
        }

        public EventoBuilder costoEntrada(int costoEntrada) {
            this.costoEntrada = costoEntrada;
            return this;
        }

        public EventoBuilder entradasDisponibles(int entradasDisponibles) {
            this.entradasDisponibles = entradasDisponibles;
            return this;
        }

        public EventoBuilder imagenPath(String imagenPath) {
            this.imagenPath = imagenPath;
            return this;
        }

        public Evento build() {
            return new Evento(id, nombre, ciudad, tipoEvento, fecha, costoEntrada, entradasDisponibles, imagenPath);
        }
    }

}
