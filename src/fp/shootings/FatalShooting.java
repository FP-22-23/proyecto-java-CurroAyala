package fp.shootings;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

import fp.utiles.checkers.Checkers;

public class FatalShooting implements Comparable<FatalShooting> {
	
	//DECLARACION DE ATRIBUTOS
	private String nombre;
	private LocalDate fecha;
	private String causaMuerte;
	private Integer edad;
	private TipoGenero genero;
	private TipoRaza raza;
	private Double estatura;
	private String ciudad;
	private String estado;
	private Boolean señalesEnfermedadMental;
	private PatrullaPolicial patrullaPolicial;
	private List<String> implicados;
	
	
	
	//CONSTRUCTORES
	
	//Constructor con todas las propiedades del tipo
	public FatalShooting (String nombre, LocalDate fecha, String causaMuerte, Integer edad,
			TipoGenero genero, TipoRaza raza, Double estatura, String ciudad, String estado,
			Boolean señalesEnfermedadMental, PatrullaPolicial patrullaPolicial) {
		
		Checkers.check("El nombre no puede estar vacío.", nombre != null && nombre.length() > 0);
		this.nombre = nombre;
		this.fecha = fecha;
		this.causaMuerte = causaMuerte;
		Checkers.check("La edad no puede ser menor que 0.", edad > 0);
		this.edad = edad;
		this.genero = genero;
		this.raza = raza;
		Checkers.check("La estatura no puede ser menor que 0.", estatura > 0);
		this.estatura = estatura;
		this.ciudad = ciudad;
		this.estado = estado;
		this.señalesEnfermedadMental = señalesEnfermedadMental;
		this.patrullaPolicial = patrullaPolicial;
		implicados = new LinkedList<String>();
		
	}
	
	//Constructor con el nombre, fecha y ciudad
	public FatalShooting (String nombre, Integer edad, LocalDate fecha, String ciudad) {
		
		Checkers.check("El nombre no puede estar vacío.", nombre != null && nombre.length() > 0);
		this.nombre = nombre;
		this.fecha = fecha;
		this.causaMuerte = null;
		this.edad = edad;
		this.genero = null;
		this.raza = null;
		this.estatura = null;
		this.ciudad = ciudad;
		this.estado = null;
		this.señalesEnfermedadMental = null;
		this.patrullaPolicial = null;
		implicados = new LinkedList<String>();
	}

	
	
	//MÉTODOS GETTERs
	public String getNombre() {
		return nombre;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}
	
	public String getCausaMuerte() {
		return causaMuerte;
	}
	
	public Integer getEdad() {
		return edad;
	}
	
	public String getGrupoEdad() {
		String res = null;
		if (getEdad() != null) {
			if(getEdad() > 24) {
				res = "Adulto";
			}
			else if(getEdad() <= 24 && getEdad() >= 18) {
				res = "Joven";
			}
			else if(getEdad() < 18) {
				res = "Menor de edad";
			}
		}
		return res;
	}
	
	public TipoGenero getGenero() {
		return genero;
	}
	
	public TipoRaza getRaza() {
		return raza;
	}
	
	public Double getEstatura() {
		return estatura;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public String getEstado() {
		return estado;
	}
	
	public Boolean getSeñalesEnfermedadMental() {
		return señalesEnfermedadMental;
	}
	
	public PatrullaPolicial getPatrullaPolicial() {
		return patrullaPolicial;
	}
	
	public List<String> getImplicados() {
		return implicados;
	}
	
	
	//MÉTODOS SETTERs
	public void setNombre(String nombre) {
		Checkers.check("El nombre no puede estar vacío.", nombre != null && nombre.length() > 0);
		this.nombre = nombre;
	}

	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}

	public void setCausaMuerte(String causaMuerte) {
		this.causaMuerte = causaMuerte;
	}

	public void setEdad(Integer edad) {
		Checkers.check("La edad no puede ser menor que 0.", edad > 0);
		this.edad = edad;
	}

	public void setGenero(TipoGenero genero) {
		this.genero = genero;
	}

	public void setRaza(TipoRaza raza) {
		this.raza = raza;
	}
	
	public void setEstatura(Double estatura) {
		Checkers.check("La estatura no puede ser menor que 0.", estatura > 0);
		this.estatura = estatura;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setSeñalesEnfermedadMental(Boolean señalesEnfermedadMental) {
		this.señalesEnfermedadMental = señalesEnfermedadMental;
	}
	
	
	
	//OTROS MÉTODOS
	public void añadirImplicado(String i) {
		if(!implicados.contains(i)) {
			implicados.add(i);
		}
	}
	
	public void añadirImplicado(String i, int pos) {
		if(!implicados.contains(i)) {
			implicados.add(pos,i);
		}
	}
	
	public void eliminarImplicado(String i) {
		implicados.remove(i);
	}
	
	
	
	//FORMATEO DE PROPIEDADES
	private String formatearFecha(LocalDate fecha) {
		String fechaFormato = null;
		if(fecha != null) {
			fechaFormato = fecha.format(DateTimeFormatter.ofPattern("dd-MM-yy"));	
		}
		return fechaFormato;
	}
	
	private String formatearGenero(TipoGenero genero) {
		String res = null;
		if(genero != null) {
			switch(genero) {
			case M:
				res = "Hombre";
				break;
			case F:
				res = "Mujer";
				break;
			}
		}
		return res;
	}
	
	private String formatearRaza(TipoRaza raza) {
		String res = null;
		if(raza != null) {
			switch(raza) {
			case W:
				res = "Blanca";
				break;
			case B:
				res = "Negra";
				break;
			case H:
				res = "Hispana";
				break;
			case A:
				res = "Asiática";
				break;
			case N:
				res = "Estadounidense nativo";
				break;
			}			
		}
		return res;
	}
	
	
	
	//REPRESENTACIÓN COMO CADENA
	public String toString() {
		return "FatalShooting [nombre=" + nombre + ", fecha=" + formatearFecha(fecha) +
				", causaMuerte=" + causaMuerte + ", edad=" + edad + "(" + getGrupoEdad() + ")" +
				", genero=" + formatearGenero(genero) +", raza=" + formatearRaza(raza) +
				", estatura=" + estatura + ", ciudad=" + ciudad +
				", estado=" + estado + ", señalesEnfermedadMental=" + señalesEnfermedadMental +
				", patrullaPolicial=" + patrullaPolicial + 
				", número de implicados=" + getImplicados().size() + "]";
	}
	
	public String formatoCorto() {
		return nombre + ", " + ciudad + " (" + fecha + ")";
	}

	
	
	//CRITERIO DE IGUALDAD
	//Dos casos serán iguales si el nombre, la edad, la ciudad y el día de la muerte son iguales.
	public int hashCode() {
		return Objects.hash(ciudad, edad, fecha, nombre);
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FatalShooting other = (FatalShooting) obj;
		return Objects.equals(ciudad, other.ciudad) && Objects.equals(edad, other.edad)
				&& Objects.equals(fecha, other.fecha) && Objects.equals(nombre, other.nombre);
	}
	
	
	
	//CRITERIO DE ORDENACIÓN
	public int compareTo(FatalShooting fs) {
		int res = getFecha().compareTo(fs.getFecha());
		if (res == 0) {
			res = getCiudad().compareTo(fs.getCiudad());
		}
		if (res == 0) {
			res = getNombre().compareTo(fs.getNombre());
		}
		return res;
	}
	
	
}
