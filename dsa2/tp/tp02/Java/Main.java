import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class Data{
	private int ano, mes, dia;
	public Data(int ano, int mes, int dia){
		this.ano = ano;
		this.mes = mes;
		this.dia = dia;
	}
	public int getAno(){
		return ano;
	}
	public int getMes(){
		return mes;
	}
	public int getDia(){
		return dia;
	}
	public void setDia(int dia){
		this.dia = dia;
	}
	public void setMes(int mes){
		this.mes = mes;
	}
	public void setAno(int ano){
		this.ano = ano;
	}
	
	public static Data parseData(String s){
		Scanner sc = new Scanner(s);
		sc.useDelimiter("-");
		int ano = sc.nextInt();
		int mes = sc.nextInt(); 
		int dia = sc.nextInt();
		sc.close();
		return (new Data(ano, mes, dia));
	}

	/**
	 Faz a comparacao entre duas datas, se a do objeto for 
	 maior retorna 1, se forem igual 0, se for menor -1
	 */
	public int compareToD(Data d2){
		//compara ano
		if(this.ano > d2.ano) return 1;
		if(this.ano < d2.ano) return -1;
		//compara mes
		if(this.mes > d2.mes) return 1;
		if(this.mes < d2.mes) return -1;
		//compara dia
		if(this.dia > d2.dia) return 1;
		if(this.dia < d2.dia) return -1;
		//se nao entrou nos ifs sao iguais
		return 0;
		
	}
	
	@Override
	public String toString(){
		return String.format("%02d/%02d/%d", dia, mes, ano);
	}
}

class Hora{
	private int hora, minuto;

	public Hora(int hora, int minuto){
		this.hora = hora;
		this.minuto = minuto;
	}

	public int getHora(){
		return this.hora;
	}
	public int getMinuto(){
		return this.minuto;
	}

	/**
	 Leitura de uma string no formato "HH:ss", e le os atributos HH e ss e joga pra variaveis int.
	 @param s - string no formato "HH:ss"
	 @return - objeto hora.
	 */
	public static Hora parseHora(String s){
		Scanner sc = new Scanner(s);
		sc.useDelimiter(":");
		int hora = sc.nextInt();
		int minuto = sc.nextInt(); 
		sc.close();
		return (new Hora(hora, minuto));
	}
	
	@Override
	public String toString(){
		return String.format("%02d:%02d", hora, minuto);
	}
}

class Restaurante{
	private int id, capacidade;
	private int faixaPreco; // 1 a 4 (1 = $),(2 = $$)...
	private String nome, cidade, tiposCozinha;
	private double avaliacao;
	private boolean isAberto;
	private Hora horarioAbertura, horarioFechamento;
	private Data dataAbertura;

	public Restaurante(String nome, String cidade){
		this.nome = nome;
		this.cidade = cidade;

		this.id = -1;
		this.capacidade = -1;
		this.faixaPreco = -1;
		this.nome = nome;
		this.tiposCozinha = null;
		this.avaliacao = -1;
		this.isAberto = false;
		this.horarioAbertura = null;
		this.horarioFechamento = null;
		this.dataAbertura = null;
	}

	public Restaurante(int id, int capacidade, int faixaPreco, 
					   String nome, String cidade, String tiposCozinha,
					   double avaliacao, boolean isAberto, 
					   Hora horarioAbertura, Hora horarioFechamento,
					   Data dataAbertura)
	{
		this.id = id;
		this.capacidade = capacidade;
		this.faixaPreco = faixaPreco;
		this.nome = nome;
		this.cidade = cidade;
		this.tiposCozinha = tiposCozinha;
		this.avaliacao = avaliacao;
		this.isAberto = isAberto;
		this.horarioAbertura = horarioAbertura;
		this.horarioFechamento = horarioFechamento;
		this.dataAbertura = dataAbertura;
	}

	public int getId(){
		return this.id;
	}

	public String getCidade(){
		return this.cidade;
	}

	public String getNome(){
		return this.nome;
	}
	public Data getDataAbertura(){
		return this.dataAbertura;
	}

