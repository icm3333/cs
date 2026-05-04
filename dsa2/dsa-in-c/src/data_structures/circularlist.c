#include "circularlist.h"

List a;

void startList(int size){
  a.array = malloc(sizeof(int)*(size+1));
  a.first = 0;
  a.last = 0;
  a.size = size+1;
}

void insert(int x){
  if(((a.last+1)%a.size) == a.first) return; //List is full.
  
  a.array[a.last] = x;
  a.last = (a.last + 1) % a.size;
}

int remove(){
  if(a.first == a.last) return -1; //List is empty

  int aux = a.array[a.first];
  a.first = (a.first + 1) % a.size;
  return aux;
} 

