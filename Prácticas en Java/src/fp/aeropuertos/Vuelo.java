package fp.aeropuertos;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Set;

import fp.bibliotecas.Persona;

public interface Vuelo {

	LocalDateTime getFechaSalida();

	void setFechaSalida(LocalDateTime fechaSalida);

	LocalDateTime getFechaLlegada();

	void setFechaLlegada(LocalDateTime fechaLlegada);

	Set<Persona> getPasajeros();

	Integer getNumPasajeros();

	String getCodigo();

	String getOrigen();

	String getDestino();

	Duration getDuracion();

	Integer getNumPlazas();

	Boolean estaCompleto();

}