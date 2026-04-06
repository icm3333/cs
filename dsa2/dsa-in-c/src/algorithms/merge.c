void mergesort(){
  merge(0, n-1);
}

void merge(int left, int right){
  if(left < right){
    int mid = (left+right)/2;
    merge(left, mid);
    merge(mid+1, right);
    inter(left, mid, right);
  }
}

void inter(int left, int mid, int right){
  int nLeft = (mid+1) - left;
  int nRight= right - mid;

  int leftArr[nLeft+1];
  int rightArr[nRight +1];

  int iLeft, iRight, i;

  for(iLeft = 0; iLeft < nLeft; iLeft++){
    leftArr[iLeft] = array[left+iLeft];
  }

  for(iRight = 0; iRight < nRight; iRight++){
    rightArr[iRight] = array[(mid+1) + iRight];
  }

  leftArr[nLeft] = rightArr[nRight] = 0x7FFFFFFF;

  for(iLeft = iRight = 0, i = left; i<=right; i++){
    if(leftArr[iLeft] <= rightArr[iRight]){
      array[i] = leftArr[iLeft];
      iLeft++;
    }else{
      array[i] = rightArr[iRight];
      iRight++;
    }
  }
}
