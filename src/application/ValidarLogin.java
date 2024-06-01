package application;

import datos.Security;

/**
 * Clase que valida las credenciales de inicio de sesión y determina el puesto del usuario.
 */
public class ValidarLogin {
    private static String puesto;

    /**
     * Método para validar las credenciales de inicio de sesión.
     * @param usuario El nombre de usuario.
     * @param contraseña La contraseña del usuario.
     * @return El puesto del usuario si las credenciales son válidas, de lo contrario, devuelve null.
     */
    public static String Validar(String usuario, String contraseña) {
        // Verifica si tanto el nombre de usuario como la contraseña no están vacíos y si coinciden
        if (usuario.length() > 0 && contraseña.length() > 0 && usuario.equals(contraseña)) {
            // Utiliza la clase Security para determinar el puesto del usuario y lo convierte a mayúsculas
            puesto = Security.Seguridad(usuario).toUpperCase();
        }
        // Devuelve el puesto del usuario
        return puesto;
    }
}
