package fp.factorias;

import java.time.Duration;
import java.util.List;

import fp.musica.AlbumImpl;
import fp.musica.Artista;
import fp.musica.ArtistaImpl;
import fp.musica.Cancion;
import fp.musica.CancionImpl;
import fp.musica.TipoAlbum;

public class Musica {

	public AlbumImpl creaAlbum(String id, String nombre, TipoAlbum tipo, List<Artista> artistas, List<String> generos,
			Integer popularidad, Integer anyoPublicacion, List<Cancion> canciones, List<String> urlImagenes) {
		return new AlbumImpl(id, nombre, popularidad, anyoPublicacion, tipo, canciones, artistas, generos, urlImagenes);
	}

	public CancionImpl creaCancion(String id, String nombre, List<Artista> artistas, Duration duracion,
			Integer numeroPista, Integer popularidad, String urlPreescucha) {
		return new CancionImpl(id, nombre, artistas, duracion, numeroPista, popularidad, urlPreescucha);
	}

	public ArtistaImpl creaArtista(String id, String nombre, List<String> generos, Integer popularidad,
			List<String> urlImagenes) {
		return new ArtistaImpl(id, nombre, generos, popularidad, urlImagenes);
	}

}
