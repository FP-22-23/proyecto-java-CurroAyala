package fp.shootings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.utiles.checkers.Checkers;

public class FatalShootings {
	
//	ATRIBUTO CONJUNTO
	private List<FatalShooting> fatalShootings;
	
	
//	CONSTRUCTORES
	public FatalShootings() {
		fatalShootings = new LinkedList<FatalShooting>();
	}
	
	public FatalShootings(Stream<FatalShooting> fatalShootings) {
		this.fatalShootings = fatalShootings.collect(Collectors.toList());
	}
	
	
//	MÉTODOS
	public void añadirFatalShooting(FatalShooting fs) {	//Añadir un objeto
		fatalShootings.add(fs);
	}
	
	public void añadirColeccionFS(LinkedList<FatalShooting> c) {	//Añadir una colección
		fatalShootings.addAll(c);
	}
	
	public void eliminarElemento(Object o) {	//Eliminar un objeto, si estuviese
		fatalShootings.remove(o);
	}
	
	public void eliminarElemento(int index) {	//Eliminar el elemento que se encuentra en un índice
		Checkers.check("Error en el índice.", index >= 0 && index <= fatalShootings.size());
		fatalShootings.remove(index);
	}
	
	public void eliminarColeccion(LinkedList<FatalShooting> c) {	//Eliminar un conjunto
		fatalShootings.removeAll(c);
	}
	
	public Integer getNumerosElem() {	//Obtener el número de elementos
		return fatalShootings.size();
	}
	
	public FatalShooting getFS(int index) {
		return fatalShootings.get(index);
	}

	
//	TO STRING
	public String toString() {
		return "FatalShootings [fatalShootings=" + fatalShootings + "]";
	}

	
//	CRITERIO DE IGUALDAD
	public int hashCode() {
		return Objects.hash(fatalShootings);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FatalShootings other = (FatalShootings) obj;
		return Objects.equals(fatalShootings, other.fatalShootings);
	}


//	MÉTODOS IMPLEMENTADOS CON BUCLES
	
//	Método 1: COMPROBAR SI EXISTE un caso en el que haya fallecido una persona con un nombre dado.
	public List<String> comprobarCasoPorNombre(String nombre) {
		List<String> res = new LinkedList<String>();
		for (FatalShooting fs:fatalShootings) {
			if (fs.getNombre().equals(nombre)) {
				res.add(fs.formatoCorto());
			}
		}
		return res;
	}
	
//	Método 2: CALCULAR LA MEDIA de las víctimas.
	public Integer calcularMediaEdadVictimas() {
		Integer res = 0;
		for (FatalShooting fs:fatalShootings) {
			res += fs.getEdad();
		}
		return res / fatalShootings.size();
	}
	
//	Método 3: SELECCIONAR los casos en los que las víctimas tenían señas de enfermedad mental.
	public ArrayList<String> seleccionarCasosEnfermedadMental() {
		ArrayList<String> res = new ArrayList<String>();
		for (FatalShooting fs:fatalShootings) {
			if (fs.getSeñalesEnfermedadMental()) {
				res.add(fs.formatoCorto());
			}
		}
		return res;
	}
	
//	Método 4: AGRUPAR en un MAP los nombres de las víctimas por estado.
	public Map<String, List<String>> agruparPorEstado() {
		Map<String, List<String>> res = new HashMap<String, List<String>>();
		for (FatalShooting fs:fatalShootings) {
			if (!res.containsKey(fs.getEstado())) {
				res.put(fs.getEstado(), new LinkedList<String>());
			}
			res.get(fs.getEstado()).add(fs.getNombre());
		}
		return res;
	}
	
//	Método 5: CONTAR en un MAP las víctimas que han habido en cada año.
	public Map<Integer, Integer> contarPorAño() {
		Map<Integer,Integer> res = new HashMap<Integer,Integer>();
		for (FatalShooting fs:fatalShootings) {
			if (!res.containsKey(fs.getAño())) {
				res.put(fs.getAño(), 0);
			}
			Integer n = res.get(fs.getAño());
			res.put(fs.getAño(), n+1);
		}
		return res;
	}
	
	

}
