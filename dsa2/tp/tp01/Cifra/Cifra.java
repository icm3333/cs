import java.util.Locale;
import java.util.Scanner;

class Cifra{

    // Criptografia de cesar com chave 3
    public static String criptografiaCesar(String original){
        int chave = 3;
        String resultado = "";

        for(int i=0; i<original.length(); i++){
            char c = original.charAt(i);

            if(c != ' '){
                resultado = resultado + (char)(c+chave);
            }else{
                resultado = resultado + ' ';
            }
        }

        return resultado;
    }
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            System.out.println(criptografiaCesar(sc.nextLine()));
        }

        sc.close();
    }
}