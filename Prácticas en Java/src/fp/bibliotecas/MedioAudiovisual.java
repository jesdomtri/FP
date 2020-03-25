package fp.bibliotecas;

import java.time.Duration;
import java.time.LocalDate;

public interface MedioAudiovisual {

	TipoPrestamo getTipoPres();

	void setTipoPres(TipoPrestamo tipoPres);

	String getCodigo();

	String getTitulo();

	Duration getDuracion();

	LocalDate getFechaAdquisicion();

}