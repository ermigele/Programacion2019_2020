connect alumno/alumno

SQL> START C:/DATOS/EMPRESA

SET LINE 200;


Nombre: <Pon aquí tu nombre>

/************************************************************************/
	INSTRUCCIONES:
	==============

-Salva este fichero con las iniciales de tu nombre y apellidos,
 en el directorio "C:\Examen\ ":
	Ejemplo:	José María Rivera Calvete
			JMRC.sql

-Pon tu nombre al ejercicio y lee atentamente todas las preguntas.

-Entra en "SQL Plus" con cualquier usuario. 

-Carga el script para el examen desde el fichero "Empresa.sql".

-Donde ponga "SQL>", copiarás las sentencias SQL que has utilizado.

-Donde ponga "RESULTADOS:" copiarás el resultado que SQL*Plus te devuelve.

-RECUERDA: guardar, cada cierto tiempo, el contenido de este fichero. Es lo que voy a evaluar, si lo pierdes, lo siento, en la recuperación tendrás otra oportunidad.

	PUNTUACIÓN
	==========
- Preguntas:	0,625 puntos cada una


/************************************************************************/
	Descripción de las tablas:
	==========================

CENTROS
-------
# Cod_ce	NUMBER(2)			Número identificativo del centro
  Nombre_ce	VARCHAR2(30)		Nombre del centro
  Dir_ce	VARCHAR2(35)		Dirección del centro

DEPARTAMENTOS
-------------
# Cod_de		NUMBER(3)		Número identificativo del departamento
* Centro_de		NUMBER(2)		Número del centro de trabajo donde está el departamento
* Director_de	NUMBER(4)		Número del empleado que es director del departamento
  TipoDir_de	CHAR(1)			Tipo de director: 'P', en propiedad y 'F', en funciones
  Presuesto_de	NUMBER(6)		Presupuesto anual del departamento
* Dptojefe_de	NUMBER(3)		Número del departamento del que depende
  Nombre_de		VARCHAR2(30)	Nombre del departamento

EMPLEADOS
---------
# Cod_em		NUMBER(4)		Número identificativo del empleado
* Dpto_em		NUMBER(3)		Número del departamento al que está asignado el empleado
  ExtTel_em		NUMBER(3)		Extensión telefónica del empleado
  FechaNac_em	DATE			Fecha de nacimiento
  FechaIng_em	DATE			Fecha de ingreso en la empresa
  Salario_em	NUMBER(5)		Salario mensual en euros
  Comision_em	NUMBER(5)		Comisión mensual en euros
  Numhijos_em	NUMBER(2)		Número de hijos
  Apellidos_em	VARCHAR2(30)	Apellidos del empleado
  Nombre_em		VARCHAR2(15)	Nombre del empleado

Nota: 
	# PRIMARY KEY
	* FOREIGN KEY


	
/************************************************************************/
1.- Hallar el número de empleados de toda la empresa.

SQL> SELECT COUNT(*) 
	 FROM EMPLEADOS;

RESULTADO: 34

/************************************************************************/
2.- Hallar la masa salarial (salarios+comisiones) de la empresa.

SQL> SELECT SUM(SALARIO_EM + NVL(COMISION_EM,0)) AS MASA_SALARIAL
	 FROM EMPLEADOS;

RESULTADO: 

MASA_SALARIAL
-------------
        46670

/************************************************************************/
3.- Obtener un listado que incluya el nombre de cada uno de los departamentos junto al nombre y apellidos de su director.

SQL> SELECT Nombre_de, Nombre_em, Apellidos_em
	 FROM DEPARTAMENTOS d, EMPLEADOS e
	 WHERE Director_de = Cod_em;

RESULTADO:

NOMBRE_DE                      NOMBRE_EM       APELLIDOS_EM
------------------------------ --------------- ------------------------------
PERSONAL                       DANIEL          DOMINGUEZ PACHECO
ORGANIZACION                   DANIEL          DOMINGUEZ PACHECO
SECTOR INDUSTRIAL              PABLO           GANDUL ROMERO
DIRECC. COMERCIAL              PABLO           GANDUL ROMERO
DIRECCION GENERAL              MANUEL          RUIZ DE LOPERA
SECTOR SERVICIOS               ISAAC           MARIN SALAS
FINANZAS                       ANTONIO         RODRIGUEZ MORALES
PROCESO DE DATOS               RAQUEL          RUIZ FERNANDEZ

