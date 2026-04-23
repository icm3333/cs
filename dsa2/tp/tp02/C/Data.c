#include<stdio.h>

typedef struct{
	int ano, mes, dia;
} Data;

Data parse_data(char* s){
	Data d;
	sscanf("%d-%d-%d", &d.ano, &d.mes, &d.dia);
	return d;
}

void formatar_data(Data* d, char* b){
	sprintf(b, "%04d/%02d/%02d", d->dia, d->mes, d->ano);
}


