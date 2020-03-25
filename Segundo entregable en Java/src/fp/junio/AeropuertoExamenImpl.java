package fp.junio;

import java.time.Duration;
import java.time.LocalTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import fp.junio.material.AeropuertoImpl;
import fp.junio.material.Vuelo;

public class AeropuertoExamenImpl extends AeropuertoImpl implements AeropuertoExamen {

	public AeropuertoExamenImpl(String nombre, String ciudad) {
		super(nombre, ciudad);
	}

	public AeropuertoExamenImpl(String nombre, String ciudad, Collection<Vuelo> vuelos) {
		super(nombre, ciudad, vuelos);
	}

	// TODO 1.a
	public Integer getNumeroDestinosMatinalesDistintos() {
		return (int) getVuelos().stream().filter(v -> v.getFechaSalida().toLocalTime().isBefore(LocalTime.of(12, 00)))
				.map(v -> v.getDestino()).distinct().count();
	}

	// TODO 1.b
	public Boolean todosVuelosDestinoDuracionSuperiorA(String destino, Integer horas) {
		return getVuelos().stream().filter(v -> v.getDestino().equals(destino))
				.allMatch(v -> v.getDuracion().compareTo(Duration.ofHours(horas.longValue())) > 0);
	}

	// TODO 1.c
	public Vuelo getVueloConMenosPlazas() {
		return getVuelos().stream().min(Comparator.comparing(v -> v.getNumeroPlazas())).get();
	}

	// TODO 1.d
	public Map<String, Long> getNumeroVuelosPorDestino() {
		return getVuelos().stream()
				.collect(Collectors.groupingBy(v -> v.getDestino(), HashMap::new, Collectors.counting()));
	}

	// TODO 1.e
	public Map<String, Long> getNumeroVuelosPorDestino2() {
		Map<String, Long> res = new HashMap<>();
		Integer i = 1;
		for (Vuelo v : getVuelos()) {
			if (res.containsKey(v.getDestino())) {
				Long numVuelos = res.get(v.getDestino());
				numVuelos += i;
				res.put(v.getDestino(), numVuelos);
			} else {
				String dest = v.getDestino();
				Long numVuelos2 = 0L;
				numVuelos2 += i;
				res.put(dest, numVuelos2);
			}
		}
		return res;
	}

}
