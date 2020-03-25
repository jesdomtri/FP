package fp.musica;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class CancionImpl implements Cancion {

	private String id;
	private String nombre;
	private List<Artista> artista;
	private Duration duracion;
	private Integer numPista;
	private Integer popularidad;
	private String urlPreescucha;

	public CancionImpl(String id, String nombre, List<Artista> artista, Duration duracion, Integer numPista,
			Integer popularidad, String urlPreescucha) {
		super();
		Checkers.check("id formado por 2 char", id.length() == 22);
		Checkers.check("Duracion en segundos mayor que 0", duracion.getSeconds() > 0);
		Checkers.check("NumPista mayor que 0", numPista > 0);
		Checkers.check("Popularidad entre 0 y 100", popularidad >= 0 && popularidad <= 100);
		Checkers.check("urlPreescucha empezar con HTTP", urlPreescucha.startsWith("http"));
		this.id = id;
		this.nombre = nombre;
		this.artista = artista;
		this.duracion = duracion;
		this.numPista = numPista;
		this.popularidad = popularidad;
		this.urlPreescucha = urlPreescucha;
	}

	public Integer getPopularidad() {
		return popularidad;
	}

	public void setPopularidad(Integer popularidad) {
		this.popularidad = popularidad;
	}

	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public List<Artista> getArtista() {
		return new ArrayList<Artista>(artista);
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Integer getNumPista() {
		return numPista;
	}

	public String getUrlPreescucha() {
		return urlPreescucha;
	}

	public String toString() {
		return getNombre() + " [" + getArtista() + "]";
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
		CancionImpl other = (CancionImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
