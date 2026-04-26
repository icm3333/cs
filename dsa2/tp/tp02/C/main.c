#include<stdio.h>
#include<stdbool.h>
#include<stdlib.h>
#include<string.h>
#include<time.h>

#define CSV_LINES 500

typedef struct{
	int ano, mes, dia;
} Data;

typedef struct{
	int hora, minuto;
} Hora;

typedef struct{
    char* nome;                // 8b
    char* cidade;              // 8b
    char** tipos_cozinha;      // 8b
    double avaliacao;          // 8b
	Hora horario_abertura;     // 8b
	Hora horario_fechamento;   // 8b
	int id;                    // 4b
    int capacidade;            // 4b
    int n_tipos_cozinha;       // 4b
    int faixa_preco;           // 4b
	Data data_abertura;        // 12b
	bool aberto;               // 1b
} Restaurante;

typedef struct{
	Restaurante** restaurantes;
	int tamanho;
} Colecao_Restaurantes;

// Data functions

/**
 Recebe uma string contendo uma data estilo DD-MM-AAAA e transforma em uma 
 estrutura do tipo Data.
 */

Data parse_data(char* s){
	Data d;
	sscanf(s, "%d-%d-%d", &d.ano, &d.mes, &d.dia);
	return d;
}

/**
 Recebe uma variavel do tipo Data, e transforma em uma string estilo DD/MM/AAAA
 */

void formatar_data(Data* d, char* b){
	sprintf(b, "%02d/%02d/%04d", d->dia, d->mes, d->ano);
}


// Hora functions

/**
 Leitura de uma string no formato "HH :ss" e transforma em uma
 estrutura do tipo Hora
 */
Hora parse_hora(char* s){
	Hora h;
	sscanf(s, "%d:%d", &h.hora, &h.minuto);
	return h;
}

void formatar_hora(Hora* h, char* b){
	sprintf(b, "%02d:%02d", h->hora, h->minuto);
}

// Funcoes auxiliares

/**
 Recebe uma string e retorna o seu tamanho em um inteiro
 */
int tamanho_string(char* s){
	int t = 0;
	for(; s[t]!= '\0'; t++);
	return t;	
}

/**
 Recebe uma string e retorna a quantidade de tipos culinarios.
 */
int get_n_cozinhas(char* s){
	int c = 1;
	for(int i=0; s[i] != '\0'; i++){
		if(s[i] == ';') c++;
	}
	return c;
}
/**
 Recebe uma string contendo o preco em cifroes, e retorna quantidade em inteiro.
 */
int parse_preco(char* s){
	int a=0;
	for(int i=0; s[i] != '\0'; a++, i++);
	return a;
}

// verifica o primeiro char, se for t (da string true) retorna true
// caso contrario retorna false.
bool parse_boolean(char* s){
	if(s[0] == 't'){
		return true;
	}
	return false;
}

// strcpy copia original para nova;
void copiar_string(char* original, char* nova){
	int i=0;
	while(original[i] != '\0'){
		nova[i] = original[i];
		i++;
	}
	nova[i] = '\0';
}


//recebe a string tipos original, separa os tipos de culinaria em um array de strings;

char** parse_tipos_cozinha(char* s, int qtd){
	char** arr = (char**) malloc(qtd*sizeof(char*));
	if(arr == NULL) return NULL;

	int atual_inicio = 0;
	int arr_index = 0;
	int tamanho_s = tamanho_string(s);

	for(int i=0; i<=tamanho_s; i++){
		if(s[i] == ';' || s[i] == '\0'){
			int tamanho_atual = i - atual_inicio;
			arr[arr_index] = (char*) malloc(tamanho_atual + 1);

			for(int j=0; j<=tamanho_atual;  j++){
				arr[arr_index][j] = s[atual_inicio + j];
				if(j == tamanho_atual) arr[arr_index][j] = '\0';
			}
			atual_inicio = i+1;
			arr_index++;
		}
	}
	return arr;
}


// Restaurante functions

/**
 Leitura de uma linha do CSV sendo transformada para uma estrutura
 do tipo Restaurante
*/

// id,nome,cidade,capacidade,avaliacao,tipos_cozinha,faixa_preco,horario,data_abertura,aberto
// 7,Grand Bistro Collective,Tokyo,49,4.4,japonesa;sushi,$,08:00-23:00,2024-04-12,false

