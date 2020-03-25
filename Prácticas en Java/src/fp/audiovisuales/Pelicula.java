package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public interface Pelicula {

	String getTituloOriginal();

	void setTituloOriginal(String tituloOriginal);

	String getIdiomaOriginal();

	void setIdiomaOriginal(String idiomaOriginal);

	LocalDate getFechaEstreno();

	void setFechaEstreno(LocalDate fechaEstreno);

	Duration getDuracion();

	void setDuracion(Duration duracion);

	List<String> getGenero();

	void setGenero(List<String> genero);

	List<String> getProductora();

	void setProductora(List<String> productora);

	List<String> getPais();

	void setPais(List<String> pais);

	List<MiembroStaff> getDirector();

	void setDirector(List<MiembroStaff> director);

	List<MiembroStaff> getActores();

	void setActores(List<MiembroStaff> actores);

	List<MiembroStaff> getGuionistas();

	void setGuionistas(List<MiembroStaff> guionistas);

	Integer getId();

	String getTitulo();

	TipoMetraje getTipoMet();

}