package com.uni_eventos.controllers;

import java.io.IOException;

import com.uni_eventos.App;
import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.email_service.EmailManager;
import com.uni_eventos.service.UsuarioService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * SignUpController
 */
public class RegistrarController {

    UsuarioService usuarioService = new UsuarioService();

    @FXML
    TextField cedula;
    @FXML
    TextField nombre;
    @FXML
    TextField telefono;
    @FXML
    TextField email;
    @FXML
    TextField contraseña;
    @FXML
    Label cabecero;

    public void registrar(ActionEvent e) {
        UsuarioDto dto = new UsuarioDto(0, nombre.getText(), telefono.getText(), cedula.getText(),
                email.getText(), contraseña.getText(), false, null);

        if (!usuarioService.verificarUsuarioExiste(email.getText())) {
            if (!dto.nombre().isEmpty() && !dto.telefono().isEmpty() && !dto.cedula().isEmpty()
                    && !dto.email().isEmpty()
                    && !dto.contraseña().isEmpty()) {
                EmailManager.enviarCorreoConfirmacion(dto.email());
                App.usuario = dto;
                try {
                    App.setRoot("verificacion");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                cabecero.setText("Error al procesar el registro");
            }
        } else {
            cabecero.setText("Error al procesar el registro");
        }
    }

    public void loguear(ActionEvent e) {
        try {
            App.setRoot("logIn");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}