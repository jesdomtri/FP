package fp.bibliotecas;

import java.time.LocalDate;

public interface Libro {

	Long getCopiasVendidas();

	void setCopiasVendidas(Long copiasVendidas);

	TipoPrestamo getTipoPres();

	void setTipoPres(TipoPrestamo tipoPres);

	String getIsbn();

	String getTitulo();

	String getAutor();

	Integer getNumPaginas();

	LocalDate getFechaAdquisicion();

	Double getPrecio();

	Integer numDiasPrestados();

	Boolean esBestSeller();

}