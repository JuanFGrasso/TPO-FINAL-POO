package modelo;

public class Factura {
	
	private Instalacion instalacion;
	
	public Factura(Instalacion instalacion) {
		this.instalacion = instalacion;
	}
	
	public Instalacion getInstalacion() {
		return instalacion;
	}

}
