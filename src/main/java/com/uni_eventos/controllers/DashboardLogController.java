package com.uni_eventos.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.uni_eventos.App;
import com.uni_eventos.States;
import com.uni_eventos.models.evento.Ciudad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class DashboardLogController implements Initializable {

    @FXML
    ChoiceBox<Ciudad> choiceBox;
    private Ciudad[] listaCiudades = { Ciudad.ARMENIA, Ciudad.BOGOTA, Ciudad.CALI, Ciudad.MEDELLIN, Ciudad.CARTAGENA,
            Ciudad.MANIZALES };

    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void seleccion(ActionEvent e) {
        try {
            App.setRoot("dashboard");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
