/*
 * foto.h
 *
 *  Created on: 28/5/2017
 *      Author: mariano
 */

#ifndef FOTO_H_
#define FOTO_H_

#include <stdio.h>
#include <string.h>

#define MAXCAR 256
#define MAX_FOTOS 100

typedef enum {
	FALSO, CIERTO
} Logico;
typedef char Cadena[MAXCAR];

// TODO Tipo Foto
typedef struct {
	Cadena titulo;
	Cadena autor;
	int anyo;
	int descargas;
} Foto;

// TODO Tipo ArrayFotos
typedef Foto ArrayFotos[MAX_FOTOS];

// TODO Tipo PFoto
typedef Foto *PFoto;

int leeFotosFichero(const Cadena nombreFichero, ArrayFotos fotos);
void leeFotoFichero(FILE *f, PFoto p);
int numeroFotosAutor(const ArrayFotos fotos, int n, Cadena autor);

void quitaSaltoDeLinea(Cadena c);

#endif /* FOTO_H_ */
