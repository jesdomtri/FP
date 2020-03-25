package fp.factorias;

import java.time.LocalDate;

import fp.bibliotecas.Libro;
import fp.bibliotecas.LibroImpl;
import fp.bibliotecas.Persona;
import fp.bibliotecas.PersonaImpl;
import fp.bibliotecas.PrestamosImpl;
import fp.bibliotecas.TipoPrestamo;

public class Bibliotecas {

	public LibroImpl creaLibro(String isbn, String titulo, String autor, Integer numPaginas, LocalDate fechaAdquisicion,
			Double precio, Long estimacionVentas, TipoPrestamo tipoPrestamo) {
		return new LibroImpl(isbn, titulo, autor, numPaginas, fechaAdquisicion, precio, estimacionVentas, tipoPrestamo);
	}

	public LibroImpl creaLibro(String s) {
		return new LibroImpl(s);
	}

	public PersonaImpl creaPersona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento,
			String email) {
		return new PersonaImpl(dni, nombre, apellidos, fechaNacimiento, email);
	}

	public PersonaImpl creaPersona(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		return new PersonaImpl(dni, nombre, apellidos, fechaNacimiento);
	}

	public PersonaImpl creaPersona(String s) {
		return new PersonaImpl(s);
	}

	public PrestamosImpl creaPrestamo(Persona usuario, Libro libro, LocalDate fechaPrestamo) {
		return new PrestamosImpl(usuario, libro, fechaPrestamo);
	}

}
