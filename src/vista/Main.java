package vista;

import java.util.ArrayList;

import modelo.Administrador;
import modelo.Cliente;
import modelo.Empresa;
import modelo.Evaporador;
import modelo.Instalacion;
import modelo.NivelTecnico;
import modelo.Operador;
import modelo.Personal;
import modelo.Tecnico;
import modelo.TipoEmpleado;
import modelo.TipoEquipamiento;

public class Main {

	public static void main(String[] args) {
		
		Vista.GUI();
		//VistaOperador.GUI();
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
		
		Operador o = (Operador) empresa.obtenerPersonal(1);
		Tecnico t = empresa.obtenerTecnico(3);
		Cliente c = empresa.obtenerCliente(4000);
		o.agendarInstalacion(c, t, 2, 15, 5, null, 10, 15, 5);
		
		Instalacion i = empresa.obtenerInstalacion(0);
		
		t.finalizarInstalacion(i);
		

	}

}
