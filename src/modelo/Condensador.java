package modelo;

public class Condensador extends Equipamiento{
	
public static Condensador condensador = null;
	
	public static Condensador getInstance() {
		if (condensador == null) {
			condensador = new Condensador();
		}
		return condensador;
	}
}
