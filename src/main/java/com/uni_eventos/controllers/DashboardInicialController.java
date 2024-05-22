package com.uni_eventos.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.uni_eventos.App;
import com.uni_eventos.dto.EventoDto;
import com.uni_eventos.models.evento.Ciudad;
import com.uni_eventos.service.EventoService;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;

/**
 * DashboardInicialController
 */
public class DashboardInicialController implements Initializable {

    @FXML
    ChoiceBox<Ciudad> choiceBox;
    private Ciudad[] listaCiudades = { Ciudad.ARMENIA, Ciudad.BOGOTA, Ciudad.CALI, Ciudad.MEDELLIN, Ciudad.CARTAGENA,
            Ciudad.MANIZALES };

    @FXML
    ListView<String> listView;

    EventoService eventoService = new EventoService();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<EventoDto> eventos = eventoService.getAll();
        for (EventoDto evento : eventos) {
            listView.getItems().add(evento.nombre() + " - " + evento.ciudad() + " - " + evento.fecha());
        }
        listView.setCellFactory(TextFieldListCell.forListView());
        choiceBox.getItems().addAll(listaCiudades);
    }

    public void seleccion(ActionEvent e) {
    }

    public void loguear(ActionEvent e) {
        try {
            App.setRoot("logIn");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }

    public void registrar(ActionEvent e) {
        try {
            App.setRoot("signUp");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
        }
    }
}