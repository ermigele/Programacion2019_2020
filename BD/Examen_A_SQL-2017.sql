TIPO A

SQL> START C:/DATOS/DatosExamen

SET LINE 200;

Nombre: <Pon tu nombre >

************************************************************************
	INSTRUCCIONES:
	==============

-Salva este fichero con las iniciales de tu nombre y apellidos,
 en el directorio "C:\Examen\ ":
	Ejemplo:	José María Rivera Calvete
			    JMRC.sql

-Pon tu nombre al ejercicio y lee atentamente todas las preguntas.

-Entra en "SQL Plus" con cualquier usuario. 

-Carga el script para el examen desde el fichero "DatosExamen.sql".

-Donde ponga "SQL>", copiarás las sentencias SQL que has utilizado.

-Donde ponga "Resultado:" copiarás el resultado que SQL*Plus te devuelve.

-RECUERDA: guardar, cada cierto tiempo, el contenido de este fichero. Es lo que voy a evaluar, si lo pierdes, lo siento, en la recuperación tendrás otra oportunidad.

-PUNTUACIÓN:  	0,625 puntos cada pregunta


************************************************************************
	Descripción de las tablas:
	==========================

CREATE TABLE PROFESORES(
  COD_PR			NUMBER(2)		PRIMARY KEY,
  DNI_PR			CHAR(9)			UNIQUE,
  NOMBRE_PR			VARCHAR2(25)	NOT NULL,
  ESPECIALIDAD_PR	VARCHAR2(15)	NOT NULL
);
CREATE TABLE CLASES(
  PROFESOR_CL		NUMBER(2),
  ASIGNATURA_CL		NUMBER(3),
  AULA_CL			NUMBER(2), 
  HORASSEM_CL		NUMBER(2), 
  PRIMARY KEY (PROFESOR_CL, ASIGNATURA_CL)
);
CREATE TABLE ASIGNATURAS(
  COD_AS		NUMBER(3)		PRIMARY KEY,
  NOMBRE_AS		VARCHAR2(35)	NOT NULL,
  HORAS_AS		NUMBER(3)		NOT NULL
);
CREATE TABLE ALUMNOS(
  COD_AL		NUMBER(2)	PRIMARY KEY,
  FECINC_AL		DATE,
  FECNAC_AL		DATE,
  DNI_AL		CHAR(9)			UNIQUE,
  NOMBRE_AL		VARCHAR2(25) 	NOT NULL,
  CIUDAD_AL		VARCHAR2(10) 	NOT NULL,
  TUTOR_AL		NUMBER(2),
  DELEGADO_AL	NUMBER(2)
  );
CREATE TABLE NOTAS(
  ALUMNO_NO		NUMBER(2),
  ASIGNATURA_NO	NUMBER(3),
  FECHA_NO		DATE,
  NOTA_NO		NUMBER(4,2),
  PRIMARY KEY (ALUMNO_NO, ASIGNATURA_NO, FECHA_NO)
  );

***************************************************************************************************************
 1.- Mostrar de cada alumno su nombre y apellidos (tal como están almacenados), DNI y la edad que tenían cuando ingresaron.

 SQL> SELECT NOMBRE_AL, DNI_AL, ROUND(MONTHS_BETWEEN(FECINC_AL, FECNAC_AL) / 12) AS FECHA_INGRESO
      FROM ALUMNOS;

Resultado:

NOMBRE_AL                 DNI_AL    FECHA_INGRESO
------------------------- --------- -------------
Arias Grillo, Jairo       55645991T            20
Arnaldos Valle, Javier    54652636D            32
Avila Ferrete, Raquel     71106202D            24
Cabrera Alava, Kilian     56646516D            22
Pires Barranco, Amador    51506642K            22
Calvo Jimenez, Alberto    55980648H            23
Camacho Lindsey, Daniel   64555339D            22
Pozo Martin, Ismael       37839343D            24
Rolo Vera, Luis Miguel    76138301V            27
Mendizabal Romero, Luis   67918627L            30
Gallego Carvajal, Juan    63453550T            40
Reina Ramirez, Joaquin    90676183D            25
Gata Masero, Carlos       22563618D            22

***************************************************************************************************************
 2.- Mostrar de cada profesor su nombre y apellidos en mayúsculas, junto con la letra de su DNI.

 SQL>  SELECT UPPER(NOMBRE_PR) AS NOMBRE_MAYUS, LTRIM(DNI_PR, '0123456789') AS LETRA_DNI
       FROM PROFESORES;

Resultado:

NOMBRE_MAYUS              LETRA_DNI
------------------------- ---------
DEL JUNCO SUAREZ, MALVINA D
MATITO LOZANO, CARMEN     D
TOSCANO FERNANDEZ, JUAN   D
VALVERDE GALLEGO, ENRIQUE K

***************************************************************************************************************
 3.- Mostrar nombre y apellidos de cada alumnos junto con el nombre (SIN LOS APELLIDOS) de su tutor.
 
