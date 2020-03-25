package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

import fp.utiles.Checkers;

public class SesionImpl implements Sesion {
	private Integer numSala;
	private Pelicula pelicula;
	private LocalDate fecha;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private Duration duracion;
	private Double precio;
	private Boolean vos;
	private Boolean descanso;
	private CalificacionPorEdades calificacionEdad;

	public SesionImpl(Integer numSala, Pelicula pelicula, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
			Duration duracion, Double precio, Boolean vos, Boolean descanso, CalificacionPorEdades calificacionEdad) {
		super();
		Checkers.check("Precio mayor o igual que 0", precio >= 0);
		this.numSala = numSala;
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
		this.precio = precio;
		this.vos = vos;
		this.descanso = descanso;
		this.calificacionEdad = calificacionEdad;
	}

	public SesionImpl(Integer numSala, Pelicula pelicula, LocalDate fecha, LocalTime horaInicio, LocalTime horaFin,
			Duration duracion, Double precio, CalificacionPorEdades calificacionEdad) {
		super();
		Checkers.check("Precio mayor o igual que 0", precio >= 0);
		this.numSala = numSala;
		this.pelicula = pelicula;
		this.fecha = fecha;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
		this.precio = precio;
		this.calificacionEdad = calificacionEdad;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Boolean getDescanso() {
		return descanso;
	}

	public void setDescanso(Boolean descanso) {
		this.descanso = descanso;
	}

	public Integer getNumSala() {
		return numSala;
	}

	public Pelicula getPelicula() {
		return pelicula;
	}

	public LocalDate getFecha() {
		return fecha;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public Boolean getVos() {
		return vos;
	}

	public CalificacionPorEdades getCalificacionEdad() {
		return calificacionEdad;
	}

	public Boolean sesionGolfa() {
		Boolean res = false;
		if (getHoraInicio().isAfter(LocalTime.of(0, 0)) && getHoraInicio().isBefore(LocalTime.of(8, 0))) {
			res = true;
		}
		return res;
	}

	public Boolean sesionMatinal() {
		Boolean res = false;
		if (getHoraInicio().isBefore(LocalTime.of(14, 0)) && getHoraInicio().isAfter(LocalTime.of(8, 0))) {
			res = true;
		}
		return res;
	}

	public void retrasa(Integer minutos) {
		getHoraInicio().plusMinutes(minutos);
	}

	public String toString() {
		return getNumSala() + " (" + getFecha() + " " + getHoraInicio() + ") " + getPelicula().getTitulo();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fecha == null) ? 0 : fecha.hashCode());
		result = prime * result + ((numSala == null) ? 0 : numSala.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SesionImpl other = (SesionImpl) obj;
		if (fecha == null) {
			if (other.fecha != null)
				return false;
		} else if (!fecha.equals(other.fecha))
			return false;
		if (numSala == null) {
			if (other.numSala != null)
				return false;
		} else if (!numSala.equals(other.numSala))
			return false;
		return true;
	}

}
