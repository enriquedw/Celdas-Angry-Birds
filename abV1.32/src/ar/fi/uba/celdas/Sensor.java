package ar.fi.uba.celdas;

import java.util.List;

import ab.vision.ABObject;
import ab.vision.Vision;

public class Sensor {
	/*
	 * Devuelve una perepcion a partir de un vision
	 */
	public Percepcion sensarEntorno(Vision vision) {
		Percepcion percepcion = new Percepcion();
		List<ABObject> pigs = vision.findPigsMBR();
		List<ABObject> blocks = vision.findBlocksMBR();
		List<ABObject> tnt = vision.findTNTs();
		
		
		for(ABObject block : blocks) {
			percepcion.agregarObj( new MABObject(block, block.getType().toString(), estaArribaDe(block, pigs), false, false, false, true));
		}
		
		return percepcion;
	}

	/*
	 * Metodos auxiliares para chequear ubicacion relativa de los objetos 
	 */
	private Boolean estaArribaDe(ABObject obj, List<ABObject> pigs) {
		for(ABObject pig : pigs) {
			System.out.println("Object MinY:" + obj.getMinY());
			System.out.println("Pig MaxY:" + pig.getMaxY());
			if ((obj.getMinY() - pig.getMaxY()) > 0)
				return true;
		}
		return false;
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
