package ar.fi.uba.celdas;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Teoria {
		
	public MABObject condicionesSupuestas;
	public MABObject efectosPredichos;
	private boolean utilidad;
	private int cantExitos=0; //P
	private int cantUsos=0; //K		
	
	public void incExitos(){
		this.cantExitos++;
	}
	
	public void incUsos(){
		this.cantUsos++;		
	}
	
	public int getCantUsos(){
		return this.cantUsos;
	}
	
	public int getCantExitos(){
		return this.cantExitos;
	}
	
	public boolean isExitosa(){
		return this.cantExitos==this.cantUsos;
	}
	
	public void copyExitosUsos(Teoria t){
		this.cantExitos=t.getCantExitos();
		this.cantUsos=t.getCantUsos();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime
				* result
				+ ((condicionesSupuestas == null) ? 0 : condicionesSupuestas
						.hashCode());
		result = prime
				* result
				+ ((efectosPredichos == null) ? 0 : efectosPredichos.hashCode());
		return result;
	}



	/**
	 * <h3>Una teoría A es igual a otra B cuando:</h3>
	 * 	<ul>
	 *  	<li>Ambas tienen las mismas acciones (en este caso no tenemos acciones).</li> 
	 *      <li>Las condiciones supuestas son iguales. Entiendase por iguales que son literalmente iguales o
	 *        	bien que las condiciones supuestas de A son más especificas, es decir más restrictivas que las de B. 
	 * 			En otras palabras dada una SITUACIÓN S, puedo aplicar las teoría A o la toría B, siendo B 
	 * 			una teoria más generica o a lo sumo igual que A.</li>
	 * 		<li>Los efectos predichos por A son iguales o más especificos que los predichos por B.
	 * 			En este caso todos los efectos predichos son TRUE o FALSE, por lo cual solo podemos
	 * 			evaluar que sean iguales.</li>
	 * 	</ul> 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teoria other = (Teoria) obj;
		
		if(this.condicionesSupuestas != null && other.condicionesSupuestas!=null){
			if(!this.condicionesSupuestas.equals(other.condicionesSupuestas)) return false;
		}
		if(this.efectosPredichos!=null && other.efectosPredichos!=null){
			if(!this.efectosPredichos.equals(other.efectosPredichos)) return false;	
		}
		return true;
	}
	
	/**
	 * <h3>Una teoría A es similar a otra B cuando:</h3>
	 * 	<ul>
	 *  	<li>Ambas tienen las mismas acciones (en este caso no tenemos acciones).</li>
	 * 		<li>Los efectos predichos por A son iguales o más especificos que los predichos por B.
	 * 			En este caso todos los efectos predichos son TRUE o FALSE, por lo cual solo podemos
	 * 			evaluar que sean iguales.</li>
	 * 	</ul> 
	 * */
	public boolean similar(Object obj){
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Teoria other = (Teoria) obj;
				
		if(this.efectosPredichos!=null && other.efectosPredichos!=null){
			if(!this.efectosPredichos.equals(other.efectosPredichos)) return false;	
		}
		return true;
	}
	
	/**
	 * <h3>Una teoría A es incompatible con otra B cuando:</h3>
	 * 	<ul> 
	 *      <li>Las condiciones supuestas son iguales.</li>
	 * 		<li>Los efectos predichos por A son distintos.</li>
	 * 	</ul> 
	 * */	
	public boolean incompatible(Teoria other) {		
		
		if(this.condicionesSupuestas != null && other.condicionesSupuestas!=null){
			if(this.efectosPredichos!=null && other.efectosPredichos!=null){
				if(this.condicionesSupuestas.equals(other.condicionesSupuestas)){
					if(!this.efectosPredichos.equals(other.efectosPredichos)) return true;
				}
			}		
		}	
		return false;
	}
		
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Teoria cloned = (Teoria) super.clone();
//		cloned.condicionesSupuestas = (Percepcion) this.condicionesSupuestas.clone();
//		cloned.efectosPredichos=new Percepcion(this.efectosPredichos);
		cloned.cantExitos=this.cantExitos;
		cloned.cantUsos=this.cantUsos;
		return cloned;
	}
	
	
		
	public String toString(){	
		return this.toString(true);
	}
	
	public String toString(boolean csv){		
		StringBuffer sb = new StringBuffer("");
//		sb.append(this.condicionesSupuestas.toString(csv)+" ===> espero="+String.valueOf(this.efectosPredichos)+"; ("+this.cantExitos+", "+this.cantUsos+") ");		
		return sb.toString();
	}
	

}
