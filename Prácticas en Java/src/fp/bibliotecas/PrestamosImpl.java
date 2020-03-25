package fp.bibliotecas;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class PrestamosImpl implements Prestamo {

	private Persona usuario;
	private Libro libro;
	private LocalDate fechaPrestamo;

	public PrestamosImpl(Persona usuario, Libro libro, LocalDate fechaPrestamo) {
		super();
		Checkers.check("FechaPrestamo anterior o igual que actual",
				fechaPrestamo.isBefore(LocalDate.now()) || fechaPrestamo.equals(LocalDate.now()));
		this.usuario = usuario;
		this.libro = libro;
		this.fechaPrestamo = fechaPrestamo;
	}

	public LocalDate getFechaPrestamo() {
		return fechaPrestamo;
	}

	public void setFechaPrestamo(LocalDate fechaPrestamo) {
		this.fechaPrestamo = fechaPrestamo;
	}

	public Persona getUsuario() {
		return usuario;
	}

	public Libro getLibro() {
		return libro;
	}

	public LocalDate getFechaDevolucion() {
		return getFechaPrestamo().plusDays(getLibro().numDiasPrestados());
	}

	public String toString() {
		return getLibro().getTitulo() + " (usuario: " + getUsuario() + ", fecha prestamo: " + getFechaPrestamo()
				+ ", fecha devolucion: " + getFechaDevolucion() + ").";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fechaPrestamo == null) ? 0 : fechaPrestamo.hashCode());
		result = prime * result + ((libro == null) ? 0 : libro.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PrestamosImpl other = (PrestamosImpl) obj;
		if (fechaPrestamo == null) {
			if (other.fechaPrestamo != null)
				return false;
		} else if (!fechaPrestamo.equals(other.fechaPrestamo))
			return false;
		if (libro == null) {
			if (other.libro != null)
				return false;
		} else if (!libro.equals(other.libro))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}

}