/************************************************************************/
4.- Obtener, por orden alfabético, los nombres y apellidos de los empleados cuyo salario es igual o superior al mayor de los salarios de los 
	empleados del departamento 122.

SQL> SELECT Nombre_em, Apellidos_em
	 FROM  EMPLEADOS
	 WHERE Salario_em >= (SELECT MAX(Salario_em) FROM EMPLEADOS WHERE Dpto_em = 122 )
	 ORDER BY 2, 1;
RESULTADO:

NOMBRE_EM       APELLIDOS_EM
--------------- ------------------------------
PABLO           GANDUL ROMERO
JOSE ANTONIO    MORENO GOMEZ
JOSE MARIA      RIVERA CALVETE
MANUEL          RUIZ DE LOPERA
RAQUEL          RUIZ FERNANDEZ

/************************************************************************/
5.- Obtener, por orden alfabético, los nombres, apellidos y las comisiones de los empleados del departamento 110.

SQL> SELECT Nombre_em, Apellidos_em, Comision_em
	 FROM EMPLEADOS
	 WHERE Dpto_em = 110
	 ORDER BY 2, 1, 3;

RESULTADO:

NOMBRE_EM       APELLIDOS_EM                   COMISION_EM
--------------- ------------------------------ -----------
ROMULO          CAMPOS SORIA
PABLO           GANDUL ROMERO                           50
SERGIO          TORO RAMIREZ

/************************************************************************/
6.- Datos de los empleados que cobran el salario máximo de su departamento.	

SQL> SELECT *
	 FROM EMPLEADOS E
	 WHERE SALARIO_EM = (SELECT MAX(SALARIO_EM) 
	 					 FROM EMPLEADOS 
	 					 WHERE Dpto_em = E.Dpto_em);

RESULTADO:

    COD_EM    DPTO_EM  EXTTEL_EM FECHANAC FECHAING SALARIO_EM COMISION_EM NUMHIJOS_EM APELLIDOS_EM                   NOMBRE_EM
---------- ---------- ---------- -------- -------- ---------- ----------- ----------- ------------------------------ ---------------
       110        121        350 10/11/44 10/02/65       2310                       3 RIVERA CALVETE                 JOSE MARIA
       160        111        740 09/07/54 11/11/83       1310         110           2 FERNANDEZ MONTES               JAVIER
       180        110        508 18/10/49 18/03/71       1480          50           2 GANDUL ROMERO                  PABLO
       260        100        220 03/12/58 12/07/83       1720                       6 RUIZ DE LOPERA                 MANUEL
       270        112        800 21/05/60 10/09/81       1380          80           3 MARIN SALAS                    ISAAC
       290        120        910 30/11/62 14/02/83       1270                       3 RODRIGUEZ AGUAYO               JOSE
       310        130        480 21/11/61 15/01/86       1420                       0 RODRIGUEZ MORALES              ANTONIO
       350        122        610 13/04/64 10/09/99       1450                       1 RUIZ FERNANDEZ                 RAQUEL

/************************************************************************/
7.- Calcular aquellos empleados que llevan más de 35 años en la empresa. Muestre todos los datos de cada uno de ellos.

SQL> SELECT *
	 FROM EMPLEADOS
	 WHERE MONTHS_BETWEEN (SYSDATE, FechaIng_em) / 12 > 35;

RESULTADO:

    COD_EM    DPTO_EM  EXTTEL_EM FECHANAC FECHAING SALARIO_EM COMISION_EM NUMHIJOS_EM APELLIDOS_EM                   NOMBRE_EM
