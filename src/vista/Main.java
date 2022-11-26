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
		
		empresa.agregarPersonal("Diego Maradona", "eldiego", TipoEmpleado.ADMINISTRADOR, null);
		empresa.agregarPersonal("Lionel Messi", "lapulga", TipoEmpleado.OPERADOR, null);
		empresa.agregarPersonal("Angel Di Maria", "elfideo", TipoEmpleado.ADMINISTRATIVO, null);
		empresa.agregarPersonal("Emiliano Martinez", "eldibu", TipoEmpleado.TECNICO, NivelTecnico.JUNIOR);
		empresa.agregarPersonal("Roberto Abbondanzieri", "elpato", TipoEmpleado.TECNICO, NivelTecnico.SEMISENIOR);
		empresa.agregarPersonal("Javier Mascherano", "eljefecito", TipoEmpleado.TECNICO, NivelTecnico.SENIOR);
		empresa.agregarPersonal("Efmamj Jasond", "elnegroalmanaque", TipoEmpleado.TECNICO, NivelTecnico.JUNIOR);
		
		empresa.agregarCliente(1234, "Neymar da Silva", "Juramento 1300");
		empresa.agregarCliente(4321, "Cristiano Ronaldo", "Cabildo 800");
		empresa.agregarCliente(1111, "Zinedine Zidane", "Mendoza 2500");
		
		Administrador a = (Administrador) empresa.obtenerPersonal(0);
		a.altaEquipamiento(TipoEquipamiento.EVAPORADOR, 100, 50);
		a.altaEquipamiento(TipoEquipamiento.CONDENSADOR, 100, 100);
		a.altaEquipamiento(TipoEquipamiento.KITINSTALACION, 100, 75);
		
		a.configurarCostoHora(NivelTecnico.JUNIOR, 100);
		a.configurarCostoHora(NivelTecnico.SEMISENIOR, 200);
		a.configurarCostoHora(NivelTecnico.SENIOR, 300);
		
		Operador o = (Operador) empresa.obtenerPersonal(1);
		Tecnico t1 = empresa.obtenerTecnico(3);
		Tecnico t2 = empresa.obtenerTecnico(4);
		Cliente c1 = empresa.obtenerCliente(1234);
		Cliente c2 = empresa.obtenerCliente(4321);
		o.agendarInstalacion(c1, t1, 2, 15, 5, null, 10, 15, 5);
		o.agendarInstalacion(c1, t1, 4, 2, 10, null, 20, 30, 4);
		
		o.agendarInstalacion(c2, t2, 2, 15, 5, null, 10, 5, 10);
		o.agendarInstalacion(c2, t2, 4, 2, 10, null, 5, 10, 4);
		
		Instalacion i = empresa.obtenerInstalacion(0);
		
		t1.finalizarInstalacion(i);
		

	}

}
