package modelo;

public class Administrador extends Personal{
	
	public Administrador(String nombre, String clave, TipoEmpleado tipo) {
		this.nroEmpleado = generador;
		generador++;
		this.nombre = nombre;
		this.clave = clave;
		this.tipo = tipo;
	}
	
	public void altaEquipamiento(TipoEquipamiento tipo, int cantidad, double costo) {
		switch (tipo) {
		case EVAPORADOR:
			Evaporador.getInstance().setCantidad(cantidad);
			Evaporador.getInstance().setCosto(costo);
			break;
		case CONDENSADOR:
			Condensador.getInstance().setCantidad(cantidad);
			Condensador.getInstance().setCosto(costo);
			break;
		case KITINSTALACION:
			KitInstalacion.getInstance().setCantidad(cantidad);
			KitInstalacion.getInstance().setCosto(costo);
			break;
			
		}
	}
	
	public void altaPersonal(String nombre, String clave, TipoEmpleado tipo) {
		Empresa.getInstace().agregarPersonal(nombre, clave, tipo, null);
	}
	
	public void altaPersonal(String nombre, String clave, TipoEmpleado tipo, NivelTecnico nivel) {
		Empresa.getInstace().agregarPersonal(nombre, clave, tipo, nivel);
	}
	
	public void ModificarPersonal(int nroEmpleado, String nombre, String clave) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroEmpleado);
		personal.setNombre(nombre);
		personal.setClave(clave);
	}
	
	public void configurarCostoHora(NivelTecnico nivel, int costo) {
		switch (nivel) {
		case JUNIOR:
			Tecnico.setCostoHoraJunior(costo);
			break;
		case SEMISENIOR:
			Tecnico.setCostoHoraSemi(costo);
			break;
		case SENIOR:
			Tecnico.setCostoHoraSenior(costo);
			break;
		}
	}

}
