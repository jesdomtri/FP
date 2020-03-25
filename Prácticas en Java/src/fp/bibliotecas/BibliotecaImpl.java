package fp.bibliotecas;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

import fp.utiles.Checkers;

public class BibliotecaImpl implements Biblioteca {

	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String localidad;
	private String telefono;
	private String email;
	private List<Libro> libros;
	private Set<Persona> usuarios;
	private Set<Prestamo> prestamos;

	public BibliotecaImpl(String nombre, String localidad) {
		super();
		Checkers.checkNoNull(nombre, localidad);
		this.nombre = nombre;
		this.localidad = localidad;
		this.libros = new ArrayList<Libro>();
		this.usuarios = new HashSet<>();
		this.prestamos = new HashSet<>();
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Checkers.check("Email debe contener @ y .", email.contains("@") && email.contains("."));
		this.email = email;
	}

	public String getNombre() {
		return nombre;
	}

	public String getLocalidad() {
		return localidad;
	}

	public List<Libro> getLibros() {
		return new ArrayList<Libro>(libros);
	}

	public Set<Persona> getUsuarios() {
		return new HashSet<Persona>(usuarios);
	}

	public Set<Prestamo> getPrestamos() {
		return new HashSet<Prestamo>(prestamos);
	}

	public void nuevoLibro(Libro l) {
		if (l != null) {
			getLibros().add(l);
		}
	}

	public void eliminaLibro(Libro l) {
		if (getLibros().contains(l)) {
			getLibros().remove(l);
		} else {
			throw new IllegalArgumentException();
		}
	}

	public void nuevoUsuario(Persona p) {
		if (!getUsuarios().contains(p) || p == null) {
			getUsuarios().add(p);
		}
	}

	public void eliminaUsuario(Persona p) {
		getUsuarios().remove(p);
	}

	public void nuevoPrestamo(Libro l, Persona p) {
		if (getUsuarios().contains(p) && getLibros().contains(l)) {
			Prestamo pres = new PrestamosImpl(p, l, LocalDate.now());
			getPrestamos().add(pres);
		}
	}

	public Integer cuentaPrestamos(Persona usuario) {
		Integer res = 0;
		for (Prestamo p : getPrestamos()) {
			if (p.getUsuario().equals(usuario)) {
				res++;
			}
		}
		if (!getUsuarios().contains(usuario)) {
			throw new IllegalArgumentException();
		} else {
			return res;
		}
	}

	public Integer cuentaPrestamos(Libro libro) {
		Integer res = 0;
		for (Prestamo p : getPrestamos()) {
			if (p.getLibro().equals(libro)) {
				res++;
			}
		}
		if (!getLibros().contains(libro)) {
			throw new IllegalArgumentException();
		} else {
			return res;
		}
	}

	public Integer cuentaPrestamos(Month mes) {
		Integer res = 0;
		for (Prestamo p : getPrestamos()) {
			if (p.getFechaPrestamo().getMonth().equals(mes)) {
				res++;
			}
		}
		return res;
	}

	public Month getMesConMasPrestamos() {
		Month res = Month.JANUARY;
		for (Prestamo p : getPrestamos()) {
			if (cuentaPrestamos(p.getFechaPrestamo().getMonth()) > cuentaPrestamos(res)) {
				res = p.getFechaPrestamo().getMonth();
			}
		}
		return res;
	}

	public List<Libro> seleccionaLibrosSinPrestamos() {
		List<Libro> res = new ArrayList<>();
		for (Libro l : getLibros()) {
			if (cuentaPrestamos(l) == 0) {
				res.add(l);
			}
		}
		return res;
	}

	public Set<Persona> seleccionaUsuariosSinPrestamos() {
		Set<Persona> res = new HashSet<>();
		for (Persona p : getUsuarios()) {
			if (cuentaPrestamos(p) == 0) {
				res.add(p);
			}
		}
		return res;
	}

	public Boolean tienenTodosLosUsuariosPrestamo() {
		Boolean res = true;
		for (Persona p : getUsuarios()) {
			if (seleccionaUsuariosSinPrestamos().contains(p)) {
				res = false;
				break;
			}
		}
		return res;
	}

	public SortedMap<Month, Set<Prestamo>> getPrestamosPorMes() {
		SortedMap<Month, Set<Prestamo>> res = new TreeMap<>();
		for (Prestamo p : getPrestamos()) {
			if (res.containsKey(p.getFechaPrestamo().getMonth())) {
				res.get(p.getFechaPrestamo().getMonth()).add(p);
			} else {
				Set<Prestamo> setPres = new HashSet<>();
				setPres.add(p);
				res.put(p.getFechaPrestamo().getMonth(), setPres);
			}
		}
		return res;
	}

	public Map<String, List<Libro>> getLibrosAutor() {
		Map<String, List<Libro>> res = new HashMap<>();
		for (Libro libro : getLibros()) {
			if (res.containsKey(libro.getAutor())) {
				res.get(libro.getAutor()).add(libro);
			} else {
				List<Libro> listLibros = new ArrayList<>();
				listLibros.add(libro);
				res.put(libro.getAutor(), listLibros);
			}
		}
		return res;
	}

	public List<Libro> getLibro(String isbn) {
		List<Libro> res = new ArrayList<>();
		for (Libro l : getLibros()) {
			if (l.getIsbn().equals(isbn)) {
				res.add(l);
			}
		}
		return res;
	}

	public String toString() {
		return getNombre() + " (" + getLocalidad() + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((localidad == null) ? 0 : localidad.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BibliotecaImpl other = (BibliotecaImpl) obj;
		if (localidad == null) {
			if (other.localidad != null)
				return false;
		} else if (!localidad.equals(other.localidad))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}

}
