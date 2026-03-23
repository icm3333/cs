#include<stdio.h>

int main(){
  char s1[128], s2[128];
  char output[256];
  int i =0, j=0, k=0;

  scanf("%s  %s", s1, s2);

  while(s1[j]  !=  '\0'&& s2[k] != '\0'){
    output[i] = s1[j];
    i++; j++;
    output[i] = s2[k];
    i++; k++;
  }
  
  while(s1[j] != '\0'){
    output[i] = s1[j];
    i++; j++;
  }

  while(s2[k] != '\0'){
    output[i] = s2[k];
    i++; k++;
  }

  output[i] = '\0';

  printf("%s", output);

  return 0;
}
