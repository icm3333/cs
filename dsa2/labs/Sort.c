// todo; format code

#include<stdio.h>
#include<stdbool.h>

typedef struct{
  int v;
  int mod;
} Intk;

void swap(Intk* arr, int j){
    Intk temp = arr[j];
    arr[j] = arr[j + 1];
    arr[j + 1] = temp;
}

bool isOdd(int a){
  if(a%2==0){
    return false;
  }else{
    return true;
  }
}

int main(){
  int N, M;

  scanf("%d %d", &N, &M);
  Intk arr[N];

  for(int i=0; i<N; i++){
    scanf("%d", &arr[i].v);
    arr[i].mod = arr[i].v % M;
  }
  
  for(int i=0; i<N-1; i++){
    for(int j=0; j<N-1-i; j++){
      if(arr[j].mod > arr[j+1].mod){
        swap(arr, j);
      }else if(arr[j].mod == arr[j+1].mod){
        if(isOdd(arr[j+1].v) && !isOdd(arr[j].v)){
          swap(arr, j);
        }else if(isOdd(arr[j+1].v) && isOdd(arr[j].v)){
          if(arr[j+1].v > arr[j].v) swap(arr, j);
        }else if(!isOdd(arr[j+1].v) && !isOdd(arr[j].v)){
          if(arr[j+1].v < arr[j].v) swap(arr, j);
        }
      }
    }
  }
  
  printf("%d %d", N, M);
  for(int i=0; i<N; i++){
    printf("%d\n", arr[i].v);  
  }
  return 0;
}
