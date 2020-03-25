/*
 * testProfesor.c
 *
 *  Created on: 4 jun. 2017
 *      Author: Colart
 */
#include "profesor.h"

int main() { // Definición de la función principal

	//declaración de variables;
	Profesor p1 = { "Mar", "Ruz Mora", ASOCIADO, 11.0 };
	Profesor p2 = { "Jon", "Paz Ruz", AYUDANTE, 13.0 };
	Profesor p3 = { "Iris", "Paz Mora", CONTRATADO, 5.0 };

	ArrayProfesores ap = { p1, p2, p3 };

	int numProfesores = 3;

	Cadena apellidos;
	strcpy(apellidos, "CAMBIAR APELLIDOS AQUI");

	//instrucciones;
	printf("Devuelve un 1 si es cierto o un 0 si es falso: %d",buscaProfesorPorApellidos(ap, numProfesores, apellidos, &p1));

}
