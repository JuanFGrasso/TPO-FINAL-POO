package modelo;

public abstract class Equipamiento {
	
	protected double costo;
	protected int cantidad;
	
	public double getCosto() {
		return costo;
	}
	
	public void setCosto(double costo) {
		this.costo = costo;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void agregarCantidad(int cantidad) {
		this.cantidad = this.cantidad + cantidad;
	}
	
	public void consumirCantidad(int cantidad) {
		this.cantidad = this.cantidad - cantidad;
	}
	
	public void cantidadActual() {
		System.out.println("Evaporadoras: " + Evaporador.getInstance().getCantidad());
		System.out.println("Condensadoras: " + Condensador.getInstance().getCantidad());
		System.out.println("KitInstalacion: " + KitInstalacion.getInstance().getCantidad());
	}
	
}
