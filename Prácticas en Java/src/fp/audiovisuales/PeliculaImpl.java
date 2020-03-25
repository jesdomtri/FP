package fp.audiovisuales;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class PeliculaImpl implements Pelicula {

	private Integer id;
	private String titulo;
	private String tituloOriginal;
	private String idiomaOriginal;
	private LocalDate fechaEstreno;
	private Duration duracion;
	private TipoMetraje tipoMet;
	private List<String> genero;
	private List<String> productora;
	private List<String> pais;
	private List<MiembroStaff> director, actores, guionistas;

	public PeliculaImpl(Integer id, String titulo, String tituloOriginal, String idiomaOriginal, LocalDate fechaEstreno,
			Duration duracion, TipoMetraje tipoMet, List<String> genero, List<String> productora, List<String> pais,
			List<MiembroStaff> director, List<MiembroStaff> actores, List<MiembroStaff> guionistas) {
		super();
		Checkers.checkNoNull(id, titulo);
		Checkers.check("Duracion mayor que 0", duracion.toMinutes() > 0);
		this.id = id;
		this.titulo = titulo;
		this.tituloOriginal = tituloOriginal;
		this.idiomaOriginal = idiomaOriginal;
		this.fechaEstreno = fechaEstreno;
		this.duracion = duracion;
		this.tipoMet = tipoMet;
		this.genero = genero;
		this.productora = productora;
		this.pais = pais;
		this.director = director;
		this.actores = actores;
		this.guionistas = guionistas;
	}

	public PeliculaImpl(Integer id, String titulo) {
		super();
		Checkers.checkNoNull(id, titulo);
		Checkers.check("Duracion mayor que 0", duracion.toMinutes() > 0);
		this.id = id;
		this.titulo = titulo;
	}

	public String getTituloOriginal() {
		return tituloOriginal;
	}

	public void setTituloOriginal(String tituloOriginal) {
		this.tituloOriginal = tituloOriginal;
	}

	public String getIdiomaOriginal() {
		return idiomaOriginal;
	}

	public void setIdiomaOriginal(String idiomaOriginal) {
		this.idiomaOriginal = idiomaOriginal;
	}

	public LocalDate getFechaEstreno() {
		return fechaEstreno;
	}

	public void setFechaEstreno(LocalDate fechaEstreno) {
		this.fechaEstreno = fechaEstreno;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public void setDuracion(Duration duracion) {
		this.duracion = duracion;
	}

	public List<String> getGenero() {
		return new ArrayList<String>(genero);
	}

	public void setGenero(List<String> genero) {
		this.genero = genero;
	}

	public List<String> getProductora() {
		return new ArrayList<String>(productora);
	}

	public void setProductora(List<String> productora) {
		this.productora = productora;
	}

	public List<String> getPais() {
		return new ArrayList<String>(pais);
	}

	public void setPais(List<String> pais) {
		this.pais = pais;
	}

	public List<MiembroStaff> getDirector() {
		return new ArrayList<MiembroStaff>(director);
	}

	public void setDirector(List<MiembroStaff> director) {
		this.director = director;
	}

	public List<MiembroStaff> getActores() {
		return new ArrayList<MiembroStaff>(actores);
	}

	public void setActores(List<MiembroStaff> actores) {
		this.actores = actores;
	}

	public List<MiembroStaff> getGuionistas() {
		return new ArrayList<MiembroStaff>(guionistas);
	}

	public void setGuionistas(List<MiembroStaff> guionistas) {
		this.guionistas = guionistas;
	}

	public Integer getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}

	public TipoMetraje getTipoMet() {
		return tipoMet;
	}

	public String toString() {
		String res = "";
		Integer anyo = getFechaEstreno().getYear();
		if (anyo != null) {
			res = " (" + anyo + ")";
		}

		return getId() + " - " + getTitulo() + res;
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
		PeliculaImpl other = (PeliculaImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
