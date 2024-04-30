module ProyectoIntegrador {
	requires javafx.controls;
	requires javafx.fxml;
	requires java.sql;
	
	opens application to javafx.graphics, javafx.fxml;
	opens vista to javafx.graphics, javafx.fxml, javafx.base;
	opens datos to javafx.graphics, javafx.fxml, javafx.base;
}
