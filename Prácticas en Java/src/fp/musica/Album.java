package fp.musica;

import java.util.List;

public interface Album {

	String getId();

	String getNombre();

	Integer getPopularidad();

	Integer getAnyoPublicacion();

	TipoAlbum getTipo();

	List<Cancion> getCanciones();

	List<Artista> getArtistas();

	List<String> getGeneros();

	List<String> getUrlImagenes();

}