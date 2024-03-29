package fp.shootings.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import fp.shootings.FactoriaFatalShooting;
import fp.shootings.FatalShooting;
import fp.shootings.FatalShootings;


public class TestFatalShootings {
	
	public static void testComprobarCasoPorNombre(FatalShootings fss,String nombre) {
		List<String> casos = fss.comprobarCasoPorNombre(nombre);
		if (casos.size() == 0) {
			System.out.println("No se han encontrado coincidencias.");
		}
		else {
			System.out.println("Coincidencia/s:");
			for(String e:casos) {
				System.out.println(e);
			}
		}
	}
	
	public static void testComprobarCasoPorNombre2(FatalShootings fss,String nombre) {
		List<String> casos = fss.comprobarCasoPorNombre2(nombre);
		if (casos.size() == 0) {
			System.out.println("No se han encontrado coincidencias.");
		}
		else {
			System.out.println("Coincidencia/s:");
			for(String e:casos) {
				System.out.println(e);
			}
		}
	}
	
	
	public static void testCalcularMediaEdadVictimas(FatalShootings fss) {
		System.out.println("La media de edad de las víctimas es de " + fss.calcularMediaEdadVictimas() +
							" años.");
	}
	
	public static void testCalcularMediaEdadVictimas2(FatalShootings fss) {
		System.out.println("La media de edad de las víctimas es de " + fss.calcularMediaEdadVictimas2() +
							" años.");
	}
	
	
	public static void testSeleccionarCasosEnfermedadMental(FatalShootings fss) {
		ArrayList<String> casos = fss.seleccionarCasosEnfermedadMental();
		int n = casos.size();
		System.out.println("Hay " + n + " víctimas que tenían señas de enfermedad mental.");
		if (n == 1) {
			System.out.println(casos.get(0));
		}
		else if (n > 1) {
			System.out.println("El primer caso es: " + casos.get(0));
			System.out.println("El último caso es: " + casos.get(n-1));
		}
	}
	
	public static void testSeleccionarCasosEnfermedadMental2(FatalShootings fss) {
		ArrayList<String> casos = fss.seleccionarCasosEnfermedadMental2();
		int n = casos.size();
		System.out.println("Hay " + n + " víctimas que tenían señas de enfermedad mental.");
		if (n == 1) {
			System.out.println(casos.get(0));
		}
		else if (n > 1) {
			System.out.println("El primer caso es: " + casos.get(0));
			System.out.println("El último caso es: " + casos.get(n-1));
		}
	}
	
	
	public static void testAgruparPorEstado(FatalShootings fss) {
		Map<String, List<String>> agrupacion = fss.agruparPorEstado();
		for (Map.Entry<String, List<String>> estado:agrupacion.entrySet()) {
			String clave = estado.getKey();
			List<String> valor = estado.getValue();
			System.out.println("\nEstado " + clave + ": ");
			System.out.println(valor);
		}
	}
	
	
	public static void testContarPorAño(FatalShootings fss) {
		Map<Integer, Integer> conteo = fss.contarPorAño();
		for (Map.Entry<Integer,Integer> año:conteo.entrySet()) {
			Integer clave = año.getKey();
			Integer valor = año.getValue();
			System.out.println("\nAño " + clave + ": " + valor);
		}
	}
	
	public static void testContarPorAño2(FatalShootings fss) {
		Map<Integer, Long> conteo = fss.contarPorAño2();
		for (Map.Entry<Integer,Long> año:conteo.entrySet()) {
			Integer clave = año.getKey();
			Integer valor = año.getValue().intValue();
			System.out.println("\nAño " + clave + ": " + valor);
		}
	}
	
	
	public static void testHallarMujerMasJoven(FatalShootings fss) {
		System.out.println("La víctima mujer más joven es: " + fss.hallarMujerMasJoven());
	}
	
	
	public static void testVictimasDeRazaNegraPorEdad(FatalShootings fss) {
		ArrayList<String> res = fss.victimasDeRazaNegraPorEdad();
		System.out.println("Hay " + res.size() + " víctimas de raza negra (lista ordenada por edad).");
		System.out.println("La más joven es: " + res.get(0));
		System.out.println("La mayor es: " + res.get(res.size()-1));
	}
	
	
	public static void testMediaNumAgentes(FatalShootings fss) {
		System.out.println("La media de los agentes que acudieron a cada caso es de " +
							fss.mediaNumAgentes() + ".");
	}
	
	
	public static void testPersonasMasAltasPorRaza(FatalShootings fss) {
		Map<String, String> res = fss.personasMasAltasPorRaza();
		for (Map.Entry<String,String> raza:res.entrySet()) {
			String clave = raza.getKey();
			String valor = raza.getValue();
			System.out.println("\nRaza " + clave + ": " + valor);
		}
	}
	
	public static void testNCasosMasAgentesPorCausaMuerte(FatalShootings fss) {
		Integer n = 5;
		Map<String, List<FatalShooting>> res = fss.nCasosMasAgentesPorCausaMuerte(n);
		for (Entry<String, List<FatalShooting>> causaMuerte:res.entrySet()) {
			String clave = causaMuerte.getKey();
			List<String> valor = new ArrayList<String>();
			for(FatalShooting fs:causaMuerte.getValue()) {
				valor.add(fs.formatoCorto());
			}
			System.out.println("\nCausa de la muerte " + clave + ": " + valor);
		}
	}
	
