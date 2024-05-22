package com.uni_eventos.controllers;

import java.io.IOException;
import com.uni_eventos.App;
import com.uni_eventos.States;
import com.uni_eventos.dto.UsuarioDto;
import com.uni_eventos.service.UsuarioService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * LoginController
 */
public class LoguearController {

    private UsuarioService serivce = new UsuarioService();

    @FXML
    Label label;
    @FXML
    TextField email;
    @FXML
    TextField contraseña;

    public void loguear(ActionEvent e) {
        UsuarioDto us = serivce.loguearUsuario(email.getText(), contraseña.getText());
        if (us != null) {
            App.usuario = us;
            if (us.esAdmin()) {
                App.state = States.ADMIN;
                try {
                    App.setRoot("dashboardAdmin");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                App.state = States.LOG;
                try {
                    App.setRoot("dashboardLogIn");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        label.setText("No se ha podido iniciar sesion");
    }

    public void registrar(ActionEvent e) {
        try {
            App.setRoot("signUp");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

}