	/**
	 Leitura de uma linha do CSV sendo transformada para um objeto do tipo restaurante
	 @param s - String/linha do csv contendo informacoes do restaurante, exemplo de linha csv 
	 id, nome,                       cidade,  capacidade, avaliacao,  tipos_cozinha,      faixa_preco,      horario,        data_abertura,      aberto
	 7,  Grand Bistro Collective,    Tokyo,   49        , 4.4,        japonesa;sushi,     $,                08:00-23:00,    2024-04-12,         false
	 @return - Objetro restaurante com as informacoes da string.
	 */
	public static Restaurante parseRestaurante(String s){
		Restaurante r;
		Scanner sc = new Scanner(s);
		sc.useDelimiter(",\\s*"); // \\s* serve para nao cortar espacos, assim o next nao ignora cidades/nomes com espaco como por exemplo Belo Horizonte
		
		int id = sc.nextInt();
		String nome = sc.next();
		String cidade = sc.next();
		int capacidade = sc.nextInt();
		double avaliacao = sc.nextDouble();
		String tiposCozinha = sc.next();

		String faixaPrecoS = sc.next();
		int faixaPreco = faixaPrecoS.length();

		String horario = sc.next();
		String horaAberturaS = "", horaFechamentoS = "";
		boolean swap = false;
		for(int i=0; i<horario.length(); i++){
			char c = horario.charAt(i);
			if(c == '-'){
				swap = true;
			}else if(!swap){
				horaAberturaS += c;
			}else{
				horaFechamentoS += c;
			}
		}
		Hora horaAbertura = Hora.parseHora(horaAberturaS);
		Hora horaFechamento = Hora.parseHora(horaFechamentoS);

		String dataAberturaS = sc.next();
		Data dataAbertura = Data.parseData(dataAberturaS);

		boolean isAberto = sc.nextBoolean();

		sc.close();

		return new Restaurante(id, capacidade, faixaPreco, nome, cidade, tiposCozinha, avaliacao, isAberto, horaAbertura, horaFechamento, dataAbertura);
	}

	/**
	 formata o tipoCozinha para ser exibida como string em toString.
	 @param s - string, originalmente parseada como "francesa;bistro"
	 @return - string, transformada em [francesa, bistro]
	 */
	public static String formatarCozinha(String s){
		String retorno = "[";
		for(int i=0; i<s.length(); i++){
			char c = s.charAt(i);
			if((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ' || c == '-'){
				retorno += c;
			}else if(c == ';'){
				retorno += ",";
			}
		}
		retorno += "]";
		return retorno;
	}

	/**
	 transforma um int faixaPreco em uma string para ser exibida no programa.
	 @param x - 1 >= x <= 4
	 @return - string, com a quantidade de $ equivalente a x; x = 1 = $.
	 */
	public static String formatarFaixaPreco(int x){
		String r = "";
		for(int i=0; i<x; i++){
			r += "$";
		}
		return r;
	}

	@Override
	public String toString(){
		return "[" + id + " ## " + nome + " ## " + cidade + " ## " + capacidade + " ## " + avaliacao + " ## " +
				formatarCozinha(tiposCozinha) + " ## " + formatarFaixaPreco(faixaPreco) + " ## " + 
				String.format("%02d:%02d", horarioAbertura.getHora(), horarioAbertura.getMinuto()) + "-" + horarioFechamento + " ## " + dataAbertura + " ## " + isAberto + "]";
	}
}

class ColecaoRestaurantes{
	private int tamanho;
	private Restaurante[] restaurantes;

	public ColecaoRestaurantes(int capacidade) {
        this.restaurantes = new Restaurante[capacidade];
        this.tamanho = 0;
    }

	public int getTamanho(){
		return this.tamanho;
	}
	public Restaurante[] getRestaurantes(){
		return this.restaurantes;
	}

	/**
	 le o arquivo csv, cria os restaurantes e configura a colecao
	 @param path - endereco do arquivo restaurantes.csv (tmp/restaurantes.csv)
	 */
	public void lerCsv(String path){
		try {
			File file = new File(path);
			Scanner sc = new Scanner(file);
			sc.nextLine(); 

			while(sc.hasNextLine() && this.tamanho < this.restaurantes.length){
				String s = sc.nextLine();
				Restaurante r = Restaurante.parseRestaurante(s);

				if(r != null){
					this.restaurantes[this.tamanho] = r;
					this.tamanho++;
				}
			}
			sc.close();
		}catch(FileNotFoundException e){}

	}
	/**
	 le o dataset do arquivo csv e retorna a colecao com os restaurantes
	 @return - objeto ColecaoRestaurante
	 */
	public static ColecaoRestaurantes lerCsv(){
		ColecaoRestaurantes a = new ColecaoRestaurantes(500); // csv tem 500 restaurantes
		String path = "/tmp/restaurantes.csv";
		//String path = "restaurantes.csv";
		a.lerCsv(path);
		return a;
	}
}

class Ordenacao{
	private long tempoExecucao;
	private String matricula;
	private int comp, moves;
	private String algoritimoUtilizado;
	
