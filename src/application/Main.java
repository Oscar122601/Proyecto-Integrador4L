package application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Clase principal que inicia la aplicación.
 */
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) {
        try {
            // Cargar la vista Login.fxml
            Parent root = FXMLLoader.load(getClass().getResource("/vista/Login.fxml"));
            Scene scene = new Scene(root);
            // Agregar una hoja de estilo CSS
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            // Configurar la escena en el escenario principal
            primaryStage.setScene(scene);
            // Mostrar el escenario principal
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Método principal que inicia la aplicación.
     * @param args Los argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
