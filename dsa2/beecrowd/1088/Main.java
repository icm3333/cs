import java.util.Scanner;

class Main{
  static int[] arr;

  public static void swap(int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
  
  public static int bubble(){
    int n = arr.length;
    int move = 0;

    for(int i=0; i<n-1; i++){
      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          swap(j, j+1);
          move++;
        }
      }
    }
    return move;
  }


  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      while(sc.hasNext()){
        int size = sc.nextInt();

        if(size != 0){
          arr = new int[size];

          for(int i=0; i<size; i++){
            arr[i] = sc.nextInt();
          }
          int moves = bubble();

          if(moves %2 == 0){
            System.out.println("Carlos");
          }else{
            System.out.println("Marcelo");
          }
        }
      }
      sc.close();
  } 
}
