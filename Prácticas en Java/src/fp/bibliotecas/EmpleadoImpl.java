package fp.bibliotecas;

import java.time.LocalDate;

public class EmpleadoImpl extends PersonaImpl implements Empleado {

	private String puesto;
	private TipoContrato contrato;

	public EmpleadoImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, Integer edad,
			String email, String puesto, TipoContrato contrato) {
		super(dni, nombre, apellidos, fechaNacimiento, email);
		this.puesto = puesto;
		this.contrato = contrato;
	}

	public String getPuesto() {
		return puesto;
	}

	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}

	public TipoContrato getContrato() {
		return contrato;
	}

	public String toString() {
		return super.toString() + " - puesto: " + getPuesto();
	}

}
