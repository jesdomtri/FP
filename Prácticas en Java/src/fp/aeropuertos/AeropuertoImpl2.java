package fp.aeropuertos;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.stream.Collectors;

import fp.bibliotecas.Persona;

public class AeropuertoImpl2 extends AeropuertoImpl implements Aeropuerto {

	public AeropuertoImpl2(String nombre, String ciudad) {
		super(nombre, ciudad);
	}

	public AeropuertoImpl2(String nombre, String ciudad, SortedSet<Vuelo> vuelos) {
		super(nombre, ciudad, vuelos);
	}

	public Set<Vuelo> seleccionaVuelosFecha(LocalDate fechaSalida) {
		return getVuelos().stream().filter(v -> v.getFechaSalida().equals(fechaSalida)).collect(Collectors.toSet());
	}

	public Vuelo getVuelosMasPasajeros() {
		return getVuelos().stream().max(Comparator.comparing(v -> v.getNumPasajeros())).get();
	}

	public Persona getPasajeroMayor() {
		return getVuelos().stream().flatMap(v -> v.getPasajeros().stream()).max(Comparator.comparing(u -> u.getEdad()))
				.get();
	}

	public Vuelo getVueloPlazasLibresDestino(String destino) {
		return getVuelos().stream().filter(v -> v.getDestino().equals(destino))
				.filter(v -> v.getNumPlazas() > v.getNumPasajeros()).findFirst().get();
	}

	public Integer calculaTotalPasajerosDestino(String destino) {
		return (int) getVuelos().stream().filter(v -> v.getDestino().equals(destino)).map(v -> v.getPasajeros())
				.count();
	}

	public Map<String, Integer> getNumeroPasajerosPorDestino() {
		return getVuelos().stream().collect(Collectors.toMap(v -> v.getDestino(), v -> v.getNumPasajeros()));
	}
}
