package fp.musica;

import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class AlbumImpl implements Album {

	private String id;
	private String nombre;
	private Integer popularidad;
	private Integer anyoPublicacion;
	private TipoAlbum tipo;
	private List<Cancion> canciones;
	private List<Artista> artistas;
	private List<String> generos, urlImagenes;

	public AlbumImpl(String id, String nombre, Integer popularidad, Integer anyoPublicacion, TipoAlbum tipo,
			List<Cancion> canciones, List<Artista> artistas, List<String> generos, List<String> urlImagenes) {
		super();
		Checkers.check("id debe contener 22 chars", id.length() == 22);
		Checkers.check("Popularidad entre 0 y 100", popularidad >= 0 && popularidad <= 100);
		Checkers.check("Todas urlImagenes empiezan con HTTP", checkUrlImagenes(urlImagenes));
		this.id = id;
		this.nombre = nombre;
		this.popularidad = popularidad;
		this.anyoPublicacion = anyoPublicacion;
		this.tipo = tipo;
		this.canciones = canciones;
		this.artistas = artistas;
		this.generos = generos;
		this.urlImagenes = urlImagenes;
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

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public Integer getAnyoPublicacion() {
		return anyoPublicacion;
	}

	public TipoAlbum getTipo() {
		return tipo;
	}

	public List<Cancion> getCanciones() {
		return new ArrayList<Cancion>(canciones);
	}

	public List<Artista> getArtistas() {
		return new ArrayList<Artista>(artistas);
	}

	public List<String> getGeneros() {
		return new ArrayList<String>(generos);
	}

	public List<String> getUrlImagenes() {
		return new ArrayList<String>(urlImagenes);
	}

	public String toString() {
		return getNombre() + " (" + getId() + ")";
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
		AlbumImpl other = (AlbumImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
