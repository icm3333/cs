import java.util.Scanner;
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
	
	public Data parseData(String s){
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
		return dia + "/" + mes + "/" + ano;
	}
}
