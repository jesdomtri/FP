package fp.bibliotecas;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import fp.utiles.Checkers;

public class PersonaImpl implements Persona {

	private String dni;
	private String nombre;
	private String apellidos;
	private LocalDate fechaNacimiento;
	private Integer edad;
	private String email;

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento, String email) {
		super();
		Checkers.checkNoNull(dni, nombre, apellidos, fechaNacimiento, edad, email);
		Checkers.check("La fecha de nacimiento debe ser antes que la actual",
				fechaNacimiento.isBefore(LocalDate.now()));
		Checkers.check("Correo con @", email.contains("@"));
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
		this.email = email;
	}

	public PersonaImpl(String dni, String nombre, String apellidos, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNacimiento = fechaNacimiento;
	}

	public PersonaImpl(String s) {
		String[] trozos = s.split(",");
		Checkers.check("Formato String no valido", trozos.length == 5);
		LocalDate fechaNacimientoAux = LocalDate.parse(trozos[4].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		Checkers.check("La fecha de nacimiento debe ser antes que la actual",
				fechaNacimientoAux.isBefore(LocalDate.now()));
		String emailAux = trozos[5].trim();
		Checkers.check("Correo con @", emailAux.contains("@"));
		this.nombre = trozos[0].trim();
		this.apellidos = trozos[1].trim();
		this.dni = trozos[2].trim();
		this.fechaNacimiento = fechaNacimientoAux;
		this.email = emailAux;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		Checkers.check("La fecha de nacimiento debe ser antes que la actual",
				fechaNacimiento.isBefore(LocalDate.now()));
		this.fechaNacimiento = fechaNacimiento;
	}

	public Integer getEdad() {
		return LocalDate.now().getYear() - getFechaNacimiento().getYear();
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		Checkers.check("Correo con @", email.contains("@"));
		this.email = email;
	}

	public String toString() {
		return getDni() + " - " + getApellidos() + ", " + getNombre() + " - " + getFechaNacimiento();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dni == null) ? 0 : dni.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonaImpl other = (PersonaImpl) obj;
		if (dni == null) {
			if (other.dni != null)
				return false;
		} else if (!dni.equals(other.dni))
			return false;
		return true;
	}

}
