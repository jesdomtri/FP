package fp.audiovisuales;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.utiles.Checkers;

public class MiembroStaffImpl implements MiembroStaff {

	private Integer id;
	private String nombre;
	private LocalDate fechaNacimiento;
	private LocalDate fechaDefuncion;
	private Integer edad;
	private String lugarNacimiento;
	private List<String> alias;

	public MiembroStaffImpl(Integer id, String nombre, LocalDate fechaNacimiento, LocalDate fechaDefuncion,
			Integer edad, String lugarNacimiento, List<String> alias) {
		super();
		Checkers.check("FechaDefuncion igual o posterior a nacimiento",
				fechaDefuncion.isAfter(fechaNacimiento) || fechaDefuncion.equals(fechaNacimiento));
		Checkers.checkNoNull(id, nombre);
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.fechaDefuncion = fechaDefuncion;
		this.edad = edad;
		this.lugarNacimiento = lugarNacimiento;
		this.alias = alias;
	}

	public MiembroStaffImpl(Integer id, String nombre, LocalDate fechaNacimiento, Integer edad, String lugarNacimiento,
			List<String> alias) {
		super();
		Checkers.check("FechaDefuncion igual o posterior a nacimiento",
				fechaDefuncion.isAfter(fechaNacimiento) || fechaDefuncion.equals(fechaNacimiento));
		Checkers.checkNoNull(id, nombre);
		this.id = id;
		this.nombre = nombre;
		this.fechaNacimiento = fechaNacimiento;
		this.edad = edad;
		this.lugarNacimiento = lugarNacimiento;
		this.alias = alias;
	}

	public MiembroStaffImpl(Integer id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaDefuncion() {
		return fechaDefuncion;
	}

	public void setFechaDefuncion(LocalDate fechaDefuncion) {
		this.fechaDefuncion = fechaDefuncion;
	}

	public String getLugarNacimiento() {
		return lugarNacimiento;
	}

	public void setLugarNacimiento(String lugarNacimiento) {
		this.lugarNacimiento = lugarNacimiento;
	}

	public List<String> getAlias() {
		return new ArrayList<String>(alias);
	}

	public void setAlias(List<String> alias) {
		this.alias = alias;
	}

	public Integer getId() {
		return id;
	}

	public Integer getEdad() {
		return edad;
	}

	public String toString() {
		return getNombre();
	}

	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MiembroStaffImpl other = (MiembroStaffImpl) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
