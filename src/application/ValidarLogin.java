package application;

import datos.Security;

public class ValidarLogin {
	private static String puesto;

	public static String Validar(String usuario, String contraseña) {
		if (usuario.length()>0 && contraseña.length() >0 && usuario.equals(contraseña)) {
			puesto = Security.Seguridad(usuario).toUpperCase();}
		return puesto;}}