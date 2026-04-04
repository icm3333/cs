#include<stdio.h>
#include<stdbool.h>

int getSize(char* arr){
  int size;
  for(size = 0; arr[size] != '\0'; ++size);
  return size;
}

bool anagrama(char str[], char str2[]){
  int size = getSize(str);
  int size2= getSize(str2);
  if(size != size2) return false;

  for(int i=0; i < size; ++i){
    if(str[i] != str2[i]){
      return false;
    }
  }
  return true;
}

void sort(char* arr){
  int size = getSize(arr);

  for(int i=0; i<size-1; i++){
    for(int j=0; j<size-i-1; j++){
      if(arr[j] > arr[j+1]){
       char tmp = arr[j];
       arr[j] = arr[j+1];
       arr[j+1] = tmp;
      }
    }
  }
}

void toLowerCase(char* arr){
  int size = getSize(arr);

  for(int i=0; i<size; i++){
    if(arr[i] >= 'A' && arr[i] <= 'Z'){
      arr[i] = (char)(arr[i] + 32);
    }
  }
}

int main(){
    char s1[128];
    char s2[128];

    while(scanf("%s %s", s1, s2) != EOF){
      if(s1[0] == 'F' && s1[1] == 'I'  && s1 [2] == 'M') break;

      toLowerCase(s1); sort(s1);
      toLowerCase(s2); sort(s2);

      if(anagrama(s1, s2)){
        printf("SIM\n");
      }else{
        printf("NAO\n");
      }
    }
}
