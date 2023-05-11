# proyecto-java-CurroAyala
proyecto-java-CurroAyala created by GitHub Classroom

# proyecto-java-CurroAyala
proyecto-java-CurroAyala created by GitHub Classroom  

## ESTRUCTURA DE LAS CARPETAS DEL PROYECTO  
/src: Directorio con el código fuente.  
fp.shootings: Paquete que contiene los tipos del proyecto.  
fp.shootings.test: Paquete que contiene las clases de test del proyecto.  
fp.utiles: Paquete que contiene las clases de utilidad.  
/data: Contiene el dataset del proyecto.  
fatal-police-shootings-data-edited.csv: Archivo csv que contiene datos de diferentes tiroteos con víctimas en Estados Unidos.  


## ESTRUCTURA DEL DATASET  
Originalmente tiene 13 columnas y cada fila contiene datos sobre un tiroteo con víctima en Estados Unidos. El dataset usado en este proyecto tiene 12 columnas, conservando algunas de las originales y generando otras de forma aleatoria. A continuación se describen las 12 columnas del dataset:  
1. name, de tipo String: contiene el nombre de la víctima.  
2. date, de tipo LocalDate: contiene la fecha del suceso.  
3. manner_of_death, de tipo String: contiene la causa de la muerte.  
4. age, de tipo Integer: contiene la edad de la víctima.  
5. gender, de tipo String: contiene el género de la víctima.
6. race, de tipo String: contiene la raza de la víctima.
7. heigh, de tipo Double: contiene la estatura de la víctima.  
8. city, de tipo String: contiene la ciudad del suceso.
9. estado, de tipo String: contiene el estado del suceso.  
10. signs_of_mental_illness, de tipo Boolean: indica si la víctima tenía indicios de enfermedad mental o no.  
11. police, de tipo String: indica el tipo de policía que acudió al tiroteo.  
12. number_of_officers, de tipo Integer: indica el número de agentes que acudieron al tiroteo.  

___  

## TIPOS IMPLEMENTADOS  

### Tipo base - Tipo FatalShooting  
Este tipo representa un caso de tiroteo con víctima mortal en concreto, con las siguientes propiedades:  
  1. nombre: de tipo String  
  2. fecha: de tipo LocalDate  
  3. causaMuerte: de tipo String  
  4. edad: de tipo Integer  
  5. genero: de tipo TipoGenero  
  6. raza: de tipo TipoRaza  
  7. estatura: de tipo Double  
  8. ciudad:  de tipo String  
  9. estado: de tipo String  
  10. señalesEnfermedadMental: de tipo Boolean  
  11. patrullaPolicial: de tipo auxiliar PatrullaPolicial  
  12. implicados, de tipo List<String>  


CONSTRUCTORES  

Constructor 1: tiene un parámetro por cada propiedad básica.  
Constructor 2: crea un tipo FatalShooting solo el nombre, la edad, la fecha y la cidad.  

  
RESTRICCIONES  

Restricción 1: el nombre no puede ser nulo o estar vacío  
Restricción 2: la edad no puede ser menor que 0  
Restricción 3: la estatura no puede ser menor que 0


CRITERIO DE ORDENACIÓN: por fecha, ciudad, y nombre  



### Tipo Factoría - FactoriaFatalShooting  
Crea objetos de tipo FatalShootings.  



### Tipo Contenedor - FatalShootings  
Clase contenedora de los objetos de tipo FatalShooting.  

PROPIEDADES  
fatalShootings de tipo List<FatalShooting>  


CONSTRUCTORES  
Constructor 1: crea un objeto de tipo FatalShootings sin argumentos.  
Constructor 2: crea un objeto de tipo FatalShootings con un parámetro de tipo Stream<FatalShootings>.  


CRITERIO DE IGUALDAD: dos FatalShootings son iguales si los son todos sus elementos FatalShooting.  


MÉTODOS  
void añadirFatalShooting: añade un objeto de tipo FatalShooting a la lista FatalShootings.  

void añadirColeccionFS: añade una colección de objetos de tipo FatalShooting a la lista FatalShootings.  

void eliminarElemento: elimina un objeto de tipo dado de la lista FatalShootings, si estuviese. 
Este método tiene otra forma en la que se elimina un elemento indicando su índice.  

void eliminarColeccion: elimina los elementos de una colección, dada como argumento, que estén en la lista FatalShootings.  

FatalShooting getFS: devuelve el elemento de la lista FatalShootings que coincida con el índice dado como argumento.  

(Métodos segunda entrega)  
List<String> comprobarCasoPorNombre: este método devuelve una lista con todos los objetos de tipo FatalShooting cuya propiedad nombre sea igual a un argumento dado.  

Integer calcularMediaEdadVictimas: este método devuelve un objeto de tipo Integer que corresponde con la media de la edad de las víctimas.  

ArrayList<String> seleccionarCasosEnfermedadMental: este método devuelve una lista con los objetos de tipo FatalShooting cuya propiedad signs_of_mental_illness sea igual a true.  

Map<String, List<String>> agruparPorEstado: este método devuelve un Mapa cuyas claves son los distintos estados de Estados Unidos en los que ha habido un caso de tiroteo policial con víctima; y los valores son listas de los nombres de la víctimas de los casos de cada estado.  

Map<Integer, Integer> contarPorAño: este método devuelve un Mapa cuyas claves son los distintos años de los que se tiene registro de tiroteos policieales con víctima; y los valores son el número total de estos casos por año.  

(Métodos tercera entrega)  

Bloque 1  

List<String> comprobarCasoPorNombre2(String nombre): comprueba si existe un caso en el que haya fallecido una persona con un nombre dado.  

Integer calcularMediaEdadVictimas2(): calcula la media de edad de las víctimas.  
  
ArrayList<String> seleccionarCasosEnfermedadMental2(): selecciona los casos en los que las víctimas tenían señas de enfermedad mental.  

String hallarMujerMasJoven(): halla la víctima mujer más joven (mínimo).  

ArrayList<String> victimasDeRazaNegraPorEdad(): se seleccionan las víctimas de raza negra y se ordenan por su edad.  


Bloque 2  

Map<Integer, Long> contarPorAño2(): cuenta en un MAP las víctimas que han habido en cada año (misma función que la tipo 5 de la segunda entrega).  

int mediaNumAgentes(): halla la media de número de agentes en cada caso con MAPPING.  

Map<String, String> personasMasAltasPorRaza(): crea un MAP cuyas claves son las distinas razas y los valores son la persona más alta de cada raza.  

SortedMap<String, List<FatalShooting>> nCasosMasAgentesPorCausaMuerte(Integer n): crea un MAP cuyas claves son las distintas causas de muerte y los valores son los n casos a los que acudieron más agentes policiales.  

String razaConPersonaMasAlta(): halla la raza con la persona más alta.  
