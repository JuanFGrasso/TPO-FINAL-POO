package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Administrador;
import modelo.Administrativo;
import modelo.Cliente;
import modelo.Condensador;
import modelo.Empresa;
import modelo.EstadoInstalacion;
import modelo.Evaporador;
import modelo.Factura;
import modelo.Instalacion;
import modelo.KitInstalacion;
import modelo.NivelTecnico;
import modelo.Personal;
import modelo.Tecnico;
import modelo.TipoEmpleado;

public class Controlador {
	
	public static Personal usuario;
	
	public static boolean validarClave(int nroEmpleado, String clave) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroEmpleado);
		if (personal != null) {
			if (personal.validarClave(clave)) {
				usuario = personal;
				return true;
			} 
		}
		return false;
	}
	
	public static TipoEmpleado getTipoEmpleado(int nroEmpleado) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroEmpleado);
		return personal.getTipo();
	}
	
	public static void crearCliente(int documento, String nombre, String direccion) {
		Empresa.getInstace().agregarCliente(documento, nombre, direccion);
	}
	
	public static void crearPersona(String nombre, String clave, String tipo, String nivel) {
		if (tipo.equals("TECNICO")) {
			if (nivel.equals("JUNIOR")) {
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.TECNICO, NivelTecnico.JUNIOR);
			} else if (nivel.equals("SEMISENIOR")) {
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.TECNICO, NivelTecnico.SEMISENIOR);
			} else {
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.TECNICO, NivelTecnico.SENIOR);
			}
			
		} else {
			switch (tipo){
			case "ADMINISTRADOR":
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.ADMINISTRADOR, null);
				break;
			case "ADMINISTRATIVO":
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.ADMINISTRATIVO, null);
				break;
			case "OPERADOR":
				Empresa.getInstace().agregarPersonal(nombre, clave, TipoEmpleado.OPERADOR, null);
				break;
			}
		}
	}
	
	public static void modificarPersona(int nroPersona, String nombre, String clave) {
		Administrador admin = (Administrador) usuario;
		admin.modificarPersonal(nroPersona, nombre, clave);
	}
	
	public static void bajaPersona(int nroPersonal) {
		Personal personal = Empresa.getInstace().obtenerPersonal(nroPersonal);
		Empresa.getInstace().eliminarPersonal(personal);
	}
	
	public static void cargaTablaC(JTable table) {
		ArrayList<Cliente> clientes = Empresa.getInstace().getClientes();
		for (Cliente c: clientes) {
			String[] data = {Integer.toString(c.getDocumento()),c.getNombre(),c.getDireccion()};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			tblModel.addRow(data);
		}
	}
	
	public static void cargaTablaT(JTable table) {
		ArrayList<Tecnico> tecnicos = Empresa.getInstace().getTecnicos();
		for (Tecnico t: tecnicos) {
			String[] data = {Integer.toString(t.getNroEmpleado()),t.getNombre(),t.getNivel().toString()};
			DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
			tblModel.addRow(data);
		}
	}
	
	public static void cargaTablaI(JTable table) {
		ArrayList<Instalacion> instalacion = Empresa.getInstace().getInstalaciones();
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		for (Instalacion i: instalacion) {
			int[] equipamiento = i.getEquipamiento();
			String[] data = {Integer.toString(i.getNroInstalacion()),i.getCliente().getNombre(),i.getTecnico().getNombre(),i.getEstado().toString(),Integer.toString(equipamiento[0]),Integer.toString(equipamiento[1]),Integer.toString(equipamiento[2])};
			tblModel.addRow(data);
		}
	}
	
	public static void cargaTablaIT(JTable table) {
		ArrayList<Instalacion> instalacion = Empresa.getInstace().getInstalaciones();
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		Tecnico tecnico = (Tecnico) usuario;
		for (Instalacion i: instalacion) {
			if (i.getTecnico().equals(tecnico)) {
				int[] equipamiento = i.getEquipamiento();
				String[] data = {Integer.toString(i.getNroInstalacion()),i.getCliente().getNombre(),i.getTecnico().getNombre(),i.getEstado().toString(),Integer.toString(equipamiento[0]),Integer.toString(equipamiento[1]),Integer.toString(equipamiento[2])};
				tblModel.addRow(data);
				}
			}
	}
	
	public static void cargaTablaIF(JTable table, JComboBox combo) {
		ArrayList<Instalacion> instalacion = Administrativo.getInstalacionesFinalizadas();
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		if (instalacion != null) {
			for (Instalacion i: instalacion) {
				String facturado = "";
				if (i.isFacturado()) {
					facturado = "X";
				}
				String[] data = {Integer.toString(i.getNroInstalacion()),i.getCliente().getNombre(),i.getTecnico().getNombre(),i.getEstado().toString(), facturado};
				tblModel.addRow(data);
			}
		}
		combo.removeAllItems();
		cargaComboBoxIF(combo);
	}
	
	public static void cargaTablaF(JTable table) {
		ArrayList<Factura> facturas = Administrativo.getFacturas();
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		if (facturas != null) {
			for (Factura f: facturas) {
				String[] data = {Integer.toString(f.getNroFactura()),Integer.toString(f.getInstalacion().getNroInstalacion()),Integer.toString(f.getCosto())};
				tblModel.addRow(data);
			}
		}
	}
	
	public static void cargaTablaU(JTable table) {
		ArrayList<Personal> usuarios = Empresa.getInstace().getPersonal();
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		if (usuarios != null) {
			for (Personal u: usuarios) {
				if (!u.getTipo().equals(TipoEmpleado.TECNICO)) {
					String[] data = {Integer.toString(u.getNroEmpleado()),u.getNombre(),u.getTipo().toString(),"N/A"};
					tblModel.addRow(data);
				} else {
					Tecnico t = (Tecnico) u;
					String[] data = {Integer.toString(u.getNroEmpleado()),u.getNombre(),u.getTipo().toString(),t.getNivel().toString()};
					tblModel.addRow(data);
				}
				
			}
		}
	}
	
	public static void cargaTablaCT(JTable table) {
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		String[] dataj = {"Junior", Integer.toString(Tecnico.getCostoHoraJunior())};
		tblModel.addRow(dataj);
		String[] datasm = {"SemiSenior", Integer.toString(Tecnico.getCostoHoraSemi())};
		tblModel.addRow(datasm);
		String[] datas = {"Senior", Integer.toString(Tecnico.getCostoHoraSenior())};
		tblModel.addRow(datas);
	}
	
	public static void cargaTablaCE(JTable table) {
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		String[] dataj = {"Evaporador", Integer.toString((int) Evaporador.getInstance().getCosto())};
		tblModel.addRow(dataj);
		String[] datasm = {"Condensador", Integer.toString((int) Condensador.getInstance().getCosto())};
		tblModel.addRow(datasm);
		String[] datas = {"Kit Instalacion", Integer.toString((int) KitInstalacion.getInstance().getCosto())};
		tblModel.addRow(datas);
	}
	
	public static void cargaTableE(JTable table) {
		DefaultTableModel tblModel = (DefaultTableModel)table.getModel();
		tblModel.setRowCount(0);
		String[] dataj = {"Evaporador",Integer.toString((int) Evaporador.getInstance().getCantidad()), Integer.toString((int) Evaporador.getInstance().getCosto())};
		tblModel.addRow(dataj);
		String[] datasm = {"Condensador",Integer.toString((int) Condensador.getInstance().getCantidad()), Integer.toString((int) Condensador.getInstance().getCosto())};
		tblModel.addRow(datasm);
		String[] datas = {"Kit Instalacion",Integer.toString((int) KitInstalacion.getInstance().getCantidad()), Integer.toString((int) KitInstalacion.getInstance().getCosto())};
		tblModel.addRow(datas);
	}
	
	public static String programarInstalacion(int cliente, int tecnico, int dia, int horario, int tiempo, int evap, int cond, int kits) {
		String flag = "";
		if (Empresa.getInstace().obtenerCliente(cliente) == null) {
			flag = "El cliente no existe";
			return flag;
		}
		
		if (Empresa.getInstace().obtenerTecnico(tecnico) == null) {
			flag = "El tecnico no existe";
			return flag;
		}
		
		if(!Empresa.getInstace().consultarAgenda(Empresa.getInstace().obtenerCliente(cliente), dia, horario, tiempo)) {
			flag = "El cliente no posee dispobile ese dia y horario";
			return flag;
		}
		
		if(!Empresa.getInstace().consultarAgenda(Empresa.getInstace().obtenerTecnico(tecnico), dia, horario, tiempo)) {
			flag = "El tecnico no posee dispobile ese dia y horario";
			return flag;
		}
		if (Evaporador.getInstance().getCantidad() < evap || Condensador.getInstance().getCantidad() < cond || KitInstalacion.getInstance().getCantidad() < kits) {
			flag = "No hay cantidad suficiente de stock";
			return flag;
		}
		Empresa.getInstace().agregarInstalacion(Empresa.getInstace().obtenerCliente(cliente), Empresa.getInstace().obtenerTecnico(tecnico), dia, horario, tiempo, null, evap, cond, kits);
		return flag;
	}
	
	public static void facturarCliente(int nroInstalacion) {
		Instalacion instalacion = Administrativo.obtenerInstalacionF(nroInstalacion);
		Administrativo administrativo = (Administrativo) usuario;
		if (!instalacion.isFacturado()) {
			administrativo.Facturar(instalacion);
			instalacion.setFacturado(true);
		}
	}
	
	public static void cargaComboBoxIF(JComboBox combobox) {
		ArrayList<Instalacion> instalacionf = Administrativo.getInstalacionesFinalizadas();
		if (instalacionf != null) {
			for (Instalacion i: instalacionf) {
				combobox.addItem(i.getNroInstalacion());
			}
		}
	}
	
	public static boolean ajustarInstalacion(int nroInstalacion ,int evap, int cond, int kits) {
		Administrativo admin = (Administrativo) usuario;
		Instalacion instalacion = Empresa.getInstace().obtenerInstalacion(nroInstalacion);
		if (instalacion == null) {
			return false;
		} else {
			admin.ajustarInstalacion(instalacion, evap, cond, kits);
			return true;
		}
	}
	
	public static boolean modificarEstadoInstalacion(int nroInstalacion,String estado) {
		Instalacion instalacion = Empresa.getInstace().obtenerInstalacion(nroInstalacion);
		if (instalacion.getEstado().equals(EstadoInstalacion.FINALIZADA) || instalacion.getEstado().equals(EstadoInstalacion.CANCELADA)) {
			return false;
		} else {
			Tecnico tecnico = (Tecnico) usuario;
			if (estado.equals("ENCURSO")) {
				tecnico.inicializarInstalacion(null);
			}
			if (estado.equals("FINALIZADA")) {
				tecnico.finalizarInstalacion(instalacion);
			}
			if (estado.equals("CANCELADA")) {
				tecnico.cancelarInstalacion(instalacion);
			}
			return true;
		}
	}
	
	public static boolean isNumeric(String cadena) {
		boolean resultado;
		try {
			Integer.parseInt(cadena);
			resultado = true;
		} catch (NumberFormatException excepcion) {
			resultado = false;
		}
		return resultado;
	}
	
	public static void configurarCostoHora(String nivel, int costo) {
		Administrador admin = (Administrador) usuario;
		switch (nivel) {
		case "JUNIOR":
			admin.configurarCostoHora(NivelTecnico.JUNIOR, costo);
			break;
		case "SEMISENIOR":
			admin.configurarCostoHora(NivelTecnico.SEMISENIOR, costo);
			break;
		case "SENIOR":
			admin.configurarCostoHora(NivelTecnico.SENIOR, costo);
			break;
		}
	}
	
	public static void configurarCostoEquipamiento(String equip, int costo) {
		Administrador admin = (Administrador) usuario;
		admin.configurarCostoEquipamiento(equip, costo);
	}
	
	public static void ajustarStock(String tipo, int cantidad) {
		Administrador admin = (Administrador) usuario;
		admin.ajustarStock(tipo, cantidad);
	}

}
