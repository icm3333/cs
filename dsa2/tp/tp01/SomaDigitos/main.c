#include<stdio.h>

int sum(char num[], int index){
  if(num[index] == '\0') return 0;
  
  return ((int)(num[index] - '0'))+ sum(num, index+1);
}

int main(){
  char entry[32];
  
  while(scanf("%s", entry) != EOF){
      if(entry[0] == 'F' && entry[1] == 'I' && entry[2] == 'M') break;
      printf("%d\n", sum(entry, 0));
  }
  return 0;
}
