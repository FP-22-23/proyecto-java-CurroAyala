package fp.shootings;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
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
	
	public FatalShootings(Collection<FatalShooting> fatalShootings) {
		this.fatalShootings = new LinkedList<FatalShooting>(fatalShootings);
	}
	
//	Tercer constructor (tercera entrega)
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
	
	
//	MÉTODOS IMPLEMENTADOS CON STREAM
	
//	BLOQUE 1
	
//	Función tipo 1: COMPROBAR SI EXISTE un caso en el que haya fallecido una persona con un 
//					nombre dado.
	public List<String> comprobarCasoPorNombre2(String nombre) {
		return fatalShootings.stream().filter(x -> x.getNombre().equals(nombre)).
				map(FatalShooting::formatoCorto).collect(Collectors.toList());
	}
	
//	Función tipo 2: CALCULAR LA MEDIA de las víctimas.
	public Integer calcularMediaEdadVictimas2() {
		Double res = fatalShootings.stream().collect(Collectors.averagingInt(FatalShooting::getEdad));
		return res.intValue();
	}
	
//	Función tipo 3: SELECCIONAR los casos en los que las víctimas tenían señas de enfermedad mental.
	public ArrayList<String> seleccionarCasosEnfermedadMental2() {
		return fatalShootings.stream().filter(x -> x.getSeñalesEnfermedadMental()).map(FatalShooting::formatoCorto).
				collect(Collectors.toCollection(ArrayList::new));
	}
	
//	Función tipo 4: Hallar la víctima mujer MÁS JOVEN (mínimo).
	public String hallarMujerMasJoven() {
		return fatalShootings.stream().filter(x -> x.getGenero().equals("Mujer")).
				max(Comparator.comparing(FatalShooting::getEdad)).get().formatoCorto();
	}
	
//	Función tipo 5: Selección, filtrado y ordenación.
	public ArrayList<String> victimasDeRazaNegraPorEdad() {
		return fatalShootings.stream().filter(x -> x.getRaza().equals("Negra")).
				sorted(Comparator.comparing(FatalShooting::getEdad)).map(FatalShooting::formatoCorto).
				collect(Collectors.toCollection(ArrayList::new));
	}
	
	
//	BLOQUE 2
	
//	Función tipo 6: CONTAR en un MAP las víctimas que han habido en cada año 
//	(misma función que la tipo 5 de la segunda entrega).
	public Map<Integer, Long> contarPorAño2() {
		return fatalShootings.stream().collect(Collectors.groupingBy(FatalShooting::getAño,Collectors.counting()));
	}
	
//	Función tipo 7: Hallar la media de número de agentes en cada caso con MAPPING.
	public int mediaNumAgentes() {
		return fatalShootings.stream().
			map(FatalShooting::getPatrullaPolicial).
			collect(Collectors.mapping(PatrullaPolicial::numAgentes, Collectors.averagingInt(Integer::intValue))).
			intValue();
	}
	
//	Función tipo 8: Crear un MAP cuyas claves son las distinas razas y los valores son la persona más alta de cada raza.
	public Map<String, String> personasMasAltasPorRaza() {
		Comparator<FatalShooting> c = Comparator.comparingDouble(FatalShooting::getEstatura);
		
		return fatalShootings.stream().collect(Collectors.groupingBy(FatalShooting::getRaza,
				Collectors.collectingAndThen(Collectors.maxBy(c), opt -> opt.map(FatalShooting::formatoCorto).
						orElse(""))));
	}
	
	
//	Función tipo 9: Crear un MAP cuyas claves son las distintas causas de muerte y los valores son los n casos a los
//	que acudieron más agentes policiales.
	public SortedMap<String, List<FatalShooting>> nCasosMasAgentesPorCausaMuerte(Integer n) {
		Comparator<FatalShooting> c = Comparator.comparing(FatalShooting::getNumAgentes);
		
		return fatalShootings.stream().collect(Collectors.groupingBy(FatalShooting::getCausaMuerte,TreeMap::new,
				Collectors.collectingAndThen(Collectors.toList(), x -> x.stream().sorted(c.reversed()).limit(n).
						collect(Collectors.toList()))));
	}
	
	
//	Función tipo 10: hallar la raza con la persona más alta.
	public String razaConPersonaMasAlta() {
		Map<String, String> aux = personasMasAltasPorRaza();
		
		return aux.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
	}
	
	
}	
