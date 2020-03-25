package fp.musica;

import java.time.Duration;
import java.util.List;

public class CancionDescargaImpl extends CancionImpl implements CancionDescarga {

	private Double tamanyo;
	private FormatoCancion formato;

	public CancionDescargaImpl(String id, String nombre, List<Artista> artista, Duration duracion, Integer numPista,
			Integer popularidad, String urlPreescucha, Double tamanyo, FormatoCancion formato) {
		super(id, nombre, artista, duracion, numPista, popularidad, urlPreescucha);
		this.tamanyo = tamanyo;
		this.formato = formato;
	}

	public Double getTamanyo() {
		return tamanyo;
	}

	public void setTamanyo(Double tamanyo) {
		this.tamanyo = tamanyo;
	}

	public FormatoCancion getFormato() {
		return formato;
	}

	public String toString() {
		return super.toString() + " - tamanyo del fichero: " + getTamanyo();
	}
}
