package fp.bibliotecas;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

public interface Biblioteca {

	String getDireccion();

	void setDireccion(String direccion);

	String getCodigoPostal();

	void setCodigoPostal(String codigoPostal);

	String getTelefono();

	void setTelefono(String telefono);

	String getEmail();

	void setEmail(String email);

	String getNombre();

	String getLocalidad();

	List<Libro> getLibros();

	Set<Persona> getUsuarios();

	Set<Prestamo> getPrestamos();

	void nuevoLibro(Libro l);

	void eliminaLibro(Libro l);

	void nuevoUsuario(Persona p);

	void eliminaUsuario(Persona p);

	void nuevoPrestamo(Libro l, Persona p);

	Integer cuentaPrestamos(Persona usuario);

	Integer cuentaPrestamos(Libro libro);

	Integer cuentaPrestamos(Month mes);

	Month getMesConMasPrestamos();

	List<Libro> seleccionaLibrosSinPrestamos();

	Set<Persona> seleccionaUsuariosSinPrestamos();

	Boolean tienenTodosLosUsuariosPrestamo();

	SortedMap<Month, Set<Prestamo>> getPrestamosPorMes();

	Map<String, List<Libro>> getLibrosAutor();

	List<Libro> getLibro(String isbn);

}