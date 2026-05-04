#ifndef MATRIX_H
#define MATRIX_H

typedef struct Node {
    int value;
    struct Node* right;
    struct Node* left;
    struct Node* down;
    struct Node* up;
} Node;

typedef struct {
    Node* start;
    int dimension;
} Matrix;

Node* create_node(int x);
Matrix* create_matrix(int dimension);
void print_matrix(Matrix* a);

#endif