Restaurante* parse_restaurante(char* s){
	Restaurante* r = (Restaurante*) malloc(sizeof(Restaurante));
	if(r == NULL) return NULL;

	// buffers
	char nome[256];
	char cidade[256];
	char tipos[256];
	char preco[8];
	char data[16];
	char boolean[16];

	// [^,] serve para ler ate o demarcador escolhido, nesse caso a virgula.
	sscanf(s, "%d,%255[^,],%255[^,],%d,%lf,%255[^,],%7[^,],%d:%d-%d:%d,%15[^,],%s",
		 &r->id, nome, cidade, &r->capacidade, &r->avaliacao, tipos, preco, 
		 &r->horario_abertura.hora, &r->horario_abertura.minuto, 
		 &r->horario_fechamento.hora, &r->horario_fechamento.minuto, 
		 data, boolean);

	r->nome = (char*) malloc(tamanho_string(nome) + 1);
	copiar_string(nome, r->nome);

	r->cidade = (char*) malloc(tamanho_string(cidade) + 1);
	copiar_string(cidade, r->cidade);

	r->n_tipos_cozinha = get_n_cozinhas(tipos);
	r->tipos_cozinha = parse_tipos_cozinha(tipos, r->n_tipos_cozinha);
	
	r->faixa_preco = parse_preco(preco);
	r->data_abertura = parse_data(data);
	r->aberto = parse_boolean(boolean);

	return r;
}

// [7 ## Grand Bistro Collective ## Tokyo ## 49 ## 4.4 ## [japonesa,sushi] ## $ ## 08:00-23:00 ## 12/04/2024 ## false]
void formatar_restaurante(Restaurante* r, char* b){
	char *boolean, *preco;
	char tipos[128];

	// transforma boolean em uma string
	if(r->aberto){
		boolean = "true";
	}else{
		boolean = "false";
	}

	// transforma preco de int para $
	switch(r->faixa_preco){
		case 1: preco = "$"; break;
		case 2: preco = "$$"; break;
		case 3: preco = "$$$"; break;
		case 4: preco = "$$$$"; break;
	}

	// transforma tipos de culinaria em uma string como [japonesa,sushi]
	int tamanho_tipos = 1;
	tipos[0] = '[';
	for(int i=0; i< r->n_tipos_cozinha; i++){
		for(int j=0; r->tipos_cozinha[i][j] != '\0'; j++){
			tipos[tamanho_tipos] = r->tipos_cozinha[i][j];
			tamanho_tipos++;
		}
		if(i+1 != r->n_tipos_cozinha){
		tipos[tamanho_tipos] = ',';
		tamanho_tipos++;
		}
	}
	tipos[tamanho_tipos] = ']';
	tipos[++tamanho_tipos] = '\0';

	
	sprintf(b, "[%d ## %s ## %s ## %d ## %.1lf ## %s ## %s ## %02d:%02d-%02d:%02d ## %02d/%02d/%04d ## %s]", r->id, r->nome, r->cidade, r->capacidade, r->avaliacao, 
				tipos, preco, r->horario_abertura.hora, r->horario_abertura.minuto, r->horario_fechamento.hora, r->horario_fechamento.minuto, 
				r->data_abertura.dia, r->data_abertura.mes, r->data_abertura.ano, boolean);
}


// Colecao functions

void ler_csv_colecao(Colecao_Restaurantes* c, char* path){
	char buffer[256];

	FILE* csv = fopen(path, "r");
	if(csv == NULL) return;
	fgets(buffer, sizeof(buffer), csv); //cabecalho

	while(fgets(buffer, sizeof(buffer), csv) != NULL && c->tamanho < CSV_LINES){
		Restaurante *r = parse_restaurante(buffer);
		if(r == NULL) break;

		c->restaurantes[c->tamanho++] = r;
	}
	fclose(csv);
}

Colecao_Restaurantes* ler_csv(){
	Colecao_Restaurantes* cr = (Colecao_Restaurantes*) malloc(sizeof(Colecao_Restaurantes));
	if (cr == NULL) return NULL;

	cr->tamanho = 0;
	cr->restaurantes = (Restaurante**) malloc(sizeof(Restaurante*)*CSV_LINES);
	if (cr->restaurantes == NULL){
		free(cr);
		return NULL;
	}

	char* path = "/tmp/restaurantes.csv";
	//char* path = "restaurantes.csv";
	ler_csv_colecao(cr, path);
	return cr;
}

