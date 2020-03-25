package fp.aeropuertos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import fp.bibliotecas.Persona;

public class VueloCompanyiaImpl extends VueloImpl implements VueloCompanyia {

	private String nombreCompanyia;
	private Persona capitan;

	public VueloCompanyiaImpl(String codigo, String origen, String destino, LocalDateTime fechaSalida,
			LocalDateTime fechaLlegada, Duration duracion, Integer numPlazas, Set<Persona> pasajeros,
			String nombreCompanyia, Persona capitan) {
		super(codigo, origen, destino, fechaSalida, fechaLlegada, numPlazas, pasajeros);
		this.nombreCompanyia = nombreCompanyia;
		this.capitan = capitan;
	}

	public Persona getCapitan() {
		return capitan;
	}

	public void setCapitan(Persona capitan) {
		this.capitan = capitan;
	}

	public String getNombreCompanyia() {
		return nombreCompanyia;
	}

	public String toString() {
		return super.toString() + " - companyia: " + getNombreCompanyia();
	}
}
