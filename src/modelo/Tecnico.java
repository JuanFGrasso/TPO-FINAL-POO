package modelo;

public class Tecnico extends Personal {
	
	private NivelTecnico nivel;
	private Agenda agenda;
	private static int costoJunior;
	private static int costoSemi;
	private static int costoSenior;
	
	public Tecnico(String nombre, String clave, TipoEmpleado tipo, NivelTecnico nivel) {
		this.nroEmpleado = generador;
		generador++;
		this.nombre = nombre;
		this.clave = clave;
		this.tipo = tipo;
		this.nivel = nivel;
		this.agenda = new Agenda();
	}
	
	public NivelTecnico getNivel() {
		return nivel;
	}
	
	public void setNivel(NivelTecnico nivel) {
		this.nivel = nivel;
	}
	
	public Agenda getAgenda() {
		return agenda;
	}
	
	public void inicializarInstalacion(Instalacion instalacion) {
		instalacion.setEstado(EstadoInstalacion.ENCURSO);
	}
	
	public void cancelarInstalacion(Instalacion instalacion) {
		instalacion.setEstado(EstadoInstalacion.CANCELADA);
		
	}
	
	public void finalizarInstalacion(Instalacion instalacion) {
		instalacion.setEstado(EstadoInstalacion.FINALIZADA);
		Administrativo.agregarInstalacionFinalizada(instalacion);
	}
	
	public static int getCostoHoraJunior() {
		return costoJunior;
	}
	
	public static int getCostoHoraSemi() {
		return costoSemi;
	}
	
	public static int getCostoHoraSenior() {
		return costoSenior;
	}
	
	public static void setCostoHoraJunior(int costo) {
		costoJunior = costo;
	}
	
	public static void setCostoHoraSemi(int costo) {
		costoSemi = costo;
	}
	
	public static void setCostoHoraSenior(int costo) {
		costoSenior = costo;
	}

}
