package fp.junio;

import java.util.Map;

import fp.junio.material.Aeropuerto;
import fp.junio.material.Vuelo;

public interface AeropuertoExamen extends Aeropuerto {

	Integer getNumeroDestinosMatinalesDistintos();

	Boolean todosVuelosDestinoDuracionSuperiorA(String destino, Integer horas);

	Vuelo getVueloConMenosPlazas();

	Map<String, Long> getNumeroVuelosPorDestino();

	Map<String, Long> getNumeroVuelosPorDestino2();
}
