-- Tablas EMPLE y DEPART

--1º Seleccionar de la tabla EMPLE, aquellas filas cuyo APELLIDO empiece por "A" y el OFICIO tenga una "E" en cualquier posición.
SELECT * 
FROM EMPLE 
WHERE APELLIDOS LIKE 'A%' AND OFICIO LIKE '%E%';

--2º Seleccionar el APELLIDO, OFICIO y LOCALIDAD de los empleados que son ANALISTAS.
SELECT APELLIDO, OFICIO, LOC 
FROM EMPLE E, DEPART D 
WHERE E.DEPT_NO = D.DEPT_NO AND OFICIO = 'ANALISTA';

--3º Mostrar los empleados (nombre, oficio, salario y fecha de alta) que desempeñen el mismo oficio que "JIMENEZ" o 
--que tengan un salario mayor o igual que "FERNANDEZ".
SELECT APELLIDO, OFICIO, SALARIO 
FROM EMPLE 
WHERE OFICIO LIKE (SELECT OFICIO
					FROM EMPLE
					WHERE APELLIDO = 'JIMENEZ')
OR
	SALARIO >= (SELECT SALARIO
				FROM EMPLE
				WHERE APELLIDO = 'FERNANDEZ');

--4º Mostrar en pantalla el nombre, oficio y salario de los empleados del departamento de "FERNANDEZ" que tengan su mismo salario.
SELECT APELLIDO, OFICIO, SALARIO 
FROM EMPLE 
WHERE DEPT_NO LIKE (SELECT DEPT_NO
					FROM EMPLE
					WHERE APELLIDO = 'FERNANDEZ')
AND 
	SALARIO = ( SELECT SALARIO
				FROM EMPLE
				WHERE APELLIDO = 'FERNANDEZ'); 

-- ESTA ES MAS EFECIENTE, YA QUE OBTIENE LA COMPARATIVA DE LOS REGISTROS EN UNA MISMA CONDICIÓN.
SELECT APELLIDO, OFICIO, SALARIO 
FROM EMPLE 
WHERE (DEPT_NO, SALARIO) = (SELECT DEPT_NO, SALARIO FROM EMPLE WHERE APELLIDO = 'FERNANDEZ');

--5º Mostrar los nombres y oficios de los empleados que tienen el mismo trabajo que "JIMENEZ".

SELECT APELLIDO, OFICIO 
FROM EMPLE
WHERE OFICIO = (SELECT OFICIO
					FROM EMPLE
					WHERE APELLIDO = 'JIMENEZ');


---Tabla LIBRERIA

-- 1º Visualizar el tema, estante y ejemplares de las filas de LIBRERIA con ejemplares comprendidos entre 8 y 15.
SELECT tema, estante, ejemplares
FROM LIBRERIA
WHERE ejemplares BETWEEN 8 AND 15; 

-- 2º Visualizar las columnas tema, estante y ejemplares de las filas cuyo ESTANTE no esté comprendido entre la "B" y la "D".
SELECT tema, estante, ejemplares
FROM LIBRERIA
WHERE estante NOT BETWEEN 'B' AND 'D';

-- 3º Visualizar con una única orden SELECT (subconsulta) todos los temas de LIBRERIA cuyo numero de ejemplares sea inferior a los que hay en "Medicina".
SELECT *
FROM LIBRERIA
WHERE ejemplares < (SELECT ejemplares
					FROM LIBRERIA
					WHERE tema = 'Medicina');

-- 4º Visualizar los temas de LIBRERIA cuyo número de ejemplares no esté entre 15 y 20, ambos incluidos.
SELECT tema
FROM LIBRERIA
WHERE ejemplares NOT BETWEEN 15 AND 20;


-- Tablas ALUMNOS, ASIGNATURAS, y NOTAS

-- 1º Visualizar todas las ASIGNATURAS que contengan tres letras "o" en su nombre y tengan alumnos matriculados en "Madrid".
SELECT NOMBRE
FROM ASIGNATURAS ASI , ALUMNOS ALU , NOTAS N
WHERE ASI.COD=N.COD AND N.DNI=ALU.DNI AND UPPER(NOMBRE) LIKE '%O%O%O%' AND POBLA = 'Madrid';

-- 2º Visualizar los nombres de los alumnos que tengan una nota entre 7 y 8 en la asignatura "FOL".
SELECT APENOM
FROM ASIGNATURAS ASI , ALUMNOS ALU , NOTAS N
WHERE ASI.COD=N.COD AND N.DNI=ALU.DNI AND ( NOTA BETWEEN  7 AND 8) AND NOMBRE = 'FOL';

-- 3º Mostrar los nombres de los alumnos de Madrid que tengan alguna asignatura suspendida.
SELECT APENOM
FROM ASIGNATURAS ASI , ALUMNOS ALU , NOTAS N
WHERE ASI.COD=N.COD AND N.DNI=ALU.DNI AND NOTA < 5 AND POBLA = 'Madrid';

-- 4º Mostrar los nombres de las asignaturas que no tengan suspensos.
SELECT NOMBRE
FROM ASIGNATURAS ASI, ALUMNOS ALU, NOTAS N
WHERE ASI.COD=N.COD AND N.DNI=ALU.DNI AND N.NOTA >= 5;
-- 5º Mostrar los nombres de los alumnos que tengan la misma nota que tiene "Diaz Fernandez, Maria" en "FOL" en alguna asignatura
