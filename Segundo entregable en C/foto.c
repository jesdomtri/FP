/*
 * foto.c
 *
 *  Created on: 28/5/2017
 *      Author: mariano
 */
#include "foto.h"

// TODO Funci�n leeFotoFichero

int leeFotosFichero(const Cadena nombreFichero, ArrayFotos fotos) {

}

// TODO Funci�n leeFotosFichero

void leeFotoFichero(FILE *f, PFoto p) {

}

// TODO Funci�n numeroFotosAutor

int numeroFotosAutor(const ArrayFotos fotos, int n, Cadena autor) {
	int res, i;
	for (i = 0; i < n; i++) {
		if (strcmp(fotos[i].autor, autor) == 0) {
			res++;
			i++;
		}
	}
	return res;
}

void quitaSaltoDeLinea(Cadena c) {
	int fin = strlen(c) - 1;
	if (c[fin] == '\n') {
		c[fin] = '\0';
	}
}
