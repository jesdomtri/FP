package fp.audiovisuales;

import java.time.LocalDate;
import java.util.List;

public interface MiembroStaff {

	String getNombre();

	void setNombre(String nombre);

	LocalDate getFechaNacimiento();

	void setFechaNacimiento(LocalDate fechaNacimiento);

	LocalDate getFechaDefuncion();

	void setFechaDefuncion(LocalDate fechaDefuncion);

	String getLugarNacimiento();

	void setLugarNacimiento(String lugarNacimiento);

	List<String> getAlias();

	void setAlias(List<String> alias);

	Integer getId();

	Integer getEdad();

}