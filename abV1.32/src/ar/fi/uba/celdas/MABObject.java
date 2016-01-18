package ar.fi.uba.celdas;

import ab.vision.ABObject;


/*
 * Modelo de objeto. Contiene el ABObject, el tipo, si es alcanzable y su ubicacion relativa
 * a algun cerdito
 */
public class MABObject {

	public enum Tipo{
		CERDITO("cerdito"), MADERA("madera");
		private String name;

		private Tipo(String stringVal) {
		    name = stringVal;
		}
		public String toString(){
		    return name;
		}	
	}
	
	public ABObject aboject = null;
	public Tipo tipo = null;
	public Boolean arribaDe = null;
	public Boolean abajoDe = null;
	public Boolean derechaDe = null;
	public Boolean izquierdaDe = null;
	public Boolean alcanzable = null;


	public MABObject(ABObject obj, String unTipo, Boolean arriba, Boolean abajo, Boolean derecha, Boolean izquierda,
						Boolean alcan) {
		aboject = obj;
		//tipo = (Tipo)unTipo;
		arribaDe = arriba;
		abajoDe = abajo;
		derechaDe = derecha;
		izquierdaDe = izquierda;
		alcanzable = alcan;
		
	}
	public MABObject(String[] strCond) {
		this.tipo =  Sensor.valueOfIgnoreCase(Tipo.class,strCond[0].trim());
		this.arribaDe = Boolean.valueOf(strCond[1].trim());
		this.abajoDe = Boolean.valueOf(strCond[2].trim());
		this.derechaDe = Boolean.valueOf(strCond[3].trim());
		this.izquierdaDe = Boolean.valueOf(strCond[4].trim());		
		this.alcanzable = Boolean.valueOf(strCond[5].trim());
	}

/*	public String toString(){
		StringBuffer sb = new StringBuffer("");
		if(this.alternativa!=null) sb.append(this.alternativa); else sb.append("-----");
		sb.append(",");
		if(this.bar!=null) sb.append(this.bar); else sb.append("-----");
		sb.append(",");
		if(this.viernesSabado!=null) sb.append(this.viernesSabado); else sb.append("-----");
		sb.append(",");
		if(this.hambriento!=null) sb.append(this.hambriento); else sb.append("-----");
		sb.append(",");
		if(this.clientes!=null) sb.append(this.clientes.toString()); else sb.append("-----");
		sb.append(",");
		if(this.precio!=null) sb.append(this.precio.toString()); else sb.append("-----");
		sb.append(",");
		if(this.lloviendo!=null) sb.append(this.lloviendo); else sb.append("-----");
		sb.append(",");
		if(this.reserva!=null) sb.append(this.reserva); else sb.append("-----");
		sb.append(",");
		if(this.tipo!=null) sb.append(this.tipo.toString()); else sb.append("-----");
		sb.append(",");
		if(this.tiempo!=null) sb.append(this.tiempo.toString()); else sb.append("-----");
	
		return sb.toString();
	}
		
	public String toString(boolean csv){
		if(csv){
			return this.toString();
		}
		StringBuffer sb = new StringBuffer("");
		if(this.alternativa!=null){
			sb.append("hay-alternativa="+this.alternativa);
			
		}
		if(this.bar!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("tiene-bar="+this.bar);
		}
		
		if(this.viernesSabado!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("es-vier-sab="+this.viernesSabado);
		}
		
		if(this.hambriento!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("estoy-hambriento="+this.hambriento);
		}
		
		if(this.clientes!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("cant-clientes="+this.clientes.toString());
		}
		
		if(this.precio!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("precio="+this.precio.toString()); 
		}
		
		if(this.lloviendo!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("esta-lloviendo="+this.lloviendo); 
		}
		
		if(this.reserva!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("tenia-reserva="+this.reserva); 
		}
		
		if(this.tipo!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("tipo-restaurante="+this.tipo.toString()); 
		}
		
		if(this.tiempo!=null){
			if(sb.length()!=0) sb.append(" and ");
			sb.append("tiempo-espera-aprox="+this.tiempo.toString()); 
		}
	
		return sb.toString();
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((alternativa == null) ? 0 : alternativa.hashCode());
		result = prime * result + ((bar == null) ? 0 : bar.hashCode());
		result = prime * result
				+ ((clientes == null) ? 0 : clientes.hashCode());
		result = prime * result
				+ ((hambriento == null) ? 0 : hambriento.hashCode());
		result = prime * result
				+ ((lloviendo == null) ? 0 : lloviendo.hashCode());
		result = prime * result + ((precio == null) ? 0 : precio.hashCode());
		result = prime * result + ((reserva == null) ? 0 : reserva.hashCode());
		result = prime * result + ((tiempo == null) ? 0 : tiempo.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result
				+ ((viernesSabado == null) ? 0 : viernesSabado.hashCode());
		return result;
	}

	*/
	
	/*Este es el metodo original, generado con Eclipse ed equals, lo dejé comendato para que
	 * se entienda la diferencia con el metodo que implementé más abajo.*/
	 	
