package VerificacionEmail;

import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;

import Login.UserLogin;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class VerificacionEmail extends Application{

    @Override
    public void start(Stage primaryStage){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("VerificacionEmail.fxml"));
        } catch (IOException ex){
            Logger.getLogger(VerificacionEmail.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.show();
        
    }
    public static void main (String[] args){
        launch(args);
    }
    
}