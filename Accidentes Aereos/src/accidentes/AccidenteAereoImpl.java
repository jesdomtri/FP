package accidentes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class AccidenteAereoImpl implements AccidenteAereo {
	private LocalDate fecha;
	private String lugar;
	private String operadora;
	private String origenVuelo;
	private String destinoVuelo;
	private String modeloAvion;
	private Integer numPasajeros;
	private Integer numFallecidos;
		
	public AccidenteAereoImpl(String filaCsv){
		String[] trozos = filaCsv.split("\t");
		
		this.fecha = LocalDate.parse(trozos[0].trim(),DateTimeFormatter.ofPattern("MM/dd/yyyy"));
		
		this.lugar = trozos[1].trim();	
		this.operadora = trozos[2].trim();
				
		String[] aux = trozos[3].trim().split("-");
		if(aux.length==2){
			this.origenVuelo = aux[0].trim();
			this.destinoVuelo = aux[1].trim();
		}			
		
		this.modeloAvion = trozos[4].trim();
		
		
		Integer numPasajeros = new Integer(trozos[5].trim());
		if(numPasajeros<0){
			throw new IllegalArgumentException("Numero pasajeros negativo");
		}
		this.numPasajeros = numPasajeros;
		
		
		Integer numFallecidos = new Integer(trozos[6].trim());
		if(numFallecidos<0){
			throw new IllegalArgumentException("Numero fallecidos negativo");
		}
		this.numFallecidos = numFallecidos;			
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public String getLugar() {
		return lugar;
	}
	
	public String getOperadora() {
		return operadora;
	}
	
	public String getOrigenVuelo() {
		return origenVuelo;
	}
	
	public String getDestinoVuelo() {
		return destinoVuelo;
	}
	
	public String getModeloAvion() {
		return modeloAvion;
	}
	
	public Integer getNumPasajeros() {
		return numPasajeros;
	}
	
	public Integer getNumFallecidos() {
		return numFallecidos;
	}	
	
	public String toString() {
		return "AccidenteAereo [fecha=" + fecha +  ", lugar=" + lugar + ", operadora=" + operadora
				+ ", origenVuelo=" + origenVuelo + ", destinoVuelo=" + destinoVuelo + ", modeloAvion=" + modeloAvion
				+ ", numPasajeros=" + numPasajeros + ", numFallecidos=" + numFallecidos + "]";
	}
	
	public boolean equals(Object o){
		boolean eq = false;
		
		if(o instanceof AccidenteAereo){
			AccidenteAereo aa = (AccidenteAereo)o;
			eq = this.getDestinoVuelo().equals(aa.getDestinoVuelo()) &&
						this.getFecha().equals(aa.getFecha()) &&
						this.getLugar().equals(aa.getLugar());
		}		
		return eq;
	}
	
	public int hashCode(){
		return (this.getDestinoVuelo().hashCode() + this.getFecha().hashCode()*37) + this.getLugar().hashCode()*31;
	}

}
