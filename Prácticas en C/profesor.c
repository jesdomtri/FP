/*
 * profesor.c
 *
 *  Created on: 4 jun. 2017
 *      Author: Colart
 */

#include "profesor.h"

//Definición de las funciones declaradas anteriormente

Logico buscaProfesorPorApellidos(const ArrayProfesores profesores,
		int numProfesores, Cadena apellidos, PProfesor res) {
	int i;
	Logico es = FALSO;
	for (i = 0; i < numProfesores; i++) {
		if (strcmp(profesores[i].apellidos, apellidos) == 0) {
			es = CIERTO;
			*res = profesores[i];
			break;
		}
	}
	return es;
}
