#include "selection.h"

/* Possui duas "partes" (ordenadas e nao ordenadas)
 Varre o array, seleciona o menor elemento na parte nao ordenada
 move para o final da parte ordenada.

 Complexidade de tempo  O(n^2)
 Numero de comparacoes = (n^2 /2)-(n./2)
 Algoritimo in-place, complexidade de espaco O(1)
*/

void selectionSort(int arr[], int n){
    for(int i=0; i<(n-1); i++){
        int menor = i;
        for(int j=(i+1); j<n; j++){
            if(arr[menor] > arr[j]) menor = j;
        }
        int aux = arr[menor];
        arr[menor] = arr[i];
        arr[i] = aux;
    }
}