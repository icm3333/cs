import java.util.Scanner;

class Cifra{

    // Criptografia de cesar com chave 3
    public static String criptografiaCesar(String original){
        int chave = 3;
        String resultado = "";

        for(int i=0; i<original.length(); i++){
            char c = original.charAt(i);

            if(c >= 32 && c <= 126){
                c = (char)(c + chave);

                if(c > 126) c -= 95;
            }
            resultado += c;
        }

        return resultado;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while(sc.hasNextLine()){
            String entry = sc.nextLine();
            if(entry.charAt(0) == 'F' && entry.charAt(1) == 'I' && entry.charAt(2) == 'M') break;
            System.out.println(criptografiaCesar(entry));
        }

        sc.close();
    }
}