void free_restaurante(Restaurante* r){
	// limpa itens que tiverem alocacao dinamica
	free(r->nome);
	free(r->cidade);

	//limpa os ponteiros "secundarios"/strings
	for(int i=0; i< r->n_tipos_cozinha; i++){
		free(r->tipos_cozinha[i]);
	}
	//limpa os ponteiros "primarios"/ ponteiros para as strings limpas acima
	free(r->tipos_cozinha);

	// limpa outras variaveis
	free(r);
}

void free_colecao_restaurante(Colecao_Restaurantes* cr){
	// limpa cada restaurante presente em restaurante**
	for(int i=0; i< cr->tamanho; i++){
		free_restaurante(cr->restaurantes[i]);
	}
	// limpa os ponteiros para cada restaurante.
	free(cr->restaurantes);

	free(cr);
}

/**
 SelectionSort utilizando como chave de comparacao o nome do restaurante.
 Comparacao entre nomes realizada pela funcao strcmp da string.h
 */
void selecao(Restaurante** r, int r_qtd, int* n_comparacoes, int* n_movimentacoes){
	//strcmp retorna 0 ser for igual
	//negativo ser a primeira string for menor
	//maior que 0 se a primeira for maior'

	for(int i=0; i< r_qtd-1; i++){
		int menor = i;
		for(int j=(i+1); j<r_qtd; j++){
			(*n_comparacoes)++;
			if(strcmp(r[j]->nome, r[menor]->nome) < 0) menor = j;
		}
		Restaurante* tmp = r[i];
		r[i] = r[menor];
		r[menor] = tmp;
		(*n_movimentacoes) += 3;
	}
}

/**
 Pesquisa binaria utilizando de nome como chave de busca
 Comparacao entre nomes realizada pela funcao strcmp da string.h
 */
bool pesquisa_binaria(Restaurante** r, int r_qtd, char* s, int* n_comparacoes){
	bool resp = false;
	int dir = r_qtd-1, esq = 0, meio;
	while(esq <= dir){
		meio = (esq + dir)/2;
		if(strcmp(s, r[meio]->nome) == 0){
			(*n_comparacoes)++;
			resp = true;
			esq = dir+1;
		}else if(strcmp(s, r[meio]->nome) > 0){
			(*n_comparacoes)+=2;
			esq = meio+1;
		}else{
			dir = meio-1; 
		}
	}
	return resp;
}

void sanitize(char* str){
  for(int i=0; str[i] != '\0'; i++){
    if(str[i] == '\n' || str[i] == '\r'){
      str[i] = '\0';
      break;
    }
  }
}

int main(){
	Colecao_Restaurantes* db = ler_csv();

	Restaurante* r[CSV_LINES];
	int r_qtd = 0;

	char output[1024];
	int buffer_id;
	while(scanf("%d", &buffer_id) != EOF){
		if(buffer_id == -1) break;

		for(int i=0; i<db->tamanho; i++){
			if(db->restaurantes[i]->id == buffer_id){
				r[r_qtd++] = db->restaurantes[i];
				break;
			}
		}
	}
	// Come os espaços em branco (incluindo \r, \n, tabs) deixados pelo scanf
	scanf(" ");

	//selecao para garantir que esta ordenado para pesquisa binaria
	int n_comparacoes=0, n_movimentacoes=0;
	selecao(r, r_qtd, &n_comparacoes, &n_movimentacoes);
	n_comparacoes = 0;

	double tempo = 0.0;

	char buffer[256];
	while(fgets(buffer, 256, stdin) != NULL){
		sanitize(buffer);
		if(buffer[0] == 'F' && buffer[1] == 'I' && buffer[2] == 'M') break;
		clock_t start = clock();
		if(pesquisa_binaria(r, r_qtd, buffer, &n_comparacoes)){
			printf("SIM\n");
		}else{
			printf("NAO\n");
		}
		clock_t end = clock();
		tempo += (double)((end - start)) / CLOCKS_PER_SEC;
	}

	FILE* arq = fopen("892486_binaria.txt", "w");
	if(arq != NULL){
		fprintf(arq, "892486\t%d\t%lf\n", n_comparacoes, tempo);
		fclose(arq);
	}
	free_colecao_restaurante(db);
}
