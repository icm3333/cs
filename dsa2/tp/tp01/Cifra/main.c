#include<stdio.h>

#define BUFFER_SIZE 512
#define CHAVE 3

void cesarR(char str[], int i){
  if(str[i] == '\0') return;
  str[i] = (char)(str[i] + CHAVE);
  cesarR(str, i+1);
}

void cesar(char str[]){
  cesarR(str, 0);
}

void sanitize(char* str){
  int i;
  for(i=0; str[i] != '\0'; i++){
    if(str[i] == '\n'){
      int k = i;
      while(str[k] != '\0'){
        str[k] = str[k+1];
        k++;
      }
    i--;
    }
  }
}

int main(){
  char buffer[BUFFER_SIZE];

  while(fgets(buffer, BUFFER_SIZE, stdin) != NULL){
    if(buffer[0] == 'F' && buffer[1] == 'I' && buffer[2] == 'M') break;
    sanitize(buffer);
    cesar(buffer);
    for(int i=0; buffer[i] != '\0'; i++){
      printf("%c", buffer[i]);
    }
    printf("\n");
  }

  return 0;
}
