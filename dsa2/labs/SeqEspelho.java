import java.util.Scanner;

class SeqEspelho{
    public static void  main(String[] args){
      Scanner sc = new Scanner(System.in);  
      int n1, n2;

      n1 = sc.nextInt();
      n2 = sc.nextInt();
      
      for(int i=n1; i<=n2; i++){
          System.out.print(i);
      }
      for(int i=n2; i>=n1; i--){
          System.out.print(i);
      }

    sc.close();
    }

}
