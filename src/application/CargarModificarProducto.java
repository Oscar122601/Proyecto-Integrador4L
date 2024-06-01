package application;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Clase para cargar la vista de modificación de producto en una ventana.
 */
public class CargarModificarProducto {
    
    /**
     * Constructor de la clase.
     * @param st La ventana en la que se cargará la vista de modificación de producto.
     */
    public CargarModificarProducto(Stage st) {
        try {
            // Carga el archivo FXML que contiene la estructura de la vista de modificación de producto
            Parent root = FXMLLoader.load(getClass().getResource("/vista/ModificarProducto.fxml"));
            
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
