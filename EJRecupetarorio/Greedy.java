import java.util.*;

public class Greedy {
	ArrayList<Integer> paquetes = new ArrayList<Integer>();
	ArrayList<Integer> empleados = new ArrayList<Integer>();
	
	public Greedy () {
		
		//Cargamos paquetes. Cada pos del Array es un paquete con un tiempo
		paquetes.add(5);
		paquetes.add(9);
		paquetes.add(2);
		paquetes.add(3);
		paquetes.add(7);
		paquetes.add(5);
		
		// Suponemos que tenemos 3 empleados
		// Ningun empleado tiene paquete asignado
		for (int i = 0; i < 3; i++) {
			empleados.add(0);
		}
		
		getSolGreedy();
		
		System.out.println(empleados);
	}
	
	public void getSolGreedy () {
		
		// Mientras que tenga paquetes para asignar
		while(!paquetes.isEmpty()) {
			int i = getPaqueteMayorTiempo();
			int j = getEmpleadoMenosOcupado();
			
			empleados.set(j, empleados.get(j)+ paquetes.remove(i));
		}
	}
	
	/**
	 * Recorre paquetes y obtiene la pos del paquete con mayor tiempo
	 * @return
	 */
	private int getPaqueteMayorTiempo () {
		int index = 0;
		
		for (int i = 0; i < paquetes.size(); i++) {
			if(paquetes.get(index) <= paquetes.get(i)) {
				index = i;
			}
		}
	return index;
	}
	
	/**
	 * Recorre empleados y otiene la pos del que menos tiempo | Menos Ocupado
	 * @return
	 */
	private int getEmpleadoMenosOcupado () {
		int index = 0;
		
		for (int i = 0; i < empleados.size(); i++) {
			if(empleados.get(index) >= empleados.get(i)) {
				index = i;
			}
		}
	return index;
	}
	
	public static void main(String[] args) {
		Greedy g = new Greedy();
	}
}
