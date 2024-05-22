package com.uni_eventos.controllers;

import java.io.IOException;

import com.uni_eventos.App;
import com.uni_eventos.States;
import com.uni_eventos.dto.CuponDto;
import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.email_service.EmailManager;
import com.uni_eventos.email_service.GeneradorCodigo;
import com.uni_eventos.service.CuponService;
import com.uni_eventos.service.UsuarioService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VerificacionController {

    @FXML
    TextField verificacion;

    UsuarioService usuarioService = new UsuarioService();
    CuponService cuponServicio = new CuponService();

    public void verificar(ActionEvent e) {
        String codigo = GeneradorCodigo.getGeneratedCode();
        System.out.println(codigo);
        if (codigo.equals(verificacion.getText())) {
            CuponDto cupon = cuponServicio.crearCupon(15, true);
            UsuarioDto us = App.usuario;
            App.state = States.LOG;
            usuarioService.registrarUsuario(us.nombre(), us.telefono(), us.cedula(), us.email(), us.contraseña());
            EmailManager.enviarCuponBienvenida(us.email(), cupon.id());
            try {
                App.setRoot("dashboardLogIn");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}
