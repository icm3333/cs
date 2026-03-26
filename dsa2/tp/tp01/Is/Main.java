import java.util.Scanner;

class Main{
  public static String toLowercase(String entry){
    String resultado = "";
    for(int i=0; i<entry.length(); i++){
      if(entry.charAt(i) >= 'A' && entry.charAt(i) <= 'Z'){
        resultado+= (char)(entry.charAt(i) + 32);
      }else{
        resultado+= entry.charAt(i);
      }
    }
    return resultado;
  }

  public static String isVowel(String entry){
    for(int i=0; i<entry.length(); i++){
        if(entry.charAt(i) != 'a' && entry.charAt(i) != 'e' && entry.charAt(i) != 'i' && entry.charAt(i) != 'o' && entry.charAt(i) != 'u') return "NAO";
    }
    return "SIM";
  }

  public static String isConsonant(String entry){
    for(int i=0; i<entry.length(); i++){
      if(!((entry.charAt(i) >= 'a' && entry.charAt(i) <= 'z') && (entry.charAt(i) != 'a' && entry.charAt(i) != 'e' && entry.charAt(i) != 'i' && entry.charAt(i) != 'o' && entry.charAt(i) != 'u'))){
        return "NAO";
      }
    }
    return "SIM";
  }

  public static String isInt(String entry){
    for(int i=0; i<entry.length(); i++){
      if(!((entry.charAt(i) >= '0' && entry.charAt(i) <= '9') || (entry.charAt(i) == '-' && i == 0))) return "NAO";
    }
    return "SIM";
  }

  public static String isReal(String entry){
    int dotCount = 0;
    for(int i=0; i<entry.length(); i++){
      if(entry.charAt(i) == '.' || entry.charAt(i) == ',') dotCount++;
      if(!((entry.charAt(i) >= '0' && entry.charAt(i) <= '9') || (entry.charAt(i) == '-' && i == 0) || (entry.charAt(i) == ',' && dotCount == 1) || (entry.charAt(i) == '.' && dotCount == 1))) return "NAO";
    }
    if(dotCount == 1 || dotCount == 0){
      return "SIM";
    }else{
      return "NAO";
    }
  } 

  public static void main(String[] args){
      Scanner sc = new Scanner(System.in);

      while(sc.hasNextLine()){
        String entry = sc.nextLine();
        if(entry.length() == 3 && entry.charAt(0) == 'F' && entry.charAt(1) == 'I' && entry.charAt(2) == 'M') break;
        entry = toLowercase(entry);
        System.out.println(isVowel(entry) + " " + isConsonant(entry) + " " + isInt(entry) + " " + isReal(entry));
      }
      
      sc.close();
  } 
}
