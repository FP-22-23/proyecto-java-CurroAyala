package fp.shootings.test;

import fp.shootings.FatalShooting;
import fp.shootings.PatrullaPolicial;
import fp.shootings.TipoGenero;
import fp.shootings.TipoPolicia;
import fp.shootings.TipoRaza;

import java.time.LocalDate;

public class TestFatalShooting {

	public static void main(String[] args) {
		
		FatalShooting fs1 = new FatalShooting("Tim Elliot",LocalDate.of(2015,01,02),"shot",53,
							TipoGenero.M,TipoRaza.A,1.62,"Shelton","WA",true,
							new PatrullaPolicial(TipoPolicia.ESTATAL,4));
		
		FatalShooting fs2 = new FatalShooting("Tim Elliot",LocalDate.of(2015,01,02),"shot",53,
							TipoGenero.M,TipoRaza.A,1.62,"Shelton","WA",true,
							new PatrullaPolicial(TipoPolicia.ESTATAL,4));
		
		FatalShooting fs3 = new FatalShooting("Lewis Lee Lembke",LocalDate.of(2015,01,02),"shot",47,
							TipoGenero.M,TipoRaza.W,1.77,"Aloha","OR",false,
							new PatrullaPolicial(TipoPolicia.FEDERAL,5));
		
		FatalShooting fs4 = new FatalShooting("Lewis Lee Lembke",47,LocalDate.of(2015,01,02),
							"Aloha");
		
		FatalShooting fs5 = new FatalShooting("John Paul Quintero",LocalDate.of(2015,01,03),
							"shot and Tasered",23,TipoGenero.M,TipoRaza.H,1.83,"Wichita","KS",false,
							new PatrullaPolicial(TipoPolicia.LOCAL,2));

		
		System.out.println("-----------------------------------------------------");
//		REPRESENTACIÓN COMO CADENA
		System.out.println(fs1.toString());
//		System.out.println(fs2);
		System.out.println(fs3.toString());
		System.out.println(fs4.toString());
		System.out.println(fs5.toString());
		
		System.out.println("-----------------------------------------------------");
//		FORMATO CORTO
		System.out.println(fs1.formatoCorto());
		System.out.println(fs4.formatoCorto());

		
		System.out.println("-----------------------------------------------------");
//		TESTs MÉTODOS GETTER
		System.out.println(fs1.getNombre() + ", " + fs1.getFecha() + ", " + fs1.getCausaMuerte() +
						", " + fs1.getEdad() + ", " + fs1.getGenero() + ", " + fs1.getRaza() +
						", " + fs1.getEstatura() + ", " + fs1.getCiudad() + ", " + fs1.getEstado() +
						", " + fs1.getSeñalesEnfermedadMental());
		
		
		System.out.println("-----------------------------------------------------");
//		TEST DE OTRO MÉTODOS
		fs5.añadirImplicado("Louis Hamill");
		fs5.añadirImplicado("Anne Brown");
		fs5.añadirImplicado("John Miller",0);
		System.out.println(fs5.getImplicados());
		fs5.eliminarImplicado("Anne Brown");
		System.out.println(fs5.getImplicados());
		
		
		System.out.println("-----------------------------------------------------");
//		TEST IGUALDAD
		System.out.println(fs1.equals(fs2));
		System.out.println(fs1.equals(fs3));
		System.out.println(fs3.equals(fs4));
		

		System.out.println("-----------------------------------------------------");
//		TEST DE ORDENACIÓN
		System.out.println(fs1.compareTo(fs3));
		System.out.println(fs1.compareTo(fs5));
		
		
		System.out.println("-----------------------------------------------------");
//		TEST DIFERENCIA NÚMERO AGENTES
		System.out.println(fs1.getPatrullaPolicial().getDifAgentes(fs3.getPatrullaPolicial()));
	}

}
