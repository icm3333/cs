#include<stdio.h>
#include<stdlib.h>

#define BUFFER_SIZE 1024

int findEndIndex(char entry[]){
  int i;
  for(i=0; i< BUFFER_SIZE && entry[i] != '\0'; ++i);
  return i-1;
}

char* inversao(char entry[]){
  int i;
  int j = findEndIndex(entry);
  char* retorno = (char*)malloc(BUFFER_SIZE);
  if(retorno == NULL) return NULL;

  for(i=0; j>=0 ; ++i, --j){
    retorno[i] = entry[j];
  }
  retorno[i] = '\0';

  return retorno;
}

int main(){
  char entry[BUFFER_SIZE];

  while(scanf("%s", &entry) != EOF){
    if(entry[0] == 'F' && entry[1] == 'I' && entry[2] == 'M') break;

    char* retorno = inversao(entry);

    if(retorno != NULL){
      for(int i=0; retorno[i] != '\0'; i++){
        printf("%c", retorno[i]);
      }
      printf("\n");
      free(retorno);
    }
  }
}

