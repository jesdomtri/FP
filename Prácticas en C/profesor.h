/*
 * Profesor.h
 *
 *  Created on: 4 jun. 2017
 *      Author: Colart
 */

#ifndef PROFESOR_H_
#define PROFESOR_H_

//Importaciones
#include <stdio.h>
#include <string.h>

//Definición de constantes y macros

#define MAXCAR 256
#define MAXPROF 50

//Definición de tipos

typedef char Cadena[MAXCAR];
typedef enum {
	FALSO, CIERTO
} Logico;
typedef enum {
	ASOCIADO, AYUDANTE, CONTRATADO, TITULAR
} Categoria;
typedef struct {
	Cadena nombre;
	Cadena apellidos;
	Categoria categoria;
	double creditos;
} Profesor;
typedef Profesor *PProfesor;
typedef Profesor ArrayProfesores[MAXPROF];

//Declaración de funciones y procedimientos

Logico buscaProfesorPorApellidos(const ArrayProfesores, int, Cadena, PProfesor);

#endif /* PROFESOR_H_ */
