package accidentes;

import java.util.List;

public interface EstadisticasAccidentes {

	Double mediaFallecidos(String lugar);

	List<AccidenteAereo> getAccidentes();

}