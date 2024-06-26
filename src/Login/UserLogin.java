package Login;
import java.io.IOException;
import java.lang.System.Logger.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserLogin extends Application {

    @Override
    public void start(Stage primaryStage){
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("UserLogin.fxml"));
        } catch (IOException ex){
            Logger.getLogger(UserLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

        Scene escena = new Scene(root);
        primaryStage.setScene(escena);
        primaryStage.show();
        
    }
    public static void main (String[] args){
        launch(args);
    }
}