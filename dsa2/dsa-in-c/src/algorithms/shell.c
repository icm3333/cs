#include "insertion.h"
/*
    Subdivide o array em outras pequenas partes separadas, por exemplo divide em quatro,
    Com essa divisao, os arrays se intercalam, com o primeiro "subarray" tendo elementos no
    index 0, 4, 8 etc...
*/

void shell(){
  int h = 1;

  do{
    h = (h*3)+1; // Formula definida por Knuth, "melhor" eficiencia
  }while(h<n);

  do{
    h /= 3;
    for(int key=0; key<h; key++){
      insertionS(key, h);
    } 
  }while(h != 1);
}

void insertionS(int key, int h){
  for(int i=(h+key); i<n; i+=h){
    int tmp = array[i];
    int j = i-h;
    while((j>=0) && (array[j] > tmp)){
      array[j+h] = array[j];
      j -= h;
    }
    array[j+h] = tmp;
  }
}
