package fp.musica;

import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class ArtistaImpl implements Artista {

	private String id;
	private String nombre;
	private List<String> genero;
	private Integer popularidad;
	private List<String> urlImagen;

	public ArtistaImpl(String id, String nombre, List<String> genero, Integer popularidad, List<String> urlImagen) {
		super();
		Checkers.check("Popularidad entre 0 y 100", popularidad >= 0 && popularidad <= 100);
		Checkers.check("Todas urlImagenes empiezan con HTTP", checkUrlImagenes(urlImagen));
		Checkers.check("id formado por 22 caracteres", id.length() == 22);
		this.id = id;
		this.nombre = nombre;
		this.genero = genero;
		this.popularidad = popularidad;
		this.urlImagen = urlImagen;
	}

	public Boolean checkUrlImagenes(List<String> urlImagenes) {
		Boolean res = false;
		Integer i;
		for (i = 0; i <= urlImagenes.size(); i++) {
			if (urlImagenes.get(i).startsWith("http")) {
				res = true;
			}
		}
		return res;
	}

	public List<String> getUrlImagen() {
		return new ArrayList<String>(urlImagen);
	}

	public void setUrlImagen(List<String> urlImagen) {
		this.urlImagen = urlImagen;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<String> getGenero() {
		return new ArrayList<String>(genero);
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public String toString() {
		return getNombre() + " [" + getId() + "]";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArtistaImpl other = (ArtistaImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
