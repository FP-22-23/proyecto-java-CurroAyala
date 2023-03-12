# proyecto-java-CurroAyala
proyecto-java-CurroAyala created by GitHub Classroom

Estructura de las carpetas del proyecto  
  /src: Directorio con el código fuente.  
    fp.shootings: Paquete que contiene los tipos del proyecto.  
    fp.shootings.test: Paquete que contiene las clases de test del proyecto.  
    fp.utiles: Paquete que contiene las clases de utilidad.  
  /data: Contiene el dataset del proyecto.  
fatal-police-shootings-data-edited.csv: Archivo csv que contiene datos de diferentes tiroteos con víctimas en Estados Unidos.  


Estructura del dataset  
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


TIPOS IMPLEMENTADOS  

Tipo base - Tipo FatalShooting  

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


