import java.util.*;

public class Organizador {
	
	private ArrayList<Actividad> actividades = new ArrayList<Actividad>();
	
	// horaActual lleva guardada la hora en que puede comenzar la actividad siguiente
	private int horaActual = 0; 
	
	public void addActividad (Actividad a) {
		actividades.add(a);
	}
	
	public void Organizar () {
		ArrayList<Actividad> resultado = new ArrayList<Actividad>();
		
		while(!actividades.isEmpty()) {
			resultado.add(getActividad());
		}
		
		imprimirActividades(resultado);
	}
	
	
	/**
	 * Retorna una Actividad que inicie de acuerdo a la hora actual
	 * Si la última Actividad finaliza a las 5, la siguiente debéra iniciar a las 5 o mas.
	 * Siempre intenta encontrar la Actividad con hora de inicio mas cercana a la horaActual.
	 * @return
	 */
	private Actividad getActividad() {
		int index = 0;
		int horaTemp = 13;
		
		for (int i = 0; i < actividades.size(); i++) {
			if(actividades.get(i).getInicia() <= horaTemp && actividades.get(i).getInicia() >= horaActual ) {
				horaTemp = actividades.get(i).getInicia();
				index = i;
			}
		}
		
		// Si horaTemp es 13, significa que no encontró ninguna Acitividad
		if(horaTemp >= horaActual && horaTemp != 13) {
			horaActual = actividades.get(index).getFinaliza();			
			return actividades.remove(index);
		}
		// Sino cumple con las condiciones la Actividad debe ser borrada y retorna null
		else {
			actividades.remove(index);
			return null;
		}
	}
	
	
	private void imprimirActividades(ArrayList<Actividad> resultado){
		for (int i = 0; i < resultado.size(); i++) {
			if(resultado.get(i) != null) {
				System.out.print(resultado.get(i).getInicia());
				System.out.print(resultado.get(i).getFinaliza());
				System.out.println();
			}
	
		}
	}

	public static void main(String[] args) {
		Actividad a1 = new Actividad(6,7);
		Actividad a2 = new Actividad(3,5);
		Actividad a3 = new Actividad(4,8);
		Actividad a4 = new Actividad(1,2);
		Actividad a5 = new Actividad(8,9);
		Actividad a6 = new Actividad(5,6);
		
		Organizador org = new Organizador();
		
		org.addActividad(a1);
		org.addActividad(a2);
		org.addActividad(a3);
		org.addActividad(a4);
		org.addActividad(a5);
		org.addActividad(a6);
		
		org.Organizar();
	}

}
