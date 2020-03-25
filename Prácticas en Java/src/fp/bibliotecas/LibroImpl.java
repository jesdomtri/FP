package fp.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class LibroImpl implements Libro {

	private String isbn;
	private String titulo;
	private String autor;
	private Integer numPaginas;
	private LocalDate fechaAdquisicion;
	private Double precio;
	private Long copiasVendidas;
	private TipoPrestamo tipoPres;
	private final Long copiasParaBS = 500000L;

	public LibroImpl(String isbn, String titulo, String autor, Integer numPaginas, LocalDate fechaAdquisicion,
			Double precio, Long copiasVendidas, TipoPrestamo tipoPres) {
		super();
		Checkers.check("NumPaginas mayor que 0", numPaginas > 0);
		Checkers.check("Fecha adquisicion anterior o igual que la actual",
				fechaAdquisicion.isBefore(LocalDate.now()) || fechaAdquisicion.equals(LocalDate.now()));
		this.isbn = isbn;
		this.titulo = titulo;
		this.autor = autor;
		this.numPaginas = numPaginas;
		this.fechaAdquisicion = fechaAdquisicion;
		this.precio = precio;
		this.copiasVendidas = copiasVendidas;
		this.tipoPres = tipoPres;
	}

	public LibroImpl(String s) {
		String[] trozos = s.split("#");
		Checkers.check("Formato String no valido", trozos.length == 8);

		Integer numPaginasAux = new Integer(trozos[3].trim());
		LocalDate fechaAdquisicionAux = LocalDate.parse(trozos[4].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));

		Checkers.check("NumPaginas mayor que 0", numPaginasAux > 0);
		Checkers.check("Fecha adquisicion anterior o igual que la actual",
				fechaAdquisicionAux.isBefore(LocalDate.now()) || fechaAdquisicionAux.equals(LocalDate.now()));

		this.isbn = trozos[0].trim();
		this.titulo = trozos[1].trim();
		this.autor = trozos[2].trim();
		this.numPaginas = numPaginasAux;
		this.fechaAdquisicion = fechaAdquisicionAux;
		this.precio = new Double(trozos[5].trim());
		this.copiasVendidas = new Long(trozos[6].trim());
		this.tipoPres = TipoPrestamo.valueOf(trozos[7].trim());
	}

	public Long getCopiasVendidas() {
		return copiasVendidas;
	}

	public void setCopiasVendidas(Long copiasVendidas) {
		this.copiasVendidas = copiasVendidas;
	}

	public TipoPrestamo getTipoPres() {
		return tipoPres;
	}

	public void setTipoPres(TipoPrestamo tipoPres) {
		this.tipoPres = tipoPres;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public Integer getNumPaginas() {
		return numPaginas;
	}

	public LocalDate getFechaAdquisicion() {
		return fechaAdquisicion;
	}

	public Double getPrecio() {
		return precio;
	}

	public Boolean esBestSeller() {
		Boolean res = false;
		if (getCopiasVendidas() > copiasParaBS) {
			res = true;
		}
		return res;
	}

	public Integer numDiasPrestados() {
		Integer res = 1;
		if (getTipoPres() == TipoPrestamo.MENSUAL) {
			res = 30;
		} else {
			if (getTipoPres() == TipoPrestamo.SEMANAL) {
				res = 7;
			}
		}
		return res;
	}

	public String toString() {
		return getTitulo() + " (ISBN: " + getIsbn() + ").";
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
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
		LibroImpl other = (LibroImpl) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}

}
