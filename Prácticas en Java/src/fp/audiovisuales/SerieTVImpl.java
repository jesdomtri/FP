package fp.audiovisuales;

import java.time.LocalDate;

import fp.utiles.Checkers;

public class SerieTVImpl implements SerieTV {

	private Integer id;
	private String nombre;
	private LocalDate fechaPrimeraEmision;
	private LocalDate fechaUltimaEmision;
	private String cadenaTV;
	private String genero;
	private String nombreOriginal;
	private String idiomaOriginal;
	private Double popularidad;
	private EstadoSerie estado;
	private Integer numTemporadas;

	public SerieTVImpl(Integer id, String nombre, LocalDate fechaPrimeraEmision, String cadenaTV, String genero,
			String nombreOriginal, String idiomaOriginal, Double popularidad, EstadoSerie estado,
			Integer numTemporadas) {
		super();
		Checkers.check("NumTemporadas mayor que 0", numTemporadas > 0);
		Checkers.checkNoNull(id, nombre, estado, numTemporadas);
		this.id = id;
		this.nombre = nombre;
		this.fechaPrimeraEmision = fechaPrimeraEmision;
		this.cadenaTV = cadenaTV;
		this.genero = genero;
		this.nombreOriginal = nombreOriginal;
		this.idiomaOriginal = idiomaOriginal;
		this.popularidad = popularidad;
		this.estado = estado;
		this.numTemporadas = numTemporadas;
	}

	public SerieTVImpl(Integer id, String nombre, EstadoSerie estado, Integer numTemporadas) {
		super();
		Checkers.check("NumTemporadas mayor que 0", numTemporadas > 0);
		Checkers.checkNoNull(id, nombre, estado, numTemporadas);
		this.id = id;
		this.nombre = nombre;
		this.estado = estado;
		this.numTemporadas = numTemporadas;
	}

	public SerieTVImpl(Integer id, String nombre) {
		super();
		Checkers.check("NumTemporadas mayor que 0", numTemporadas > 0);
		Checkers.checkNoNull(id, nombre, estado, numTemporadas);
		this.id = id;
		this.nombre = nombre;
		this.estado = EstadoSerie.EN_CURSO;
		this.numTemporadas = 1;
	}

	public LocalDate getFechaPrimeraEmision() {
		return fechaPrimeraEmision;
	}

	public void setFechaPrimeraEmision(LocalDate fechaPrimeraEmision) {
		this.fechaPrimeraEmision = fechaPrimeraEmision;
	}

	public String getCadenaTV() {
		return cadenaTV;
	}

	public void setCadenaTV(String cadenaTV) {
		this.cadenaTV = cadenaTV;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNombreOriginal() {
		return nombreOriginal;
	}

	public void setNombreOriginal(String nombreOriginal) {
		this.nombreOriginal = nombreOriginal;
	}

	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}

	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}

	public EstadoSerie getEstado() {
		return estado;
	}

	public void setEstado(EstadoSerie estado) {
		this.estado = estado;
	}

	public Integer getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public Double getPopularidad() {
		return popularidad;
	}

	public Integer getNumTemporadas() {
		return numTemporadas;
	}

	public LocalDate getFechaUltimaEmision() {
		return fechaUltimaEmision;
	}

	public void setFechaUltimaEmision(LocalDate fechaUltimaEmision) {
		this.fechaUltimaEmision = fechaUltimaEmision;
	}

	public String toString() {
		return getId() + " - " + getNombre() + " (" + getEstado() + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SerieTVImpl other = (SerieTVImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
