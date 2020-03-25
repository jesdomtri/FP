package fp.musica;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListaReproduccionImpl implements ListaReproduccion {

	private String nombre;
	private List<Cancion> canciones;
	private Integer numCanciones;

	public ListaReproduccionImpl(String nombre, List<Cancion> canciones, Integer numCanciones) {
		super();
		this.nombre = nombre;
		this.canciones = new ArrayList<>();
		this.numCanciones = numCanciones;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cancion> getCanciones() {
		return new ArrayList<Cancion>(canciones);
	}

	public Integer getNumCanciones() {
		return numCanciones;
	}

	public void aleatoriza() {
		Collections.shuffle(getCanciones());
	}

	public void incorpora(Cancion c) {
		getCanciones().add(c);
	}

	public void incorpora(Album a) {
		getCanciones().addAll(a.getCanciones());
	}

	public void incorpora(List<Cancion> canciones) {
		getCanciones().addAll(canciones);
	}

	public void eliminaPrimera(Cancion c) {
		if (getCanciones().contains(c)) {
			getCanciones().remove(c);
		} else {
			throw new IllegalArgumentException();
		}

	}

	public void eliminaUltima(Cancion c) {
		if (getCanciones().contains(c)) {
			getCanciones().remove(getCanciones().lastIndexOf(c));
		} else {
			throw new IllegalArgumentException();
		}
	}

	public Boolean esAntologia(String artista) {
		Boolean res = true;
		Integer i = 0;
		for (Artista a : getCanciones().get(i).getArtista()) {
			if (!a.getNombre().equals(artista)) {
				res = false;
				break;
			} else {
				i++;
			}
		}
		return res;
	}

	public Duration getDuracion() {
		Duration d = Duration.ofMinutes(0);
		for (Cancion c : getCanciones()) {
			d.plus(c.getDuracion());
		}
		return d;
	}

	public Boolean contieneArtista(String artista) {
		Boolean res = false;
		Integer i = 0;
		for (Artista a : getCanciones().get(i).getArtista()) {
			if (a.getNombre().equals(artista)) {
				res = true;
				break;
			} else {
				i++;
			}
		}
		return res;
	}

	public ListaReproduccion getSublistaArtista(String artista) {
		ListaReproduccion listaNueva = null;
		Integer i = 0;
		for (Cancion c : getCanciones()) {
			if (c.getArtista().get(i).getNombre().equals(artista)) {
				listaNueva.getCanciones().add(c);
			}
			i++;
		}
		return listaNueva;
	}

	public int getPosicionCancion(String tituloCancion) {
		int res = -1;
		for (Cancion c : getCanciones()) {
			if (c.getNombre().equals(tituloCancion)) {
				res = getCanciones().indexOf(c);
			}
		}
		return res;
	}

	public Cancion getCancionMasLarga() {
		Cancion can = null;
		for (Cancion c : getCanciones()) {
			if (c.getDuracion().compareTo(can.getDuracion()) > 0) {
				can.equals(c);
			}
		}
		return can;
	}

	public Cancion getCancionMasCorta() {
		Cancion can = null;
		for (Cancion c : getCanciones()) {
			if (c.getDuracion().compareTo(can.getDuracion()) < 0) {
				can.equals(c);
			}
		}
		return can;
	}

	public Set<Artista> getArtistas() {
		Set<Artista> art = new HashSet<>();
		for (Cancion c : getCanciones()) {
			art.addAll(c.getArtista());
		}
		return art;
	}

	public String toString() {
		return getNombre() + " (" + getNumCanciones() + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaReproduccionImpl other = (ListaReproduccionImpl) obj;
		if (canciones == null) {
			if (other.canciones != null)
				return false;
		} else if (!canciones.equals(other.canciones))
			return false;
		return true;
	}
}
