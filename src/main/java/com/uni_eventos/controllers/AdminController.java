package com.uni_eventos.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import com.uni_eventos.models.evento.Ciudad;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;

public class AdminController implements Initializable {
    @FXML
    ChoiceBox<Ciudad> choiceBox;
    private Ciudad[] listaCiudades = { Ciudad.ARMENIA, Ciudad.BOGOTA, Ciudad.CALI, Ciudad.MEDELLIN, Ciudad.CARTAGENA,
            Ciudad.MANIZALES };

    @FXML

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        choiceBox.getItems().addAll(listaCiudades);
    }
}
