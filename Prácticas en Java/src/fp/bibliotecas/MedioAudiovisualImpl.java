package fp.bibliotecas;

import java.time.Duration;
import java.time.LocalDate;

import fp.utiles.Checkers;

public class MedioAudiovisualImpl implements MedioAudiovisual {

	private String codigo;
	private String titulo;
	private Duration duracion;
	private LocalDate fechaAdquisicion;
	private TipoPrestamo tipoPres;

	public MedioAudiovisualImpl(String codigo, String titulo, Duration duracion, LocalDate fechaAdquisicion,
			TipoPrestamo tipoPres) {
		super();
		Checkers.check("Duracion en minutos mayor que 0", duracion.toMinutes() > 0);
		this.codigo = codigo;
		this.titulo = titulo;
		this.duracion = duracion;
		this.fechaAdquisicion = fechaAdquisicion;
		this.tipoPres = tipoPres;
	}

	public TipoPrestamo getTipoPres() {
		return tipoPres;
	}

	public void setTipoPres(TipoPrestamo tipoPres) {
		this.tipoPres = tipoPres;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getTitulo() {
		return titulo;
	}

	public Duration getDuracion() {
		return duracion;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public String toString() {
		return getTitulo() + " (DVD " + getCodigo() + ")";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MedioAudiovisualImpl other = (MedioAudiovisualImpl) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
