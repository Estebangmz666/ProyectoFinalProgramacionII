package com.uni_eventos.dao.usuario;

import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.models.usuario.Usuario;

public interface UsuarioDao {
    Usuario agregarUsuario(UsuarioDto usuarioDto);

    boolean removerUsuario(int id);

    Usuario getUsuario(String email);
}
