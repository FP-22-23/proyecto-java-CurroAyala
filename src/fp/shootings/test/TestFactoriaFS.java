package fp.shootings.test;


import fp.shootings.FactoriaFatalShooting;
import fp.shootings.FatalShootings;


public class TestFactoriaFS {
	
	private static void testLeerFatalShootings(String rutaFichero) {
		System.out.println("\n-----------------------------------------------------");
		System.out.println("Test de leerFatalShootings.\n");
		FatalShootings fss = FactoriaFatalShooting.leerFatalShootings(rutaFichero);
		System.out.println("Número de casos: " + fss.getNumerosElem());
	}
		
	public static void main(String[] args) {
		
		testLeerFatalShootings("data/fatal-police-shootings-data-edited.csv");
		
	}

}
