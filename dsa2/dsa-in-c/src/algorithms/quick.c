#include "quick.h"

void quicksort(int *array, int n){
  quick(array, 0, n-1);
}

void quick(int *array,int left, int right){
  int i = left;
  int j = right;
  int pivot = array[(i+j)/2];

  while(i <= j){
    while(array[i] < pivot) i++;
    while(array[j] > pivot) j--;
    if(i <= j){
      swap(i,j);
      i++;
      j--;
    }
  }
    if(left < j) quick(array, left, j);
    if(i < right)  quick(array, i, right);
}
