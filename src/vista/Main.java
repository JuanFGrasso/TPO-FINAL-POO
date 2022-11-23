package vista;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.Empresa;
import modelo.Evaporador;
import modelo.NivelTecnico;
import modelo.Personal;
import modelo.TipoEmpleado;
import modelo.TipoEquipamiento;

public class Main {

	public static void main(String[] args) {
		
		//Vista.GUI();
		VistaOperador.GUI();
		//VistaAdministrador.GUI();
		//VistaAdministrativo.GUI();
		//VistaTecnico.GUI();
		
		Empresa empresa = Empresa.getInstace();
		
		empresa.agregarPersonal("Administrador1", "test1234", TipoEmpleado.ADMINISTRADOR, null);
		empresa.agregarPersonal("Operador1", "test4321", TipoEmpleado.OPERADOR, null);
		empresa.agregarPersonal("Administrativo1", "test1111", TipoEmpleado.ADMINISTRATIVO, null);
		empresa.agregarPersonal("Tecnico1", "test0101", TipoEmpleado.TECNICO, NivelTecnico.JUNIOR);
		
		empresa.agregarCliente(4000, "Cliente1", "Juramento 100");
		empresa.agregarCliente(5000, "Cliente2", "Juramento 100");
		empresa.agregarCliente(6000, "Cliente3", "Juramento 100");
		
		Administrador a = (Administrador) empresa.obtenerPersonal(0);
		a.altaEquipamiento(TipoEquipamiento.EVAPORADOR, 100, 50);
		a.altaEquipamiento(TipoEquipamiento.CONDENSADOR, 100, 100);
		a.altaEquipamiento(TipoEquipamiento.KITINSTALACION, 100, 75);
		
		a.configurarCostoHora(NivelTecnico.JUNIOR, 100);
		a.configurarCostoHora(NivelTecnico.SEMISENIOR, 200);
		a.configurarCostoHora(NivelTecnico.SENIOR, 300);
		

	}

}
