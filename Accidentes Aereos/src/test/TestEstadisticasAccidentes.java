package test;

import accidentes.EstadisticasAccidentesImpl;

public class TestEstadisticasAccidentes {

	public static void main(String[] args) {

		EstadisticasAccidentesImpl e = new EstadisticasAccidentesImpl("ficheros/accidentes.txt");
		System.out.println("Media de fallecidos en Casablanca, Morocco: " + e.mediaFallecidos("Casablanca, Morocco"));
		System.out.println("Media de fallecidos en Sao Paulo, Brazil: " + e.mediaFallecidos("Sao Paulo, Brazil"));
		System.out.println("Media de fallecidos en Seville, Spain: " + e.mediaFallecidos("Seville, Spain"));

		System.out.println(
				"-------------------------------------------------------------------------------------------------------");

		System.out.println(
				"Numero total de victimas por anyo en Bombay: " + e.getVictimasTotalesPorAnyoConDestino("Bombay"));

	}

}
