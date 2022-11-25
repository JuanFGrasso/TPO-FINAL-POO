package controlador;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import modelo.Administrativo;
import modelo.Cliente;
import modelo.Condensador;
import modelo.Empresa;
import modelo.Evaporador;
import modelo.Factura;
import modelo.Instalacion;
import modelo.KitInstalacion;
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
	
	public static void ajustarInstalacion(int nroInstalacion ,int evap, int cond, int kits) {
		Administrativo admin = (Administrativo) usuario;
		Instalacion instalacion = Empresa.getInstace().obtenerInstalacion(nroInstalacion);
		admin.ajustarInstalacion(instalacion, evap, cond, kits);
	}

}
