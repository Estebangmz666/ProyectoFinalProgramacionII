package com.uni_eventos.models.usuario;

import lombok.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.ArrayList;

@Getter
@Setter
@ToString
public class Usuario {
    private static int contadorObjetos = 0;
    private int id;
    private String nombre;
    private String cedula;
    private String telefono;
    private String email;
    private String contraseña;
    private boolean esAdmin;
    private List<Integer> comprasId;

    public Usuario() {
    }

    public Usuario(int idUs, String nombre, String cedula, String telefono, String email, String contraseña,
            boolean esAdmin,
            List<Integer> comprasId) {

        if (idUs == 0) {
            int idNuevo = ++Usuario.contadorObjetos;
            Usuario.contadorObjetos = idNuevo;
            this.id = idNuevo;
        } else {
            this.id = idUs;
        }
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.email = email;
        this.contraseña = contraseña;
        if (esAdmin) {
            this.esAdmin = true;
        } else {
            this.esAdmin = false;
        }
        if (comprasId != null) {
            this.comprasId = comprasId;
        } else {
            this.comprasId = new ArrayList<>();
        }
    }

    public static void setContador(int num) {
        System.out.println(num);
        Usuario.contadorObjetos = num;
    }

    public boolean getEsAdmin() {
        return esAdmin;
    }

    public void añadirCompra(int idCompra) {
        this.comprasId.add(idCompra);
    }

    public void eliminarCompra(int idCompra) {
        List<Integer> lista = this.getComprasId();
        Predicate<Integer> condicion = i -> i == idCompra;
        lista.removeIf(condicion);
        this.setComprasId(lista);
    }

    public static UsuarioBuilder builder() {
        return new UsuarioBuilder();
    }

    public static class UsuarioBuilder {
        private int id;
        private String nombre;
        private String cedula;
        private String telefono;
        private String email;
        private String contraseña;
        private boolean esAdmin;
        private List<Integer> comprasId;

        public UsuarioBuilder() {
        }

        public UsuarioBuilder id(int id) {
            this.id = id;
            return this;
        }

        public UsuarioBuilder nombre(String nombre) {
            this.nombre = nombre;
            return this;
        }

        public UsuarioBuilder cedula(String cedula) {
            this.cedula = cedula;
            return this;
        }

        public UsuarioBuilder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public UsuarioBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UsuarioBuilder contraseña(String contraseña) {
            this.contraseña = contraseña;
            return this;
        }

        public UsuarioBuilder esAdmin(boolean esAdmin) {
            this.esAdmin = esAdmin;
            return this;
        }

        public UsuarioBuilder comprasId(List<Integer> comprasId) {
            this.comprasId = comprasId;
            return this;
        }

        public Usuario build() {
            return new Usuario(id, nombre, cedula, telefono, email, contraseña, esAdmin, comprasId);
        }
    }
}