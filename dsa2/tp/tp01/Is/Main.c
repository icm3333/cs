#include<stdio.h>
#include<stdlib.h>
#include<stdbool.h>

#define BUFFER_SIZE 512

char* toLowercase(char entry[]){ // FREE!!! FREE!!! // FREE!! // FREE!! FREE!!! FREE!!!!!! FREE!!!!!1!
  char* resultado = (char*)malloc(BUFFER_SIZE);
  int i;
  for(i=0; entry[i] != '\0'; i++){
      if(entry[i] >= 'A' && entry[i] <= 'Z'){
        resultado[i] = (char)(entry[i] + 32);
      }else if(entry[i] == '\n'){
        break;
      }else{
        resultado[i] = entry[i];
      }
  }
  resultado[i] = '\0';
  return resultado;
}

bool isVowel(char entry[], int i){
  if(entry[i] == '\0'){
    return true;
  }else if(entry[i] != 'a' && entry[i] != 'e' && entry[i] != 'i'  && entry[i] != 'o' && entry[i] != 'u'){
    return false;
  }else{
    return isVowel(entry, i+1);
  }
}


bool isConsonant(char entry[], int i){
  if(entry[i] == '\0'){
    return true;
  }else if(!((entry[i] >= 'a' && entry[i] <= 'z') && (entry[i] != 'a' && entry[i] != 'e' && entry[i] != 'i' && entry[i] != 'o'  && entry[i] != 'u'))){
    return false;
  }else{
    return isConsonant(entry, i+1);
  }
}

bool isInt(char entry[], int i){
  if(entry[i] == '\0'){
    return true;
  }else if(!((entry[i] >= '0' && entry[i] <= '9') ||  (entry[i] == '-' && i == 0))){
    return false;
  }else{
    return isInt(entry, i+1);
  }
}

bool isReal(char entry[], int i, int dotCount){
  if(entry[i] == '.' || entry[i] == ',') dotCount++;

  if(entry[i] == '\0'){
    if(dotCount == 1 || dotCount == 0){
      return true;
    }else{
      return false;
    }
  }else if(!((entry[i] >= '0' && entry[i] <= '9') || (entry[i] == '-' && i == 0) || (entry[i] == ',' && dotCount == 1) || (entry[i] == '.' && dotCount == 1))){
  return false;
  }else{
    return isReal(entry, i+1, dotCount);
  }
}

bool Vowel(char entry[]){
  return isVowel(entry, 0);
}

bool Consonant(char entry[]){
  return isConsonant(entry, 0);
}

bool Int(char entry[]){
  return isInt(entry, 0);
}

bool Real(char entry[]){
  return isReal(entry, 0, 0);
}
  

int main(){
  char buffer[BUFFER_SIZE];

  while(fgets(buffer, BUFFER_SIZE, stdin) != NULL){
    if(buffer[0] == 'F' && buffer[1] == 'I' && buffer[2] == 'M') break;
    char* entry = toLowercase(buffer);

    if(Vowel(entry)){
      printf("SIM ");
    }else{
      printf("NAO ");
    }

    if(Consonant(entry)){
      printf("SIM ");
    }else{
      printf("NAO ");
    }

    if(Int(entry)){
      printf("SIM ");
    }else{
      printf("NAO ");
    }

    if(Real(entry)){
      printf("SIM\n");
    }else{
      printf("NAO\n");
    }

    free(entry);
  }
  return 0;
}
