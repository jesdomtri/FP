package fp.bibliotecas;

public interface Empleado extends Persona {

	String getPuesto();

	void setPuesto(String puesto);

	TipoContrato getContrato();

}