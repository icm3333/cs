import java.util.Scanner;

class Main{
 public static String inversaoR(String str, int i){
    if(i < 0) return "";
    return str.charAt(i) + inversaoR(str, i-1);
 }
 public static String inversao(String str){
  return inversaoR(str, str.length()-1);
 }
 public static void main(String[] args){
   Scanner sc = new Scanner(System.in);
   
    while(sc.hasNextLine()){
      String entry = sc.nextLine();
      if(entry.length() == 3 && entry.charAt(0) == 'F' && entry.charAt(1) == 'I' && entry.charAt(2) == 'M') break;
      System.out.println(inversao(entry));
    }
  
   sc.close();
 }
}
