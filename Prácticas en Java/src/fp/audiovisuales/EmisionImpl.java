package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDateTime;

public class EmisionImpl implements Emision {
	private SerieTV serie;
	private String cadenaTV;
	private LocalDateTime fechaEmision;
	private Duration duracion;
	private LocalDateTime fechaFinEmision;

	public EmisionImpl(SerieTV serie, String cadenaTV, LocalDateTime fechaEmision, Duration duracion) {
		super();
		this.serie = serie;
		this.cadenaTV = cadenaTV;
		this.fechaEmision = fechaEmision;
		this.duracion = duracion;
	}

	public EmisionImpl(SerieTV serie, String cadenaTV, LocalDateTime fechaEmision, LocalDateTime fechaFinEmision) {
		super();
		this.serie = serie;
		this.cadenaTV = cadenaTV;
		this.fechaEmision = fechaEmision;
		this.fechaFinEmision = fechaFinEmision;
	}

	public LocalDateTime getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(LocalDateTime fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public SerieTV getSerie() {
		return serie;
	}

	public String getCadenaTV() {
		return cadenaTV;
	}

	public LocalDateTime getFechaFinEmision() {
		return fechaFinEmision;
	}

	public String toString() {
		return getSerie().getNombre() + "; " + getCadenaTV() + " " + getFechaEmision();
	}
}
