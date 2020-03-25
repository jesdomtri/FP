package accidentes;

import java.time.LocalDate;

public interface AccidenteAereo {

	LocalDate getFecha();
	String getLugar();
	String getOperadora();
	String getOrigenVuelo();
	String getDestinoVuelo();
	String getModeloAvion();
	Integer getNumPasajeros();
	Integer getNumFallecidos();	
}