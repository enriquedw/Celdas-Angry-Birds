package ar.fi.uba.celdas;

import java.util.ArrayList;
import java.util.List;

/*
 * El numero de nivel y el conjunto de MABObjects del mismo
 */
public class Percepcion {
	
	private List <MABObject> mabobjetos;
	private int nivel;
	
	public Percepcion(){
		mabobjetos = new ArrayList <MABObject>();
	}
	
	public void print() {
		for(MABObject o : mabobjetos) {
			System.out.println("Tipo: " + o.tipo + " estaArribaDe: " + o.arribaDe);
		}
	}
	
	public void agregarObj(MABObject obj) {
		mabobjetos.add(obj);
	}
	
}
