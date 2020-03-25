package fp.aeropuertos;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

public interface Aeropuerto {

	String getNombre();

	String getCiudad();

	SortedSet<Vuelo> getVuelos();

	void nuevoVuelo(Vuelo v);

	void nuevoVuelos(Collection<Vuelo> vuelos);

	boolean contieneVuelo(Vuelo v);

	void eliminaVuelo(Vuelo v);

	Set<Vuelo> seleccionaVuelosFecha(LocalDate fechaSalida);

	Vuelo getVueloMasPasajeros();

	Vuelo getVueloPlazasLibresDestino(String destino);

	Integer calculaTotalPasajerosDestino(String destino);

	Map<String, Integer> getNumeroPasajerosPorDestino();

	SortedMap<LocalDate, List<Vuelo>> getVuelosPorFecha();

}