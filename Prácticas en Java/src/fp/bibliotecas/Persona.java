package fp.bibliotecas;

import java.time.LocalDate;

public interface Persona {

	String getDni();

	void setDni(String dni);

	String getNombre();

	void setNombre(String nombre);

	String getApellidos();

	void setApellidos(String apellidos);

	LocalDate getFechaNacimiento();

	void setFechaNacimiento(LocalDate fechaNacimiento);

	Integer getEdad();

	void setEdad(Integer edad);

	String getEmail();

	void setEmail(String email);

}