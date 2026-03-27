import java.util.Scanner;
// valida se 
// tamanho >= 8
//      -> 1 uppercase
//      -> 1 lowercase
//      -> caractere especial
class Main{
  public static boolean checker(String pw){
    if(pw.length() < 8) return false;
    boolean hasUpper = false;
    boolean hasLower = false;
    boolean hasSpecial = false;
    boolean hasNumber = false;

    for(int i=0; i<pw.length(); i++){
      if(pw.charAt(i) >= 'A' && pw.charAt(i)<= 'Z'){
        hasUpper = true;
      }else if(pw.charAt(i) >= 'a' && pw.charAt(i) <= 'z'){
        hasLower = true;
      }else if(pw.charAt(i) >= '0' && pw.charAt(i) <= '9'){
        hasNumber = true;
      }else if((pw.charAt(i) >= '!' && pw.charAt(i) <= '/') || (pw.charAt(i) >= ':' && pw.charAt(i) <= '@') ||  (pw.charAt(i) >= '[' && pw.charAt(i) <= '_') || (pw.charAt(i) >= '{' && pw.charAt(i) <= '}')){
        hasSpecial = true;
      }
    }
    if(hasUpper && hasLower && hasNumber && hasSpecial){
      return true;
    }else{
      return false;
    }
  }
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    while(sc.hasNextLine()){
      String entry = sc.nextLine();
      if(entry.length() == 3  && entry.charAt(0) == 'F' && entry.charAt(1) == 'I'  && entry.charAt(2) == 'M') break;
      if(checker(entry)){
        System.out.println("SIM");
      }else{
        System.out.println("NAO");
      }
    }
    sc.close();
  }
}