	/* @Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CondicionesRestaurantes other = (CondicionesRestaurantes) obj;
		
		if (alternativa == null) {
			if (other.alternativa != null)
				return false;
		} else if (!alternativa.equals(other.alternativa))
			return false;
		if (bar == null) {
			if (other.bar != null)
				return false;
		} else if (!bar.equals(other.bar))
			return false;
		if (clientes == null) {
			if (other.clientes != null)
				return false;
		} else if (!clientes.equals(other.clientes))
			return false;
		if (hambriento == null) {
			if (other.hambriento != null)
				return false;
		} else if (!hambriento.equals(other.hambriento))
			return false;
		if (lloviendo == null) {
			if (other.lloviendo != null)
				return false;
		} else if (!lloviendo.equals(other.lloviendo))
			return false;
		if (precio == null) {
			if (other.precio != null)
				return false;
		} else if (!precio.equals(other.precio))
			return false;
		if (reserva == null) {
			if (other.reserva != null)
				return false;
		} else if (!reserva.equals(other.reserva))
			return false;
		if (tiempo == null) {
			if (other.tiempo != null)
				return false;
		} else if (!tiempo.equals(other.tiempo))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (viernesSabado == null) {
			if (other.viernesSabado != null)
				return false;
		} else if (!viernesSabado.equals(other.viernesSabado))
			return false;
		return true;
	}*/

/*	
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		CondicionesRestaurantes cloned = new CondicionesRestaurantes(true);
		
		if(this.alternativa!=null)  cloned.alternativa= new Boolean(this.alternativa);
		if(this.bar!=null)  cloned.bar=new Boolean(this.bar);
		if(this.viernesSabado!=null)  cloned.viernesSabado=new Boolean(this.viernesSabado);
		if(this.hambriento!=null)  cloned.hambriento=new Boolean(this.hambriento);
		if(this.clientes!=null)  cloned.clientes=this.clientes;
		if(this.precio!=null)  cloned.precio=this.precio;
		if(this.lloviendo!=null)  cloned.lloviendo=new Boolean(this.lloviendo);
		if(this.reserva!=null)  cloned.reserva=new Boolean(this.reserva);
		if(this.tipo!=null)  cloned.tipo=this.tipo;
		if(this.tiempo!=null)  cloned.tiempo=this.tiempo;
		
		return cloned;
	}
*/	
	
	/**
	 * En este caso, suponemos que un objeto A de la clase: CondicionRestaurantes, es igual (equal) a otro 
	 * objeto B, de la clase CondicionRestaurantes sí A es igual o más especifico que B.
	 * ¿Qué significa que sea más especifico? que A.x == B.x o, B.x==null. 
	 * Recordar que cada atributo de esta clase es uan condicion, si este es NULL, es entonces una condición 
	 * que NO se contemplará. 
	 * */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MABObject other = (MABObject) obj;
		
		if(other.tipo!=null && this.tipo != null){			
			if (!this.tipo.equals(other.tipo)) return false;
		}
		if(other.arribaDe!=null && this.arribaDe != null){			
			if (!this.arribaDe.equals(other.arribaDe)) return false;
		}
		if(other.abajoDe!=null && this.abajoDe != null){			
			if (!this.abajoDe.equals(other.abajoDe)) return false;
		}
		if(other.derechaDe!=null && this.derechaDe != null){			
			if (!this.derechaDe.equals(other.derechaDe)) return false;
		}
		if(other.izquierdaDe!=null && this.izquierdaDe != null){			
			if (!this.izquierdaDe.equals(other.izquierdaDe)) return false;
		}
		if(other.alcanzable!=null && this.alcanzable != null){			
			if (!this.alcanzable.equals(other.alcanzable)) return false;
		}

		return true;
	}

/*
	public CondicionesRestaurantes exclusion(CondicionesRestaurantes cr) throws CloneNotSupportedException{
		CondicionesRestaurantes cloned = (CondicionesRestaurantes) this.clone();
		
		if(cr.alternativa!=null && cloned.alternativa != null){			
			if (!cloned.alternativa.equals(cr.alternativa)){
				cloned.alternativa=null;
			}
		}
		if(cr.bar!=null && cloned.bar != null){		
			if (!cloned.bar.equals(cr.bar)){
				cloned.bar = null;
			}
		}
		if(cr.clientes!=null && cloned.clientes != null){			
			if (!cloned.clientes.equals(cr.clientes)){
				cloned.clientes=null;
			}
		}
		if(cr.hambriento!=null && cloned.hambriento != null){			
			if (!cloned.hambriento.equals(cr.hambriento)){
				cloned.hambriento=null;
			}
		}
		if(cr.lloviendo!=null && cloned.lloviendo != null){		
			if (!cloned.lloviendo.equals(cr.lloviendo)){
				cloned.lloviendo=null;
			}
		}
		if(cr.precio!=null && cloned.precio != null){		
			if (!cloned.precio.equals(cr.precio)){
				cloned.precio=null;
			}
		}
		if(cr.reserva!=null && cloned.reserva != null){	
			if (!cloned.reserva.equals(cr.reserva)){
				cloned.reserva=null;
			}
		}
		if(cr.tiempo!=null && cloned.tiempo != null){		
			if (!cloned.tiempo.equals(cr.tiempo)){
				cloned.tiempo=null;
			}
		}
		if(cr.tipo!=null && cloned.tipo != null){			
			if (!cloned.tipo.equals(cr.tipo)){
				cloned.tipo=null;
			}
		}
		if(cr.viernesSabado!=null && cloned.viernesSabado != null){			
			if (!cloned.viernesSabado.equals(cr.viernesSabado)){
				cloned.viernesSabado=null;
			}
		}		
		
		return cloned;
	}	
*/
	
}
