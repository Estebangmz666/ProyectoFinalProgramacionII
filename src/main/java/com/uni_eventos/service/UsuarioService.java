package com.uni_eventos.service;

import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.models.usuario.Usuario;
import com.uni_eventos.dao.usuario.UsuarioDao;
import com.uni_eventos.dao.usuario.UsuarioDaoImpl;

public class UsuarioService {
    private UsuarioDao usuarioDao = new UsuarioDaoImpl();

    public UsuarioDto registrarUsuario(String nombre, String telefono, String cedula, String email, String contraseña) {
        UsuarioDto usuarioDto = new UsuarioDto(0, nombre, cedula, telefono, email, contraseña, false, null);
        Usuario us = usuarioDao.agregarUsuario(usuarioDto);
        if (us != null) {
            usuarioDto = convertirADto(us);
        } else {
            usuarioDto = null;
        }
        return usuarioDto;
    }

    public UsuarioDto loguearUsuario(String email, String contraseña) {
        UsuarioDto usuarioDto = new UsuarioDto(0, null, null, null, email, contraseña, false, null);
        Usuario us = usuarioDao.getUsuario(email);
        if (us != null) {
            if (us.getContraseña().equals(usuarioDto.contraseña())) {
                usuarioDto = convertirADto(us);
            } else {
                usuarioDto = null;
            }
        } else {
            usuarioDto = null;
        }
        return usuarioDto;
    }

    public boolean verificarUsuarioExiste(String email) {
        boolean existe = false;
        if (usuarioDao.getUsuario(email) != null) {
            existe = true;
        }
        return existe;
    }

    private UsuarioDto convertirADto(Usuario usuario) {
        return new UsuarioDto(usuario.getId(), usuario.getNombre(), usuario.getCedula(), usuario.getTelefono(),
                usuario.getEmail(), usuario.getContraseña(), usuario.getEsAdmin(), usuario.getComprasId());
    }

    private Usuario convertirAUsuario(UsuarioDto usuario) {
        return new Usuario(usuario.id(), usuario.nombre(), usuario.cedula(), usuario.telefono(),
                usuario.email(), usuario.contraseña(), usuario.esAdmin(), usuario.comprasId());
    }

}
