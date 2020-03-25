package fp.musica;

import java.time.Duration;
import java.util.List;

import fp.audiovisuales.Pelicula;

public class CancionBandaSonoraImpl extends CancionImpl implements CancionBandaSonora {

	private Pelicula pelicula;

	public CancionBandaSonoraImpl(String id, String nombbre, List<Artista> artista, Duration duracion, Integer numPista,
			Integer popularidad, String urlPreescucha, Pelicula pelicula) {
		super(id, nombbre, artista, duracion, numPista, popularidad, urlPreescucha);
		this.pelicula = pelicula;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public String toString() {
		return super.toString() + " - pelicula: " + getPelicula();
	}
}
