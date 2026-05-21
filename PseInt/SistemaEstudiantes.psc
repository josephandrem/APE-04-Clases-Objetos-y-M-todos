Algoritmo SistemaEstudiantes
	// ?? Definición de arreglos para almacenar los datos ??
	Definir cedula, nombre, apellido, estado Como Cadena
	Definir nota1, nota2, nota3, promedio Como Real
	Definir aprobados, reprobados, i Como Entero
	Definir TOTAL Como Entero
	TOTAL <- 5
	Dimensionar cedulas(TOTAL), nombres(TOTAL), apellidos(TOTAL)
	Dimensionar notas1(TOTAL), notas2(TOTAL), notas3(TOTAL)
	Dimensionar promedios(TOTAL), estados(TOTAL)
	aprobados <- 0
	reprobados <- 0
	Escribir '============================================='
	Escribir '   SISTEMA DE CONTROL DE ESTUDIANTES        '
	Escribir '============================================='
	// ?? Ciclo de ingreso de datos ?????????????????????????
	Para i<-1 Hasta TOTAL Con Paso 1 Hacer
		Escribir '>> Ingreso - Estudiante ', i
		Escribir '  Cedula   : '
		Leer cedulas[i]
		Escribir '  Nombre   : '
		Leer nombres[i]
		Escribir '  Apellido : '
		Leer apellidos[i]
		// ?? Leer y validar Nota 1 ??
		Repetir
			Escribir '  Nota 1 (0-10): '
			Leer notas1[i]
			Si notas1[i]<0 O notas1[i]>10 Entonces
				Escribir '  ERROR: La nota debe estar entre 0 y 10'
			FinSi
		Hasta Que notas1[i]>=0 Y notas1[i]<=10
		// ?? Leer y validar Nota 2 ??
		Repetir
			Escribir '  Nota 2 (0-10): '
			Leer notas2[i]
			Si notas2[i]<0 O notas2[i]>10 Entonces
				Escribir '  ERROR: La nota debe estar entre 0 y 10'
			FinSi
		Hasta Que notas2[i]>=0 Y notas2[i]<=10
		// ?? Leer y validar Nota 3 ??
		Repetir
			Escribir '  Nota 3 (0-10): '
			Leer notas3[i]
			Si notas3[i]<0 O notas3[i]>10 Entonces
				Escribir '  ERROR: La nota debe estar entre 0 y 10'
			FinSi
		Hasta Que notas3[i]>=0 Y notas3[i]<=10
		// ?? Calcular promedio ??
		promedios[i] <- (notas1[i]+notas2[i]+notas3[i])/3
		// ?? Determinar estado ??
		Si promedios[i]>=7 Entonces
			estados[i] <- 'Aprobado'
			aprobados <- aprobados+1
		SiNo
			estados[i] <- 'Reprobado'
			reprobados <- reprobados+1
		FinSi
	FinPara
	// ?? Mostrar listado completo ??????????????????????????
	Escribir '============================================='
	Escribir '      LISTADO COMPLETO DE ESTUDIANTES       '
	Escribir '============================================='
	Para i<-1 Hasta TOTAL Con Paso 1 Hacer
		Escribir '---------------------------------------------'
		Escribir '  Cedula   : ', cedulas[i]
		Escribir '  Nombre   : ', nombres[i], ' ', apellidos[i]
		Escribir '  Nota 1   : ', notas1[i]
		Escribir '  Nota 2   : ', notas2[i]
		Escribir '  Nota 3   : ', notas3[i]
		Escribir '  Promedio : ', promedios[i]
		Escribir '  Estado   : ', estados[i]
		Escribir '---------------------------------------------'
	FinPara
	// ?? Resumen estadístico ??????????????????????????????
	Escribir '============================================='
	Escribir '              RESUMEN FINAL                 '
	Escribir '============================================='
	Escribir '  Total estudiantes : ', TOTAL
	Escribir '  Aprobados         : ', aprobados
	Escribir '  Reprobados        : ', reprobados
	Escribir '============================================='
FinAlgoritmo
