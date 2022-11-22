package modelo;

public abstract class Personal {
	
	static int generador = 0;
	protected int nroEmpleado;
	protected String clave;
	protected String nombre;
	protected TipoEmpleado tipo;
	
	public int getNroEmpleado() {
		return nroEmpleado;
	}
	
	public void setClave(String clave) {
		this.clave = clave;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public TipoEmpleado getTipo() {
		return tipo;
	}
	
	public boolean validarClave(String clave) {
		return (this.clave.equals(clave));
	}
	
	
}
