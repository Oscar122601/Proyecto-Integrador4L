package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase para cargar la vista del buscador de ventas en una ventana.
 */
public class CargarBuscadorVenta {
    
    /**
     * Constructor de la clase.
     * @param st La ventana en la que se cargará la vista del buscador de ventas.
     */
    public CargarBuscadorVenta(Stage st) {
        try {
            // Carga el archivo FXML que contiene la estructura de la vista del buscador de ventas
            Parent root = FXMLLoader.load(getClass().getResource("/vista/BuscadorVenta.fxml"));
            
            // Crea una nueva escena con la vista cargada
            Scene sc = new Scene(root);
            
            // Establece la escena en la ventana especificada
            st.setScene(sc);
        } catch (IOException e) {
            // Maneja la excepción en caso de que ocurra un error al cargar la vista
            e.printStackTrace();
        }
    }
}
