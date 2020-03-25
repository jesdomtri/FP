package fp.audiovisuales;

import java.time.LocalDate;

public interface SerieTV {

	LocalDate getFechaUltimaEmision();

	void setFechaUltimaEmision(LocalDate fechaUltimaEmision);

	LocalDate getFechaPrimeraEmision();

	void setFechaPrimeraEmision(LocalDate fechaPrimeraEmision);

	String getCadenaTV();

	void setCadenaTV(String cadenaTV);

	String getGenero();

	void setGenero(String genero);

	String getNombreOriginal();

	void setNombreOriginal(String nombreOriginal);

	String getIdiomaOriginal();

	void setIdiomaOriginal(String idiomaOriginal);

	EstadoSerie getEstado();

	void setEstado(EstadoSerie estado);

	Integer getId();

	String getNombre();

	Double getPopularidad();

	Integer getNumTemporadas();

}