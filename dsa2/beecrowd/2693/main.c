#include<stdio.h>

typedef struct{
  char nome[256];
  char dir;
  int dis;
} Aluno;

void swap(int a, int b, Aluno arr[]){
  Aluno tmp = arr[a];
  arr[a] = arr[b];
  arr[b] = tmp;
}

void bubble(Aluno arr[], int n){
  for(int i=0; i<n-1; i++){
    for(int j=0; j<n-1-i; j++){
      if((arr[j].dis > arr[j+1].dis) ||
         (arr[j].dis == arr[j+1].dis && arr[j].dir > arr[j+1].dir) ||
         (arr[j].dis == arr[j+1].dis && arr[j].dir == arr[j+1].dir && arr[j].nome[0] > arr[j+1].nome[0])){
          swap(j, j+1, arr);
         }
    }
  }
}

int main(){
  int q;
  scanf("%d", &q);
  Aluno arr[q];
  for(int i=0; i<q; i++){
    scanf("%s %c %i", &arr[i].nome, &arr[i].dir, &arr[i].dis);
  }
  bubble(arr, q);
  for(int i=0; i<q; i++){
    printf("%s\n", arr[i].nome);
  }
  return 0;
} 
