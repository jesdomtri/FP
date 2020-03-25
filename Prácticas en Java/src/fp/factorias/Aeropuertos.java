package fp.factorias;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.SortedSet;

import fp.aeropuertos.AeropuertoImpl;
import fp.aeropuertos.Vuelo;
import fp.aeropuertos.VueloImpl;
import fp.bibliotecas.Persona;

public class Aeropuertos {

	public VueloImpl creaVuelo(String codigo, String origen, String destino, LocalDateTime fechaSalida,
			LocalDateTime fechaLlegada, Integer numeroPlazas, Set<Persona> pasajeros) {
		return new VueloImpl(codigo, origen, destino, fechaSalida, fechaLlegada, numeroPlazas, pasajeros);
	}

	public VueloImpl creaVuelo(String codigo, String origen, String destino, LocalDateTime fechaSalida,
			LocalDateTime fechaLlegada, Integer numeroPlazas) {
		return new VueloImpl(codigo, origen, destino, fechaSalida, fechaLlegada, numeroPlazas);
	}

	public VueloImpl creaVuelo(String s) {
		return new VueloImpl(s);
	}

	public AeropuertoImpl creaAeropuerto(String nombre, String ciudad, SortedSet<Vuelo> vuelos) {
		return new AeropuertoImpl(nombre, ciudad, vuelos);
	}

	public AeropuertoImpl creaAeropuerto(String nombre, String ciudad) {
		return new AeropuertoImpl(nombre, ciudad);
	}
}