---------- ---------- ---------- -------- -------- ---------- ----------- ----------- ------------------------------ ---------------
       110        121        350 10/11/44 10/02/65       2310                       3 RIVERA CALVETE                 JOSE MARIA
       120        112        840 09/06/50 01/10/83       1350         110           1 ALONSO SORIANO                 ANTONIO
       130        112        810 09/11/60 01/02/84       1290         110           2 CANO GALVEZ                    JOSE MANUEL
       150        121        340 10/08/45 15/01/63       1440                       0 DOMINGUEZ PACHECO              DANIEL
       160        111        740 09/07/54 11/11/83       1310         110           2 FERNANDEZ MONTES               JAVIER
       180        110        508 18/10/49 18/03/71       1480          50           2 GANDUL ROMERO                  PABLO
       190        121        350 12/05/47 11/02/77       1300                       4 GARCIA PEREZ                   SONIA
       210        100        200 28/09/55 22/01/74       1380                       2 MANCHEÐO CAMACHO               JESUS
       240        111        760 26/02/57 24/02/81       1280         100           3 MAQUEDA GARCIA                 JULIO
       250        100        250 27/10/61 01/03/82       1450                       0 MORENO GOMEZ                   JOSE ANTONIO
       260        100        220 03/12/58 12/07/83       1720                       6 RUIZ DE LOPERA                 MANUEL
       270        112        800 21/05/60 10/09/81       1380          80           3 MARIN SALAS                    ISAAC
       285        122        620 25/10/64 15/02/83       1380                       0 PANIAGUA VELA                  ENRIQUE
       290        120        910 30/11/62 14/02/83       1270                       3 RODRIGUEZ AGUAYO               JOSE
       360        111        750 29/10/73 10/10/83       1250         100           2 SALGADO PEREZ                  JOSE

/************************************************************************/
8.- Hallar, por orden de número de empleado, el nombre, apellidos y el salario total (salario más comisión) de los empleados 
	cuyo salario total supera los 1300 euros mensuales.

SQL> SELECT COD_EM, NOMBRE_EM, APELLIDOS_EM, SALARIO_EM + NVL(COMISION_EM,0) AS SALARIO_TOTAL
	 FROM EMPLEADOS
	 WHERE SALARIO_EM + NVL(COMISION_EM,0) > 1300
	 ORDER BY 1;

RESULTADO:

    COD_EM NOMBRE_EM       APELLIDOS_EM                   SALARIO_TOTAL
---------- --------------- ------------------------------ -------------
       110 JOSE MARIA      RIVERA CALVETE                          2310
       120 ANTONIO         ALONSO SORIANO                          1460
       130 JOSE MANUEL     CANO GALVEZ                             1400
       150 DANIEL          DOMINGUEZ PACHECO                       1440
       160 JAVIER          FERNANDEZ MONTES                        1420
       180 PABLO           GANDUL ROMERO                           1530
       210 JESUS           MANCHEÐO CAMACHO                        1380
       240 JULIO           MAQUEDA GARCIA                          1380
       250 JOSE ANTONIO    MORENO GOMEZ                            1450
       260 MANUEL          RUIZ DE LOPERA                          1720
       270 ISAAC           MARIN SALAS                             1460
       285 ENRIQUE         PANIAGUA VELA                           1380
       310 ANTONIO         RODRIGUEZ MORALES                       1420
       320 ROSA MARIA      ROMERO CAMPILLEJO                       1405
       330 MARIA PIEDAD    ROMERO FERNANDEZ                        1370
       350 RAQUEL          RUIZ FERNANDEZ                          1450
       360 JOSE            SALGADO PEREZ                           1350
       420 CLAUDIA         FIERRO GARCIA                           1400
       440 LIVIA           DURAN DELGADO                           1310
       450 CARMEN          PEREZ RAMOS                             1310
       480 DIANA           PINO BUSTOS                             1310
/************************************************************************/

9.- Mostrar para cada empleado el número de meses que lleva el empleado en la empresa junto con su nombre.

SQL> SELECT TRUNC(MONTHS_BETWEEN(SYSDATE, FechaIng_em)) AS MESES, NOMBRE_EM
	 FROM EMPLEADOS;  

RESULTADO:

     MESES NOMBRE_EM
