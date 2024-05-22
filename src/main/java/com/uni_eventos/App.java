package com.uni_eventos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import com.uni_eventos.dto.UsuarioDto;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static States state;
    public static UsuarioDto usuario;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("dashboardInicial"));
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public void setState(States state) {
        App.state = state;
    }

    public static void main(String[] args) {
        launch();
    }

}