package fp.musica;

public interface CancionDescarga extends Cancion {

	Double getTamanyo();

	void setTamanyo(Double tamanyo);

	FormatoCancion getFormato();

}