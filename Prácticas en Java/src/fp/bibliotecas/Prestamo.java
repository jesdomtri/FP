package fp.bibliotecas;

import java.time.LocalDate;

public interface Prestamo {

	LocalDate getFechaPrestamo();

	void setFechaPrestamo(LocalDate fechaPrestamo);

	Persona getUsuario();

	Libro getLibro();

	LocalDate getFechaDevolucion();

}