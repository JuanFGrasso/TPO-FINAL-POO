package modelo;

public class Cliente {
	
	private int documento;
	private String nombre;
	private String direccion;
	private Agenda agenda;
	
	public Cliente(int documento, String nombre, String direccion) {
		this.documento = documento;
		this.nombre = nombre;
		this.direccion = direccion;
		agenda = new Agenda();
	}

	public int getDocumento() {
		return documento;
	}

	public void setDocumento(int documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Agenda getAgenda() {
		return agenda;
	}
	

}