	public Ordenacao(){
		this.comp = 0;
		this.moves = 0;
		this.matricula = "892486";
	}
	public Ordenacao(String algoritimoUtilizado){
		this.comp = 0;
		this.moves = 0;
		this.matricula = "892486";
		this.algoritimoUtilizado = algoritimoUtilizado;
	}
	/*
	 compareTo - 0 Se for igual // -1 se a segunda string for menor // 1 se a string for maior
	 */
	/**
	 realiza insercao por insercao utilizando o atributo Cidade como chave
	 */
	public void insercao(Restaurante[] restaurantes, int tamanho){
		long inicio = System.currentTimeMillis();
		for(int i=1; i<tamanho; i++){
			Restaurante tmp = restaurantes[i]; this.moves++;
			int j=i-1;
			while((j>=0) && (restaurantes[j].getCidade().compareTo(tmp.getCidade())>0)){
				this.comp++;
				restaurantes[j+1] = restaurantes[j]; this.moves++;
				j--;
			}
			restaurantes[j+1] = tmp; this.moves++;
		}
		long fim = System.currentTimeMillis();
		this.tempoExecucao = fim - inicio;
		this.algoritimoUtilizado = "insercao";
	}

	public void mergesort(Restaurante[] a, int n) {
	  long inicio = System.currentTimeMillis();
	  this.algoritimoUtilizado = "mergesort";
      mergesort(a, 0, n - 1);
	  long fim = System.currentTimeMillis();
	  this.tempoExecucao = fim - inicio;
    }

	private void mergesort(Restaurante[] a, int esq, int dir) {
      if (esq < dir){
         int meio = (esq + dir) / 2;
         mergesort(a, esq, meio);
         mergesort(a, meio + 1, dir);
         intercalar(a, esq, meio, dir);
      }
   }

   public void intercalar(Restaurante[] a, int esq, int meio, int dir){
      int n1, n2, i, j, k;

	  //Definir tamanho dos dois subarrays
      n1 = meio-esq+1;
      n2 = dir - meio;

      Restaurante[] a1 = new Restaurante[n1+1];
      Restaurante[] a2 = new Restaurante[n2+1];

	  //Inicializar primeiro subarray
      for(i = 0; i < n1; i++){
         a1[i] = a[esq+i];
		 this.moves++;
      }

	  //Inicializar segundo subarray
      for(j = 0; j < n2; j++){
         a2[j] = a[meio+j+1];
		 this.moves++;
      }

	  //Sentinela no final dos dois arrays
	  Restaurante sentinela = new Restaurante("{{{{}}}}", "{{{{}}}}"); // { valor ascii maior que todos os numeros/letras. igual a 'z'+1;
	  a1[i] = a2[j] = sentinela;

	  //Intercalacao propriamente dita
      for(i = j = 0, k = esq; k <= dir; k++){
		 this.comp++;
		 int resultadoComparacao = a1[i].getCidade().compareTo(a2[j].getCidade());

		 if(resultadoComparacao < 0){ // a1.cidade e menor
			a[k] = a1[i++];
		 }else if(resultadoComparacao == 0){ //empate, verifica pelo nome
			this.comp++;
			if(a1[i].getNome().compareTo(a2[j].getNome()) <= 0){
				a[k] = a1[i++];
			}else{
				a[k] = a2[j++];
			}
		 }else{ // a1.cidade e maior
			a[k] = a2[j++];
		 }
		 this.moves++;
	  }	
   }

	private void swap(Restaurante[] array, int i, int j) {
        Restaurante temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        this.moves += 3;
    }

