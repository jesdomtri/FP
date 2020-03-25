package fp.musica;

import java.util.List;

public interface Artista {

	List<String> getUrlImagen();

	void setUrlImagen(List<String> urlImagen);

	String getId();

	String getNombre();

	List<String> getGenero();

	Integer getPopularidad();

}