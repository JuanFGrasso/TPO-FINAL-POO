package modelo;

public class KitInstalacion extends Equipamiento{

public static KitInstalacion kitInstalacion = null;
	
	public static KitInstalacion getInstance() {
		if (kitInstalacion == null) {
			kitInstalacion = new KitInstalacion();
		}
		return kitInstalacion;
	}
}
