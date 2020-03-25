package fp.musica;

import java.time.Duration;
import java.util.List;

public interface Cancion {

	Integer getPopularidad();

	void setPopularidad(Integer popularidad);

	String getId();

	String getNombre();

	List<Artista> getArtista();

	Duration getDuracion();

	Integer getNumPista();

}