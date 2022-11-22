package modelo;
import java.util.ArrayList;

public class Administrativo extends Personal{
	
	private static ArrayList<Instalacion> instalacionesFinalizadas;
	private static ArrayList<Factura> facturas;
	
	public Administrativo(String nombre, String clave, TipoEmpleado tipo) {
		this.nroEmpleado = generador;
		generador++;
		this.nombre = nombre;
		this.clave = clave;
		this.tipo = tipo;
	}
	
	public void Facturar(Instalacion instalacion) {
		facturas.add(new Factura(instalacion));
	}
	
	public void ajustarInstalacion(Instalacion instalacion, int evap, int cond, int kits) {
		instalacion.setEquipamiento(evap, cond, kits);
	}
	
	public void imprimirFactura() {
		
	}
	
	public ArrayList<Factura> getFacturas(){
		return facturas;
	}

}
