#ifndef CIRCULARLIST_H
#define CIRCULARLIST_H

typedef struct{
  int* array;
  int first, last;
  int size;
} List;

void startList(int size);
void insert(int x);
int remove();

#endif