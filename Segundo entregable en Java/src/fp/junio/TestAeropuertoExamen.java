package fp.junio;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import fp.junio.material.Vuelo;
import fp.junio.material.VueloImpl;

/*
 Salida esperada al ejecutar:

�Cu�ntos destinos distintos hay para vuelos que tienen prevista su salida antes de mediod�a?  3
�Tienen todos los vuelos con destino Roma una duraci�n superior a 2 horas? true
�Cu�l es el vuelo con menos plazas? (RYN5517) Sevilla - Londres 03/02/2017 08:30
N�mero de vuelos a los distintos destinos: {Par�s=1, Roma=1, Londres=5}
N�mero de vuelos a los distintos destinos (segunda versi�n del m�todo): {Par�s=1, Londres=5, Roma=1}
 
 */
public class TestAeropuertoExamen {

	public static void main(String[] args) {

		AeropuertoExamen aeropuerto = new AeropuertoExamenImpl("San Pablo", "Sevilla", generaVuelos());

		// TODO Llamadas a los m�todos pedidos con los casos de prueba dados
		System.out
				.println("�Cu�ntos destinos distintos hay para vuelos que tienen prevista su salida antes de mediod�a? "
						+ aeropuerto.getNumeroDestinosMatinalesDistintos());

		System.out.println("�Tienen todos los vuelos con destino Roma una duraci�n superior a 2 horas? "
				+ aeropuerto.todosVuelosDestinoDuracionSuperiorA("Roma", 2));

		System.out.println("�Cu�l es el vuelo con menos plazas? " + aeropuerto.getVueloConMenosPlazas());

		System.out.println("N�mero de vuelos a los distintos destinos: " + aeropuerto.getNumeroVuelosPorDestino());

		System.out.println("N�mero de vuelos a los distintos destinos (segunda versi�n del m�todo): "
				+ aeropuerto.getNumeroVuelosPorDestino2());

	}

	private static List<Vuelo> generaVuelos() {
		List<Vuelo> res = new ArrayList<Vuelo>();
		res.add(new VueloImpl("IBE2021", "Sevilla", "Londres", LocalDateTime.of(2017, 2, 3, 10, 10),
				LocalDateTime.of(2017, 2, 3, 12, 20), 240));
		res.add(new VueloImpl("IBE2025", "Sevilla", "Londres", LocalDateTime.of(2017, 2, 3, 17, 55),
				LocalDateTime.of(2017, 2, 3, 20, 15), 240));
		res.add(new VueloImpl("RYN5517", "Sevilla", "Londres", LocalDateTime.of(2017, 2, 3, 8, 30),
				LocalDateTime.of(2017, 2, 3, 10, 45), 210));
		res.add(new VueloImpl("RYN5535", "Sevilla", "Londres", LocalDateTime.of(2017, 2, 3, 11, 45),
				LocalDateTime.of(2017, 2, 3, 13, 55), 210));
		res.add(new VueloImpl("RYN5575", "Sevilla", "Londres", LocalDateTime.of(2017, 2, 3, 19, 25),
				LocalDateTime.of(2017, 2, 3, 21, 50), 210));
		res.add(new VueloImpl("IBE3005", "Sevilla", "Roma", LocalDateTime.of(2017, 2, 3, 9, 45),
				LocalDateTime.of(2017, 2, 3, 12, 15), 220));
		res.add(new VueloImpl("IBE2325", "Sevilla", "Par�s", LocalDateTime.of(2017, 2, 3, 7, 55),
				LocalDateTime.of(2017, 2, 3, 9, 45), 250));
		return res;
	}

}
