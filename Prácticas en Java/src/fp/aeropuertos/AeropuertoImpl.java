package fp.aeropuertos;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

public class AeropuertoImpl implements Aeropuerto {

	private String nombre, ciudad;
	private SortedSet<Vuelo> vuelos;

	public AeropuertoImpl(String nombre, String ciudad, SortedSet<Vuelo> vuelos) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.vuelos = vuelos;
	}

	public AeropuertoImpl(String nombre, String ciudad) {
		super();
		this.nombre = nombre;
		this.ciudad = ciudad;
		this.vuelos = new TreeSet<>();
	}

	public String getNombre() {
		return nombre;
	}

	public String getCiudad() {
		return ciudad;
	}

	public SortedSet<Vuelo> getVuelos() {
		return new TreeSet<Vuelo>(vuelos);
	}

	public void nuevoVuelo(Vuelo v) {
		if (v != null) {
			getVuelos().add(v);
		}
	}

	public void nuevoVuelos(Collection<Vuelo> vuelos) {
		if (vuelos != null) {
			getVuelos().addAll(vuelos);
		}
	}

	public boolean contieneVuelo(Vuelo v) {
		return getVuelos().contains(v);
	}

	public void eliminaVuelo(Vuelo v) {
		getVuelos().remove(v);
	}

	public Set<Vuelo> seleccionaVuelosFecha(LocalDate fechaSalida) {
		Set<Vuelo> res = new HashSet<>();
		for (Vuelo v : getVuelos()) {
			if (v.getFechaSalida().equals(fechaSalida)) {
				res.add(v);
			}
		}
		return res;
	}

	public Vuelo getVueloMasPasajeros() {
		Vuelo res = null;
		for (Vuelo v : getVuelos()) {
			if (v.getNumPasajeros().compareTo(res.getNumPasajeros()) > 0) {
				res = v;
			}
		}
		return res;
	}

	public Vuelo getVueloPlazasLibresDestino(String destino) {
		Vuelo res = null;
		for (Vuelo v : getVuelos()) {
			if (v.getDestino().equals(destino) && v.getNumPlazas() > v.getNumPasajeros()) {
				res = v;
			}
		}
		return res;
	}

	public Integer calculaTotalPasajerosDestino(String destino) {
		Integer i = 0;
		for (Vuelo v : getVuelos()) {
			if (v.getDestino().equals(destino)) {
				i += v.getNumPasajeros();
			}
		}
		return i;
	}

	public Map<String, Integer> getNumeroPasajerosPorDestino() {
		Map<String, Integer> res = new HashMap<>();
		for (Vuelo v : getVuelos()) {
			if (res.containsKey(v.getDestino())) {
				Integer numPas = res.get(v.getDestino());
				numPas += v.getNumPasajeros();
				res.put(v.getDestino(), numPas);
			} else {
				Integer numPas2 = v.getNumPasajeros();
				res.put(v.getDestino(), numPas2);
			}
		}
		return res;
	}

	public SortedMap<LocalDate, List<Vuelo>> getVuelosPorFecha() {
		SortedMap<LocalDate, List<Vuelo>> res = new TreeMap<>();
		for (Vuelo v : getVuelos()) {
			if (res.containsKey(v.getFechaSalida().toLocalDate())) {
				List<Vuelo> vuelosFecha = res.get(v.getFechaSalida().toLocalDate());
				vuelosFecha.add(v);
				res.put(v.getFechaSalida().toLocalDate(), vuelosFecha);
			} else {
				List<Vuelo> vuelosFecha2 = new ArrayList<>();
				vuelosFecha2.add(v);
				res.put(v.getFechaSalida().toLocalDate(), vuelosFecha2);
			}
		}
		return res;
	}

	public String toString() {
		return getNombre() + " (" + getCiudad() + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AeropuertoImpl other = (AeropuertoImpl) obj;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
