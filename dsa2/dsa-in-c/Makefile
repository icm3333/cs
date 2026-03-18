# 1. Configurações Gerais
CC = gcc
CFLAGS = -Wall -Wextra -I include

# 2. Detecção do Sistema Operacional (Apenas para a extensão do executável)
ifeq ($(OS),Windows_NT)
	TARGET = main.exe
else
	TARGET = main
endif

# 3. Mapeamento de Arquivos
SRCS = main.c $(wildcard src/*.c)
OBJS = $(SRCS:.c=.o)

# 4. Regras de Compilação
all: $(TARGET)

$(TARGET): $(OBJS)
	$(CC) $(CFLAGS) -o $@ $^

%.o: %.c
	$(CC) $(CFLAGS) -c $< -o $@

# 5. Regra de Limpeza
# O w64devkit no Windows e o Linux entendem o comando 'rm' nativamente
clean:
	rm -f $(OBJS) $(TARGET)