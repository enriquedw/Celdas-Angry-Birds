package ar.fi.uba.celdas;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 * Mantiene la base de conocimiento de teorias y provee operaciones sobre estas
 */

public class ManejadorTeorias {

	public static final String FILE_NAME = "BaseDeConocimieto.csv";
	private FileInputStream fstream = null;
	private BufferedReader br = null;
	private String percepcion;

	ManejadorTeorias() {
	}
	
	public void ponerarTeoriaUsada(Percepcion perepcionInicial, Percepcion percepcionFinal, Teoria teoriaUsada) {
		return;
	}
	
	public void CargarTeorias() {
		try {
			fstream = new FileInputStream(FILE_NAME);
		} catch (IOException e) {
			System.out.println("No se pudo abrir el archivo: "+FILE_NAME+". Error: "+e.getMessage());
		}
		try {
			br = new BufferedReader(new InputStreamReader(fstream));
			br.readLine(); //ignoramos la primer linea, tiene los encabezados
		} catch (IOException e) {
			System.out.println("Error al leer encabezado: "+FILE_NAME+". Error: "+e.getMessage());
		}

/*		br.readLine();
		if(br == null){
			return null;
		}
	*/	
		try {
			br.close();
		} catch (IOException e) {
			System.out.println("No se pudo cerrar el archivo: "+FILE_NAME+". Error: "+e.getMessage());
		}
		return;
		
	}
	
	public static List<Teoria> returnIguales(Teoria source, Set<Teoria> set){
		   List<Teoria> teoriasIguales = new ArrayList<Teoria>();
		   for (Teoria obj : set) {
			   if (source.equals(obj) && obj.isExitosa()) teoriasIguales.add(obj);
		   }
		   
		  return teoriasIguales;
		}
		
		
		public static List<Teoria> returnSimilares(Teoria source, Set<Teoria> set){
		   List<Teoria> teoriasSimilares = new ArrayList<Teoria>();
		   for (Teoria obj : set) {
			   if (source.similar(obj)) teoriasSimilares.add(obj);
		   } 
		   
		  return teoriasSimilares;
		}
		
		public static List<Teoria> returnErroneas(Teoria source, Set<Teoria> set){
			   List<Teoria> teoriasErroneas = new ArrayList<Teoria>();
			   for (Teoria obj : set) {
				   if (source.incompatible(obj)){
					   teoriasErroneas.add(obj);
				   }
			   }		   
			  return teoriasErroneas;
		}
		
		public static List<Teoria> returnExitosas(Set<Teoria> set){
			   List<Teoria> teoriasExitosas = new ArrayList<Teoria>();
			   for (Teoria obj : set) {
				   if (obj.isExitosa()){
					   teoriasExitosas.add(obj);
				   }
			   }		   
			  return teoriasExitosas;
		}
		
		public Teoria exclusion(Teoria teoria) throws CloneNotSupportedException{
			Teoria t = new Teoria();
//			t.condicionesSupuestas = this.condicionesSupuestas.exclusion(teoria.condicionesSupuestas); 
//			t.efectosPredichos = new Percepcion(this.efectosPredichos);		
			return t;
		}

	

	public static <T extends Enum<T>> T valueOfIgnoreCase(Class<T> enumeration, String name) {
	    for(T enumValue : enumeration.getEnumConstants()) {
	        if (enumValue.toString().equalsIgnoreCase(name)) {
	            return enumValue;
	        }
	    }
	    throw new IllegalArgumentException("There is no value with name '" + name + " in Enum " + enumeration.getClass().getName());        
	}

}
