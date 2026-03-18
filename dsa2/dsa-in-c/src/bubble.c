#include "bubble.h"

/*
    E realizado comparacoes entre elementos que estao
    lado a lado, se o da esquerda for maior, trocam de lugar

    O(n^2) Comparacoes no pior caso e melhor caso (pode ter complexidade no melhor caso
                                                    de O(N) com a adicao de flag booleana
                                                    para verificar se o array ja esta ordenado
                                                    consideirando o numero de swaps em uma das
                                                    iteracoes do laco principal)

    Complexidade de Espaço:
    O(1) [In-Place]

*/

void bubbleSort(int arr[], int n){
    for(int i=0; i<n-1; i++){
        for(int j=0; j<n-1-i; j++){
            if(arr[j] > arr[j+1]){
                int tmp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = tmp;
            }
        }
    }
}
