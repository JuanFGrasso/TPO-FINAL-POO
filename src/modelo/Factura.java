package modelo;

public class Factura {
	
	private static int generador = 0;
	private int nroFactura;
	private Instalacion instalacion;
	private int costo;
	
	public Factura(Instalacion instalacion) {
		this.nroFactura = generador;
		this.instalacion = instalacion;
		calcularCostos();
		generador++;
	}
	
	public Instalacion getInstalacion() {
		return instalacion;
	}
	
	public void calcularCostos() {
		int[] equipamiento = instalacion.getEquipamiento();
		int[] tiempos = instalacion.getTiempos();
		int costoe = (int) (equipamiento[0] * Evaporador.getInstance().getCosto() + equipamiento[1] * Condensador.getInstance().getCosto() + equipamiento[2] * KitInstalacion.getInstance().getCosto());
		int costot;
		if (instalacion.getTecnico().getNivel().equals(NivelTecnico.JUNIOR)) {
			costot = tiempos[2] * Tecnico.getCostoHoraJunior();
		} else if (instalacion.getTecnico().getNivel().equals(NivelTecnico.SEMISENIOR)) {
			costot = tiempos[2] * Tecnico.getCostoHoraSemi();
		} else {
			costot = tiempos[2] * Tecnico.getCostoHoraSenior();
		}
		
		this.costo = costoe + costot;
	}
	
	public int getCosto() {
		return costo;
	}
	
	public int getNroFactura() {
		return nroFactura;
	}

}
