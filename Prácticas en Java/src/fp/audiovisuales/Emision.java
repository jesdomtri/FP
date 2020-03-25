package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDateTime;

public interface Emision {

	LocalDateTime getFechaEmision();

	void setFechaEmision(LocalDateTime fechaEmision);

	Duration getDuracion();

	void setDuracion(Duration duracion);

	SerieTV getSerie();

	String getCadenaTV();

	LocalDateTime getFechaFinEmision();

}