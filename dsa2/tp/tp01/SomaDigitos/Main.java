import java.util.Scanner;

class Main{
  public static int sum(String num, int index){
    if(index == num.length()) return 0;

    return ((int)(num.charAt(index) - '0')) + sum(num, index+1);
  }

  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
    String entry;
    
    while(sc.hasNextLine()){
      entry = sc.nextLine();
      if(entry.equals("FIM")) break;
      System.out.println(sum(entry, 0));
    }
    
  }
}
