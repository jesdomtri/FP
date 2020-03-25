package accidentes;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;

import util.Utiles;

public class EstadisticasAccidentesImpl implements EstadisticasAccidentes {
	private List<AccidenteAereo> accidentes;

	public EstadisticasAccidentesImpl(String nombreFicheroCSV) {
		List<String> lineas = Utiles.leeFichero(nombreFicheroCSV);
		accidentes = lineas.stream().map(s -> new AccidenteAereoImpl(s)).collect(Collectors.toList());
	}

	public List<AccidenteAereo> getAccidentes() {
		return new ArrayList<AccidenteAereo>(accidentes);
	}

	public Double mediaFallecidos(String lugar) {
		return getAccidentes().stream().filter(a -> a.getLugar().equals(lugar))
				.collect(Collectors.averagingDouble(a -> a.getNumFallecidos()));
	}

	public Double mediaFallecidos2(String lugar) {
		return getAccidentes().stream().filter(a -> a.getLugar().equals(lugar)).mapToInt(a -> a.getNumFallecidos())
				.average().orElse(0);
	}

	public SortedMap<Integer, Integer> getVictimasTotalesPorAnyoConDestino(String destino) {
		return getAccidentes().stream().filter(a -> a.getDestinoVuelo().equals(destino)).collect(Collectors.groupingBy(
				a -> a.getFecha().getYear(), TreeMap::new, Collectors.summingInt(a -> a.getNumFallecidos())));
	}

}