SQL> SELECT A.NOMBRE_AL AS ALUMNO, SUBSTR(NOMBRE_PR, INSTR(NOMBRE_PR, ',') + 1) AS TUTOR
     FROM ALUMNOS A, PROFESORES P
     WHERE  A.TUTOR_AL= P.COD_PR;

Resultado:

ALUMNO                    TUTOR
------------------------- --------------
Arias Grillo, Jairo        Malvina
Arnaldos Valle, Javier     Malvina
Avila Ferrete, Raquel      Malvina
Cabrera Alava, Kilian      Malvina
Pires Barranco, Amador     Malvina
Calvo Jimenez, Alberto     Malvina
Camacho Lindsey, Daniel    Carmen
Pozo Martin, Ismael        Carmen
Rolo Vera, Luis Miguel     Carmen
Mendizabal Romero, Luis    Carmen
Gallego Carvajal, Juan     Carmen
Reina Ramirez, Joaquin     Carmen
Gata Masero, Carlos        Carmen

***************************************************************************************************************
 4.- Mostrar la nota media (CON DOS DECIMALES) de la asignatura BASES DE DATOS.
 
SQL> SELECT ROUND(AVG(NOTA_NO),2) AS NOTA_MEDIA, NOMBRE_AS
     FROM NOTAS, ASIGNATURAS
     WHERE ASIGNATURA_NO = COD_AS AND UPPER(NOMBRE_AS) LIKE 'BASES DE DATOS'
     GROUP BY NOMBRE_AS;

Resultado:

NOTA_MEDIA NOMBRE_AS
---------- -----------------------------------
      6,91 Bases de datos

***************************************************************************************************************
 5.- Mostrar código, nombre y apellido, y DNI de los alumnos que han aprobado algún examen de LENGUAJE DE MARCAS.
 
SQL> SELECT COD_AL, NOMBRE_AL, DNI_AL
     FROM ALUMNOS A, NOTAS N
     WHERE A.COD_AL = N.ALUMNO_NO AND NOTA_NO > 4  AND ASIGNATURA_NO = (SELECT COD_AS FROM ASIGNATURAS WHERE UPPER(NOMBRE_AS) LIKE 'LENGUAJES DE MARCAS');

Resultado:

    COD_AL NOMBRE_AL                 DNI_AL
---------- ------------------------- ---------
        10 Arias Grillo, Jairo       55645991T
        13 Cabrera Alava, Kilian     56646516D
        10 Arias Grillo, Jairo       55645991T
        12 Avila Ferrete, Raquel     71106202D
        10 Arias Grillo, Jairo       55645991T
        11 Arnaldos Valle, Javier    54652636D
        12 Avila Ferrete, Raquel     71106202D

***************************************************************************************************************
 6.- Mostrar las horas que da clase a la semana cada profesor.
 
SQL>

Resultado:

***************************************************************************************************************
 7.- Mostrar de cada alumno su código y sus apellidos (SIN EL NOMBRE) junto con el nombre y apellidos de su delegado.
 
SQL> SELECT A.COD_AL, SUBSTR(A.NOMBRE_AL, INSTR(A.NOMBRE_AL, ',') +1) AS ALUMNO, D.NOMBRE_AL AS DELEGADO_AL
     FROM ALUMNOS A, ALUMNOS D
     WHERE A.DELEGADO_AL = D.COD_AL;    --QUITAR EL NOMBRE EN VEZ DEL APELLIDO

Resultado:

***************************************************************************************************************
 8.- Mostrar los profesores que le han dado clase a JAIRO (Serán aquellos que imparten la asignatura en la que tiene nota).
 
SQL>

Resultado:

***************************************************************************************************************
 9.- Mostrar, de cada asignatura, su nombre y la nota media (CON DOS DECIMALES).
 
SQL>

Resultado:

***************************************************************************************************************
10.- (OUTER JOIN, hay asignaturas que no tienen notas) Mostrar, de cada asignatura, su nombre y la nota media (CON DOS DECIMALES).
 
SQL>

Resultado:

***************************************************************************************************************
11.- Mostrar el nombre de la asignatura con la nota media más alta.
 
SQL>

Resultado:

***************************************************************************************************************
12.- Mostrar la nota media (CON DOS DECIMALES) de cada alumno en cada asignatura (nombre y apellidos junto con el nombre de la asignatura) para los alumnos de BADAJOZ.
 
SQL>

Resultado:

***************************************************************************************************************
13.- Mostrar el nombre y apellidos de los alumnos que sacaron en algún examen, la misma nota que la máxima nota que sacó JAIRO en LENGUAJE DE MARCAS.
 
SQL>

Resultado:

***************************************************************************************************************
14.- Mostrar el nombre y apellidos del profesor que ha puesto la nota más alta.
 
SQL>

Resultado:

***************************************************************************************************************
15.- Mostrar la fecha en la que se hizo el primer examen con el siguiente formato: 'Jueves 12 de diciembre de 2017 '.
 
SQL>

Resultado:

***************************************************************************************************************
16.- Mostrar cuantos examenes ha hecho cada alumno en BASES DE DATOS.
 
SQL>

Resultado:
 
