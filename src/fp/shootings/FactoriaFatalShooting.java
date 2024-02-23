package fp.shootings;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import fp.utiles.checkers.Checkers;

public class FactoriaFatalShooting {
	
//	Información línea del archivo .csv
//	name,date,manner_of_death,age,gender,race,height,city,state,signs_of_mental_illness,police,
//	number_of_officers
	
	public static FatalShooting parsearFatalShooting(String lineaCSV) {
		String[] campos = lineaCSV.split(",");
		Checkers.check("Error en el número de elementos.", campos.length == 12);
		String nombre = campos[0].trim();
		LocalDate fecha = LocalDate.parse(campos[1].trim());
		String causaMuerte = campos[2].trim();
		Integer edad = Integer.valueOf(campos[3].trim());
		TipoGenero genero = TipoGenero.valueOf(campos[4].trim().toUpperCase());
		TipoRaza raza = TipoRaza.valueOf(campos[5].trim().toUpperCase());
		Double estatura = Double.valueOf(campos[6].trim());
		String ciudad = campos[7].trim();
		String estado = campos[8].trim();
		Boolean señalesEnfermedadMental = Boolean.valueOf(campos[9].trim());
		TipoPolicia tipoPolicia = TipoPolicia.valueOf(campos[10].trim().toUpperCase());
		Integer numAgentes = Integer.valueOf(campos[11].trim());	
		
		return new FatalShooting(nombre,fecha,causaMuerte,edad,genero,raza,estatura,ciudad,estado,
					señalesEnfermedadMental,new PatrullaPolicial(tipoPolicia,numAgentes));
	}
	
	public static FatalShootings leerFatalShootings(String rutaFichero) {
		FatalShootings res = null;
		try {
			List<FatalShooting> fs =
					Files.lines(Paths.get(rutaFichero)).
					skip(1).
					map(FactoriaFatalShooting::parsearFatalShooting).
					collect(Collectors.toList());
			res = new FatalShootings(fs);
		} 
		catch(IOException e) {
			System.out.println("No se ha encontrado el fichero." + rutaFichero);
		}
		
		return res;
	}
	
	
//	Método tercera entrega
	public static FatalShootings leerFatalShootings2(String rutaFichero) {
		FatalShootings res = null;
		try {
			Stream<FatalShooting> fs =
					Files.lines(Paths.get(rutaFichero)).
					skip(1).
					map(FactoriaFatalShooting::parsearFatalShooting);
			res = new FatalShootings(fs);
		} 
		catch(IOException e) {
			System.out.println("No se ha encontrado el fichero." + rutaFichero);
		}
		
		return res;
	}

}
