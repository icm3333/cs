import java.util.Scanner;
import java.util.Random;

class Alter{

    public static String alteracao(String original, Random gen){
        String saida = "";
        char oldC = (char) (Math.abs(gen.nextInt() % 26) + 'a');
        char newC = (char) (Math.abs(gen.nextInt() % 26) + 'a');
 
        for(int i=0; i<original.length(); i++){
          if(original.charAt(i) == oldC){
            saida += newC;
          }else{
            saida += original.charAt(i);
          }
        }
        return saida;
    }
  
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random gen = new Random();
        gen.setSeed(4);

        while(sc.hasNextLine()){
            String entry = sc.nextLine();
            if(entry.length() == 3 && entry.charAt(0) == 'F' && entry.charAt(1) == 'I' && entry.charAt(2) == 'M') break;
            System.out.println(alteracao(entry, gen));
        }
        sc.close();
    }
}
