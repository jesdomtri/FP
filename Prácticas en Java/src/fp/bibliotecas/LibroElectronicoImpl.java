package fp.bibliotecas;

import java.time.LocalDate;

public class LibroElectronicoImpl extends LibroImpl implements LibroElectronico {

	private String eISBN;
	private FormatoLibroE formato;

	public LibroElectronicoImpl(String isbn, String titulo, String autor, Integer numPaginas,
			LocalDate fechaAdquisicion, Double precio, Long copiasVendidas, TipoPrestamo tipoPres, String eISBN,
			FormatoLibroE formato) {
		super(isbn, titulo, autor, numPaginas, fechaAdquisicion, precio, copiasVendidas, tipoPres);
		this.eISBN = eISBN;
		this.formato = formato;
	}

	public String geteISBN() {
		return eISBN;
	}

	public FormatoLibroE getFormato() {
		return formato;
	}

	public String toString() {
		return super.toString() + " - eISBN: " + geteISBN();
	}

}
