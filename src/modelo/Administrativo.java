package modelo;
import java.util.ArrayList;

public class Administrativo extends Personal{
	
	private static ArrayList<Instalacion> instalacionCanceladas = new ArrayList<Instalacion>();
	private static ArrayList<Instalacion> instalacionFinalizadas = new ArrayList<Instalacion>();
	private static ArrayList<Factura> facturas = new ArrayList<Factura>();
	
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
	public static ArrayList<Factura> getFacturas(){
		return facturas;
	}
	
	public static void agregarInstalacionFinalizada(Instalacion instalacion) {
		instalacionFinalizadas.add(instalacion);
	}
	
	public static Instalacion obtenerInstalacionF(int nroInstalacion) {
		Instalacion instalacion = null;
		for (Instalacion i: instalacionFinalizadas) {
			if (i.getNroInstalacion() == nroInstalacion) {
				instalacion = i;
			}
		}
		return instalacion;
	}
	
	public static ArrayList<Instalacion> getInstalacionesFinalizadas(){
		return instalacionFinalizadas;
	}
	
	public static void agregarInstalacionCancelada(Instalacion instalacion) {
		instalacionCanceladas.add(instalacion);
	}
	
	public static ArrayList<Instalacion> getInstalacionesCanceladas(){
		return instalacionCanceladas;
	}

}
