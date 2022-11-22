package controlador;

import modelo.Empresa;
import modelo.Personal;
import modelo.TipoEmpleado;

public class Controlador {
	
	public static boolean validarClave(int nroEmpleado, String clave) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroEmpleado);
		if (personal != null) {
			if (personal.validarClave(clave)) {
				return true;
			} 
		}
		return false;
	}
	
	public static TipoEmpleado getTipoEmpleado(int nroEmpleado) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroEmpleado);
		return personal.getTipo();
	}

}
