package fp.bibliotecas;

import java.time.Month;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BibliotecaImpl2 extends BibliotecaImpl implements Biblioteca {

	public BibliotecaImpl2(String nombre, String localidad) {
		super(nombre, localidad);
	}

	public Integer cuentaPrestamos(Persona usuario) {
		return (int) getPrestamos().stream().filter(p -> p.getUsuario().equals(usuario)).count();
	}

	public Integer cuentaPrestamos(Libro libro) {
		return (int) getPrestamos().stream().filter(p -> p.getLibro().equals(libro)).count();
	}

	public Integer cuentaPrestamos(Month mes) {
		return (int) getPrestamos().stream().filter(p -> p.getFechaPrestamo().getMonth().equals(mes)).count();
	}

	public List<Libro> seleccionaLibrosSinPrestamos() {
		return getLibros().stream().filter(l -> cuentaPrestamos(l) == 0).collect(Collectors.toList());
	}

	public Set<Persona> seleccionaUsuariosSinPrestamos() {
		return getUsuarios().stream().filter(u -> cuentaPrestamos(u) == 0).collect(Collectors.toSet());
	}

//	public Boolean tienenTodosLosUsuariosPrestamo(){
//		return 
//	}
	
}
