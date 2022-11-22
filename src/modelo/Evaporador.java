package modelo;

public class Evaporador extends Equipamiento{
	
	public static Evaporador evaporador = null;
	
	public static Evaporador getInstance() {
		if (evaporador == null) {
			evaporador = new Evaporador();
		}
		return evaporador;
	}
	
}