	public static void testRazaConPersonaMasAlta(FatalShootings fss) {
		System.out.println("La raza con la persona más alta es: " + fss.razaConPersonaMasAlta());
	}
	
	
//	-------------------------------------------------------------------------------------------------------------------
	
	
	public static void main(String[] args) {
		
		String rutaFichero = "data/fatal-police-shootings-data-edited.csv";
		FatalShootings fss1 = FactoriaFatalShooting.leerFatalShootings(rutaFichero);
		FatalShootings fss2 = FactoriaFatalShooting.leerFatalShootings(rutaFichero);
		
		
		FatalShooting fs1 = new FatalShooting("Bob Brown",65,LocalDate.of(2016,8,23),"Los Angeles");
		FatalShooting fs2 = new FatalShooting("Mary Jane",31,LocalDate.of(2018,7,19),"New York");
		
		LinkedList<FatalShooting> fss3 = new LinkedList<>();
		fss3.add(fs1);
		fss3.add(fs2);
		
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test getNumerosElem");
		System.out.println("\nfss1 tiene " + fss1.getNumerosElem() + " elementos");
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test añadirFatalShooting:");
		System.out.println("\nÚltimo caso de fss1 antes de añadir otro al final:\n" + 
							fss1.getFS(fss1.getNumerosElem()-1));
		fss1.añadirFatalShooting(fs1);
		System.out.println("\nÚltimo caso de fss1 después de añadir otro al final:\n" +
							fss1.getFS(fss1.getNumerosElem()-1));
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test eliminarElemento");
		fss1.eliminarElemento(fs1);
		System.out.println("\nÚltimo caso de fss1 después de eliminar el añadido anteriormente:\n" +
							fss1.getFS(fss1.getNumerosElem()-1));
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test añadirColeccion");
		System.out.println("\nÚltimos dos casos de fss1 antes de añadir una colección al final:\n" +
							fss1.getFS(fss1.getNumerosElem()-1) + "\n" +
							fss1.getFS(fss1.getNumerosElem()-2));
		fss1.añadirColeccionFS(fss3);
		System.out.println("\nÚltimos dos casos de fss1 después de añadir una colección al final:\n" +
							fss1.getFS(fss1.getNumerosElem()-1) + "\n" +
							fss1.getFS(fss1.getNumerosElem()-2));
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test eliminarColeccion");
		fss1.eliminarColeccion(fss3);
		System.out.println("\nÚltimos dos casos de fss1 después de eliminar la colección al añadida " +
							"anteriormente:\n" +
							fss1.getFS(fss1.getNumerosElem()-1) + "\n" +
							fss1.getFS(fss1.getNumerosElem()-2));
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Tras aplicar y deshacer cada modificación, fss1 y fss2 deben ser iguales:");
		System.out.println(fss1.equals(fss2));
		
		
//		TEST DE LOS MÉTODOS IMPLEMENTADOS CON BUCLES
		System.out.println("\n-----------------------------------------------------");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("TEST DE LOS MÉTODOS IMPLEMENTADOS CON BUCLES");
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test comprobarCasoPorNombre\n");
		testComprobarCasoPorNombre(fss2,"Tim Elliot");
		testComprobarCasoPorNombre(fss2,"John Elly");
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test calcularMediaEdadVictimas\n");
		testCalcularMediaEdadVictimas(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test seleccionarCasosEnfermedadMental\n");
		testSeleccionarCasosEnfermedadMental(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test agruparPorEstado");
		testAgruparPorEstado(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test contarPorAño");
		testContarPorAño(fss2);
		
		
//		TEST DE LOS MÉTODOS IMPLEMENTADOS CON STREAM
		System.out.println("\n-----------------------------------------------------");
		System.out.println("-----------------------------------------------------\n");
		System.out.println("TEST DE LOS MÉTODOS IMPLEMENTADOS CON STREAM");
		
		
//		BLOQUE 1
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test comprobarCasoPorNombre2\n");
		testComprobarCasoPorNombre2(fss2,"Tim Elliot");
		testComprobarCasoPorNombre2(fss2,"John Elly");
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test calcularMediaEdadVictimas2\n");
		testCalcularMediaEdadVictimas2(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test seleccionarCasosEnfermedadMental2\n");
		testSeleccionarCasosEnfermedadMental2(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test hallarMujerMasJoven\n");
		testHallarMujerMasJoven(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test victimasDeRazaNegraPorEdad\n");
		testVictimasDeRazaNegraPorEdad(fss2);
		
		
//		BLOQUE 2
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test contarPorAño2");
		testContarPorAño2(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test mediaNumAgentes\n");
		testMediaNumAgentes(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test personasMasAltasPorRaza\n");
		testPersonasMasAltasPorRaza(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test nCasosMasAgentesPorCausaMuerte");
		testNCasosMasAgentesPorCausaMuerte(fss2);
		
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test razaConPersonaMasAlta\n");
		testRazaConPersonaMasAlta(fss2);
		
	}

}
