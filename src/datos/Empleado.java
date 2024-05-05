package datos;

public class Empleado {
		private String cedula;
		private String puesto;
		private String nombre;
		private String apellido;
		private String telefono;
		private String direccion;
		private boolean editado;
		public Empleado(String cedula, String puesto, String nombre, String apellido, String telefono, String direccion) {
			this.cedula = cedula;
			this.puesto = puesto;
			this.nombre = nombre;
			this.apellido = apellido;
			this.telefono =telefono ;
			this.direccion = direccion;
			this.editado = false;	
		}
		public String getCedula() {
			return cedula;
		}
		public void setCedula(String cedula) {
			this.cedula = cedula;
		}
		public String getPuesto() {
			return puesto;
		}
		public void setPuesto(String puesto) {
			this.puesto = puesto;
		}
		public String getNombre() {
			return nombre;
		}
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}
		public String getApellido() {
			return apellido;
		}
		public void setApellido(String apellido) {
			this.apellido = apellido;
		}
		public String getTelefono() {
			return telefono;
		}
		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}
		public String getDireccion() {
			return direccion;
		}
		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}
		public boolean isEditado() {
	        return editado;
	    }
	    public void setEditado(boolean editado) {
	        this.editado = editado;
	    }
}
