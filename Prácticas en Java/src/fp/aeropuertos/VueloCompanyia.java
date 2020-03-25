package fp.aeropuertos;

import fp.bibliotecas.Persona;

public interface VueloCompanyia extends Vuelo {

	Persona getCapitan();

	void setCapitan(Persona capitan);

	String getNombreCompanyia();

}