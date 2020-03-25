package fp.aeropuertos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import fp.bibliotecas.Persona;
import fp.utiles.Checkers;

public class VueloImpl implements Vuelo {
	private String codigo;
	private String origen;
	private String destino;
	private LocalDateTime fechaSalida;
	private LocalDateTime fechaLlegada;
	private Integer numPlazas;
	private Set<Persona> pasajeros;

	public VueloImpl(String codigo, String origen, String destino, LocalDateTime fechaSalida,
			LocalDateTime fechaLlegada, Integer numPlazas, Set<Persona> pasajeros) {
		super();
		Checkers.check("Fecha llegada posterior a fecha salida", fechaLlegada.isAfter(fechaSalida));
		Checkers.check("NumPasajeros menor o igual que numPlazas", pasajeros.size() <= numPlazas);
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.numPlazas = numPlazas;
		this.pasajeros = pasajeros;
	}

	public VueloImpl(String codigo, String origen, String destino, LocalDateTime fechaSalida,
			LocalDateTime fechaLlegada, Integer numPlazas) {
		super();
		Checkers.check("Fecha llegada posterior a fecha salida", fechaLlegada.isAfter(fechaSalida));
		this.codigo = codigo;
		this.origen = origen;
		this.destino = destino;
		this.fechaSalida = fechaSalida;
		this.fechaLlegada = fechaLlegada;
		this.numPlazas = numPlazas;
		this.pasajeros = new HashSet<>();
	}

	public VueloImpl(String s) {
		String[] trozos = s.split(",");
		Checkers.check("Formato String no valido", trozos.length == 6);

		LocalDateTime fechaLlegadaAux = LocalDateTime.parse(trozos[4].trim(),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Checkers.check("Fecha llegada posterior a fecha salida", fechaLlegadaAux.isAfter(fechaSalida));

		this.codigo = trozos[0].trim();
		this.origen = trozos[1].trim();
		this.destino = trozos[2].trim();
		this.fechaSalida = LocalDateTime.parse(trozos[3].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		this.fechaLlegada = fechaLlegadaAux;
		this.numPlazas = new Integer(trozos[5].trim());
	}

	public LocalDateTime getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(LocalDateTime fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public LocalDateTime getFechaLlegada() {
		return fechaLlegada;
	}

	public void setFechaLlegada(LocalDateTime fechaLlegada) {
		Checkers.check("Fecha llegada posterior a fecha salida", fechaLlegada.isAfter(fechaSalida));
		this.fechaLlegada = fechaLlegada;
	}

	public Set<Persona> getPasajeros() {
		return new HashSet<Persona>(pasajeros);
	}

	public Integer getNumPasajeros() {
		return getPasajeros().size();
	}

	public String getCodigo() {
		return codigo;
	}

	public String getOrigen() {
		return origen;
	}

	public String getDestino() {
		return destino;
	}

	public Duration getDuracion() {
		return Duration.between(getFechaLlegada(), getFechaSalida());
	}

	public Integer getNumPlazas() {
		return numPlazas;
	}

	public Boolean estaCompleto() {
		Boolean res = false;
		if (getNumPasajeros() == getNumPlazas()) {
			res = true;
		}
		return res;
	}

	public void nuevoPasajero(Persona p) {
		if (!estaCompleto()) {
			getPasajeros().add(p);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void eliminaPasajero(Persona p) {
		getPasajeros().remove(p);
	}

	public String toString() {
		return "(" + getCodigo() + ") " + getOrigen() + " - " + getDestino() + " " + getFechaSalida();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((destino == null) ? 0 : destino.hashCode());
		result = prime * result + ((fechaSalida == null) ? 0 : fechaSalida.hashCode());
		result = prime * result + ((origen == null) ? 0 : origen.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VueloImpl other = (VueloImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (destino == null) {
			if (other.destino != null)
				return false;
		} else if (!destino.equals(other.destino))
			return false;
		if (fechaSalida == null) {
			if (other.fechaSalida != null)
				return false;
		} else if (!fechaSalida.equals(other.fechaSalida))
			return false;
		if (origen == null) {
			if (other.origen != null)
				return false;
		} else if (!origen.equals(other.origen))
			return false;
		return true;
	}

}
