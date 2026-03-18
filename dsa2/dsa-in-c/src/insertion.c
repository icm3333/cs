#include "insertion.h"

/*
    Divide o array em uma parte ordenada e outra nao ordenada
    percorre o vetor da esquerda pra direita
    em cada passo, retira um elemento da parte nao ordenada
    e insere em seu lugar na parte ordenada
    repete ate todo vetor estar ordenado.

    Complexidade de Tempo:
    Melhor Caso: O(n) [Array ordenado]
    Pior Caso: O(n^2) [Array ordenado inversamente]

    Complexidade de Espaço:
    O(1) [In-Place]
*/

void insertionSort(int arr[], int n){
    for(int i=1; i<n; i++){
        int tmp = arr[i];
        int j= i-1;
        while((j>=0) && (arr[j] > tmp)){
            arr[j+1] = arr[j];
            j--;
        }
        arr[j+1] = tmp;
    }
}