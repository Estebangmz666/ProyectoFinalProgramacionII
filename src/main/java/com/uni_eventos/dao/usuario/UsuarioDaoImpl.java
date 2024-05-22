package com.uni_eventos.dao.usuario;

import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.models.usuario.Usuario;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.uni_eventos.models.usuario.UsuarioManager;

public class UsuarioDaoImpl implements UsuarioDao {

    public UsuarioDaoImpl() {
        UsuarioManager.cargarDatos();
    }

    @Override
    public Usuario agregarUsuario(UsuarioDto usuarioDto) {
        Optional<Usuario> us = filtrarCorreo(usuarioDto.email());
        Usuario nuevo = null;
        // Si el correo no se encuetra ya registrado
        if (!us.isPresent()) {
            nuevo = Usuario.builder().nombre(usuarioDto.nombre()).cedula(usuarioDto.cedula())
                    .telefono(usuarioDto.telefono()).email(usuarioDto.email()).contraseña(usuarioDto.contraseña()).id(0)
                    .build();
            List<Usuario> usuarios = UsuarioManager.getUsuarios(); // modifique la liste de usuarios
            usuarios.add(nuevo);// añada el nuevo usuario
            UsuarioManager.setUsuarios(usuarios); // guardelo
        }
        return nuevo;
    }

    @Override
    public Usuario getUsuario(String email) {
        Optional<Usuario> us = filtrarCorreo(email);
        Usuario usuario = null;
        if (us.isPresent()) { // Si se encuetra
            usuario = us.get();
        }
        return usuario;
    }

    @Override
    public boolean removerUsuario(int id) {
        boolean eliminado = false;
        Optional<Usuario> us = filtrarId(id);
        List<Usuario> nuevaLista = UsuarioManager.getUsuarios();
        if (us.isPresent()) {
            Predicate<Usuario> condicion = u -> u.getId() == us.get().getId();
            eliminado = nuevaLista.removeIf(condicion);
            UsuarioManager.setUsuarios(nuevaLista);
        }
        return eliminado;
    }

    private Optional<Usuario> filtrarCorreo(String email) {
        Predicate<Usuario> condicion = u -> u.getEmail().equals(email);
        Optional<Usuario> us = UsuarioManager.getUsuarios().stream().filter(condicion).findFirst();
        return us;
    }

    private Optional<Usuario> filtrarId(int idUsuario) {
        Predicate<Usuario> condicion = u -> u.getId() == idUsuario;
        return UsuarioManager.getUsuarios().stream().filter(condicion).findFirst();
    }

}