   public void heapsort(Restaurante[] a, int n){
	  long inicio = System.currentTimeMillis();
	  this.algoritimoUtilizado = "heapsort";

	  //Alterar o vetor ignorando a posicao zero
	  Restaurante[] tmp = new Restaurante[n + 1];
	  for (int i = 0; i < n; i++) {
            tmp[i+1] = a[i];
            this.moves++;
       }

	   //Contrucao do heap
	   for(int tamHeap = 2; tamHeap <= n; tamHeap++){
         construir(tmp, tamHeap);
		}

		//Ordenacao propriamente dita
		int tamHeap = n;
		while (tamHeap > 1) {
            swap(tmp, 1, tamHeap--);
            reconstruir(tmp, tamHeap);
        }

		//Coloca os dados de volta no vetor a
		for(int i = 0; i < n; i++){
            a[i] = tmp[i+1];
            this.moves++;
        }
      
	  long fim = System.currentTimeMillis();
	  this.tempoExecucao = fim - inicio;
   }

	private int comparar(Restaurante r, Restaurante r2){

		this.comp++;
		int comparacao = r.getDataAbertura().compareToD(r2.getDataAbertura());
		if(comparacao == 0){
			this.comp++;
			return r.getNome().compareTo(r2.getNome());
		}else{
			return comparacao;
		}
	}

   private void construir(Restaurante[] tmp, int tamHeap){
      for(int i = tamHeap; i > 1 && comparar(tmp[i], tmp[i/2]) > 0; i /= 2){
         swap(tmp, i, i/2);
      }
   }
   
   private void reconstruir(Restaurante[] tmp, int tamHeap){
      int i = 1;
      while(i <= (tamHeap/2)){
         int filho = getMaiorFilho(tmp, i, tamHeap);
         if(comparar(tmp[i], tmp[filho]) < 0){
            swap(tmp, i, filho);
            i = filho;
         }else{
            i = tamHeap;
         }
      }
   }
   public int getMaiorFilho(Restaurante[] tmp, int i, int tamHeap){
      int filho;
      if (2*i == tamHeap || comparar(tmp[2*i],tmp[2*i +1])>0){
         filho = 2*i;
      } else {
         filho = 2*i + 1;
      }
      return filho;
   }

	@Override
	public String toString(){
		return this.matricula + "\t" + this.comp + "\t" + this.moves + "\t" + this.tempoExecucao +" ms";
	}

	public void gerarTxt(){
	String arq = this.matricula + "_" + this.algoritimoUtilizado + ".txt";

		try (BufferedWriter saida = new BufferedWriter(new FileWriter(arq))) {
        saida.write(this.toString());
        saida.newLine();
    } catch(IOException e) {
         
    }
	}
}


class Main{

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		ColecaoRestaurantes db = ColecaoRestaurantes.lerCsv();
		Restaurante[] arr = db.getRestaurantes();
		Restaurante[] array_usuario = new Restaurante[500];
		int n = 0; 
		
		while(sc.hasNext()){
			int idS = sc.nextInt();
			if(idS == -1) break;

			for(int i=0; i<db.getTamanho(); i++){
				if(arr[i].getId() == idS){
					array_usuario[n++] = arr[i];
					break;
				}
			}
		}

		Ordenacao a = new Ordenacao();
		a.heapsort(array_usuario, n);

		for(int i=0; i<n; i++){
			System.out.println(array_usuario[i]);
		}

		a.gerarTxt();
		sc.close();
	}
}

/*  Codigo da pesquisa sequencial


sc.nextLine(); // limpa quebra de linha do buffer
//variaveis para o arquivo txt
int comp = 0;
		long tempo = 0l;
		while(sc.hasNextLine()){
			String entry = sc.nextLine();
			if(entry.length() == 3 && entry.charAt(0) == 'F'  && entry.charAt(1) == 'I' && entry.charAt(2) == 'M')  break;

			
			// Pesquisa sequencial
			long inicio = System.currentTimeMillis(); 
			boolean encontrou = false;
			for(int i=0; i<n; i++){
				comp++;
				if(array_usuario[i].getNome().compareTo(entry) == 0){
					encontrou = true;
					break;
				} 
			}
			long fim = System.currentTimeMillis();
			if(encontrou){
				System.out.println("SIM");
			}else{
				System.out.println("NAO");
			}
			tempo += (fim-inicio);
		}

		String arq = "892486_sequencial.txt";
		try (BufferedWriter saida = new BufferedWriter(new FileWriter(arq))) {
        	saida.write("892486\t" + comp + "\t" + tempo);
        	saida.newLine();
    	} catch(IOException e) {
         
    	}


*/