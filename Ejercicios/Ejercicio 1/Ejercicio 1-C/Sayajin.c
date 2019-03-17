#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "Sayajin.h"

sayajin createSayajin(){
	sayajin s;
	int i;

	s = (sayajin)malloc(sizeof(Sayajin)*3);

	if(s=NULL){
		printf("Memoria insuficiente\n");
		exit(1);
	}

	for(i = 0; i < 3; ++i){
		s[i].nombre = (char*)malloc(sizeof(char));
		s[i].ki = 0;
		s[i].base = 0;
		s[i].fase = 0;
	}

	return s;
}

//	char* nombre;
//	unsigned long ki;
//	unsigned long base;
//	int fase;

sayajin setSayajin(sayajin s,int id){
	printf("Generando sayajines....\n");
	switch(id){
		case 1: strcpy(s[id-1].nombre,"Goku");
				s[id-1].ki = 5000;
				s[id-1].base = 5000;
				s[id-1].fase = 0;
		break;
		case 2: strcpy(s[id-1].nombre,"Vegeta");
				s[id-1].ki = 4800;
				s[id-1].base = 4800;
				s[id-1].fase = 0;
		break;
		case 3: strcpy(s[id-1].nombre,"Trunks");
				s[id-1].ki = 4000;
				s[id-1].base = 4000;
				s[id-1].fase = 0;
		break;
	}

	return s;
}

void visor(sayajin s){
	printf("\nEl poder de pelea de %s es de... %lu\n",s->nombre,s->ki);
}

void transformar(sayajin s,int fase){
	s->fase = fase;

	if(fase == 0){ s->ki = s->base; }
	if(fase == 1){ s->ki = s->base * 50; }
	if(fase == 2){ s->ki = s->base * 100; }
	if(fase == 3){ s->ki = s->base * 400; }
	if(fase == 4){ s->ki = s->base * 4000; }
}

sayajin fusionar(sayajin s,sayajin ss){
	sayajin nvo;

	return nvo;
}