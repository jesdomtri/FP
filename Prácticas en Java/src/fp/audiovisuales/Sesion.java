package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public interface Sesion {

	Double getPrecio();

	void setPrecio(Double precio);

	Boolean getDescanso();

	void setDescanso(Boolean descanso);

	Integer getNumSala();

	Pelicula getPelicula();

	LocalDate getFecha();

	LocalTime getHoraInicio();

	LocalTime getHoraFin();

	Duration getDuracion();

	Boolean getVos();

	CalificacionPorEdades getCalificacionEdad();

}