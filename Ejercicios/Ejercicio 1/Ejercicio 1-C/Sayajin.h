#include <stdio.h>

#ifndef _cadena_
#define _cadena_

typedef struct{
	char* nombre;
	unsigned long ki;
	unsigned long base;
	int fase;
}Sayajin;

typedef Sayajin* sayajin;

sayajin createSayajin();
sayajin setSayajin();
void visor(sayajin s);
void transformar(sayajin s,int t);
sayajin fusionar(sayajin s,sayajin ss);

#endif