module com.uni_eventos {
    requires javafx.controls;
    requires javafx.fxml;
    requires lombok;
    requires com.fasterxml.jackson.annotation;
    requires com.fasterxml.jackson.core;
    requires com.fasterxml.jackson.databind;
    requires java.mail;
    requires javafx.base;

    opens com.uni_eventos.controllers to javafx.fxml;

    exports com.uni_eventos.controllers to javafx.fxml;
    exports com.uni_eventos;
    exports com.uni_eventos.dao.evento;
    exports com.uni_eventos.dao.usuario;
    exports com.uni_eventos.dto;
    exports com.uni_eventos.models.compra;
    exports com.uni_eventos.models.cupon;
    exports com.uni_eventos.models.evento;
    exports com.uni_eventos.models.usuario;
    exports com.uni_eventos.service;
}
