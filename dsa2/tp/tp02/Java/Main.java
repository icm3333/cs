import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

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

class Main{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		ColecaoRestaurantes db = ColecaoRestaurantes.lerCsv();
		Restaurante[] arr = db.getRestaurantes();
		
		while(sc.hasNext()){
			int idS = sc.nextInt();
			if(idS == -1) break;

			for(int i=0; i<db.getTamanho(); i++){
				if(arr[i].getId() == idS){
					System.out.println(arr[i]);
					break;
				}
			}
		}

		sc.close();
	}
}