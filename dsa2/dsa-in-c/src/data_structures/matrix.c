#include "matrix.h"

Node* create_node(int x){
    Node* new = (Node*) malloc(sizeof(Node));
    new->value = x;
    new->right = new->left = new->down = new->up = NULL;
    return new;
}

// Creates an X by X matrix
Matrix* create_matrix(int dimension){
    Matrix* new = (Matrix*) malloc(sizeof(Matrix));
    new->dimension = dimension;

    int index = 0;
    new->start = create_node(index++);
    Node* tmp = new->start;

    // creates the first row of the matrix
    for(int i=1; i<dimension; i++){
        Node* newNode = create_node(index++);
        tmp->right = newNode;
        newNode->left = tmp;
        tmp = newNode;
    }
    // creates the rest of the matrix
    Node* upperrow = new->start;
    for(int i=1; i<dimension; i++){
        Node* tmp_upperrow = upperrow;

        //creates the first node of the new line
        tmp = create_node(index++);
        tmp->up = upperrow;
        upperrow->down = tmp;
        upperrow = upperrow->right;
        for(int j=1; j<dimension; j++){
            Node* newest = create_node(index++);
            newest->left = tmp;
            tmp->right = newest;
            newest->up = upperrow;
            upperrow->down = newest;

            tmp = newest;
            upperrow = upperrow->right;
        }
        upperrow = tmp_upperrow->down;
    }

    return new;
}

void print_matrix(Matrix* a){
    for(Node* i = a->start; i != NULL; i = i->down){
        for(Node* j=i; j != NULL; j = j->right){
            if(j->right == NULL){
            printf("%d", j->value);
            }else{
                printf("%d <-> ", j->value);
            }
        }
        if(i->down != NULL){
            // just to be pretty
            // when reaches numbers with 2 digits looks very ugly/not aligned
            // too lazy to fix
            printf("\n");
            for(int i=0; i<a->dimension; i++){
                printf("^     ");
            }
            printf("\n");
            for(int i=0; i<a->dimension; i++){
                printf("|     ");
            }
            printf("\n");
            for(int i=0; i<a->dimension; i++){
                printf("v     ");
            }
            printf("\n");
        }
    }
}