---------- ---------------
       657 JOSE MARIA
       434 ANTONIO
       430 JOSE MANUEL
       682 DANIEL
       432 JAVIER
       584 PABLO
       513 SONIA
       550 JESUS
       465 JULIO
       453 JOSE ANTONIO
       436 MANUEL
       458 ISAAC
       397 CONCEPCION
       441 ENRIQUE
       441 JOSE
       406 ANTONIO
       322 ROSA MARIA
       393 MARIA PIEDAD
       242 RAQUEL
       433 JOSE
       214 EDUARDO
       203 SERGIO
       217 SERGIO
       205 LUCRECIA
       193 AZUCENA
       192 CLAUDIA
       192 VALERIA
       225 LIVIA
       225 CARMEN
       225 DIANA
       203 EUGENIA
       215 VICTORIA
       217 ROMULO
       202 SANCHO

/************************************************************************/
10.- Mostrar un listado donde aparezca el código de los departamentos y su nombre conjuntamente con el código de los centros en donde están situados 
	 y el nombre de estos centros.

SQL> SELECT Cod_de, Nombre_de, Cod_ce, Nombre_ce
	FROM DEPARTAMENTOS D, CENTROS C
	WHERE D.Centro_de=C.Cod_ce;

RESULTADO:

    COD_DE NOMBRE_DE                          COD_CE NOMBRE_CE
---------- ------------------------------ ---------- ------------------------------
       100 DIRECCION GENERAL                      10 SEDE CENTRAL
       110 DIRECC. COMERCIAL                      20 SEDE ORIENTAL
       111 SECTOR INDUSTRIAL                      30 PRODUCCION
       112 SECTOR SERVICIOS                       20 SEDE ORIENTAL
       120 ORGANIZACION                           10 SEDE CENTRAL
       121 PERSONAL                               30 PRODUCCION
       122 PROCESO DE DATOS                       30 PRODUCCION
       130 FINANZAS                               10 SEDE CENTRAL

/************************************************************************/
11.- Hallar, en una consulta, los siguientes datos para cada departamento junto con su código:
	a) Número de empleados.
	b) Salario medio, máximo y mínimo
	c) Media de las comisiones.

Poner un alias a las columnas que usen funciones de grupo o agregación.

SQL> SELECT  D.Cod_de AS CODIGO_DEPART, COUNT(Cod_em), AVG(Salario_em) AS SALARIO_MEDIO, MAX(Salario_em) AS SALARIO_MAXIMO, MIN(Salario_em) AS SALARIO_MINIMO, 
		AVG(E.Comision_em) AS COMISION_MEDIA
	 FROM DEPARTAMENTOS D, EMPLEADOS E
	 WHERE D.Cod_de=E.Dpto_em
	 GROUP BY D.Cod_de;

RESULTADO:

CODIGO_DEPART COUNT(COD_EM) SALARIO_MEDIO SALARIO_MAXIMO SALARIO_MINIMO COMISION_MEDIA
------------- ------------- ------------- -------------- -------------- --------------
          100             3    1516,66667           1720           1380
          121             4          1560           2310           1190
          120             1          1270           1270           1270
          112             7    1267,14286           1380           1180     98,3333333
          110             3    1298,33333           1480           1200             50
          130             3          1370           1420           1290
          111             8      1218,125           1310           1100     104,285714
          122             5          1324           1450           1175

/************************************************************************/
12.-  Calcular cuantos números de teléfono distintos usa cada departamento, mostrando el código y el nombre de cada departamento.

SQL>

RESULTADO:

/************************************************************************/
13.- Mostrar los departamentos (número y nombre) con sus centros (número y nombre) y la edad media de sus empleados de aquellos departamentos que tienen una edad media en sus empleados mayor a 35 años.

SQL>

RESULTADO:

/************************************************************************/
14.- Para cada grupo de empleados que cobran el mismo salario y tienen el mismo número de hijos, diga cuantos empleados forman el grupo y en cuantos departamentos están trabajando.

SQL>

RESULTADO:

/************************************************************************/
15.- Para cada extensión telefónica, hallar cuántos empleados la usan y el salario medio de éstos.

SQL>

RESULTADO:

/************************************************************************/
16.- Hallar el salario medio por departamento para aquellos departamentos cuyo salario máximo es inferior al salario medio de todos los empleados.

SQL>

RESULTADO:

