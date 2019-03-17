#include <stdio.h>
#include <stdlib.h>
#include <ctype.h>
#include <string.h>
#include "Sayajin.h"

void main(){
	printf("Que pedo con esto\n");
	sayajin s;
	printf("Declaracion\n");
	s = createSayajin();
	printf("Creacion\n");
	s = setSayajin(s,1);
	printf("setSayajin\n");
//	visor(s[0]);
}